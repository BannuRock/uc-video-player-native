package com.ucplayer.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ucplayer.app.core.cache.CacheManager
import com.ucplayer.app.core.network.NetworkClient
import com.ucplayer.app.feature.home.HomeScreen
import com.ucplayer.app.feature.home.HomeViewModel
import com.ucplayer.app.feature.player.PlayerScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var cacheManager: CacheManager

    @Inject
    lateinit var networkClient: NetworkClient

    @Inject
    lateinit var loopbackServer: com.ucplayer.app.core.stream.LoopbackServer

    @Inject
    lateinit var sessionManager: com.ucplayer.app.core.stream.SessionManager

    @Inject
    lateinit var torrentEngine: com.ucplayer.app.core.torrent.TorrentEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        android.util.Log.e("MainActivity", "onCreate ENTERED")
        try {
            loopbackServer.start()
            android.util.Log.e("MainActivity", "loopbackServer.start() SUCCESS")
        } catch (e: Exception) {
            android.util.Log.e("MainActivity", "loopbackServer.start() FAILED", e)
        }
        setContent {
            android.util.Log.e("MainActivity", "setContent Compose block ENTERED")
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var activeVideoUrl by remember { mutableStateOf<String?>(null) }
            var activeVideoTitle by remember { mutableStateOf("") }
            var activeVideoHeaders by remember { mutableStateOf<Map<String, String>>(emptyMap()) }

            var isResolvingMetadata by remember { mutableStateOf(false) }
            var resolvedFiles by remember { mutableStateOf<List<String>>(emptyList()) }
            var currentSessionId by remember { mutableStateOf("") }
            var currentTitle by remember { mutableStateOf("") }
            var showFileSelector by remember { mutableStateOf(false) }
            val scope = rememberCoroutineScope()
            if (activeVideoUrl == null) {
                HomeScreen(
                    viewModel = homeViewModel,
                    onPlayVideo = { url, title, headers, isTorrent ->
                        com.ucplayer.app.core.stream.PlaybackTracker.start()
                        com.ucplayer.app.core.stream.PlaybackTracker.log("Create Streaming Session")
                        isResolvingMetadata = true
                        currentTitle = title
                        val sessionId = "session_${System.currentTimeMillis()}"
                        currentSessionId = sessionId
 
                        scope.launch {
                            try {
                                val session = sessionManager.getOrCreateTorrentSession(url, sessionId)
                                session.provider.prepare() // Suspends until metadata resolves
                                val files = session.provider.getTorrentFiles()
                                isResolvingMetadata = false
                                if (files.size > 1) {
                                    resolvedFiles = files
                                    showFileSelector = true
                                } else {
                                    val port = loopbackServer.getPort()
                                    activeVideoUrl = "http://127.0.0.1:$port/stream/$sessionId?file=0"
                                    com.ucplayer.app.core.stream.PlaybackTracker.log("Loopback URL Created")
                                    activeVideoTitle = title
                                    activeVideoHeaders = headers
                                }
                            } catch (e: Exception) {
                                isResolvingMetadata = false
                                android.widget.Toast.makeText(this@MainActivity, "Failed to resolve metadata: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                )
            } else {
                PlayerScreen(
                    videoUrl = activeVideoUrl!!,
                    title = activeVideoTitle,
                    headers = activeVideoHeaders,
                    cacheManager = cacheManager,
                    networkClient = networkClient,
                    sessionManager = sessionManager,
                    onBack = {
                        activeVideoUrl = null
                    }
                )
            }

            // Metadata Resolution Loader Overlay Dialog
            if (isResolvingMetadata) {
                androidx.compose.ui.window.Dialog(onDismissRequest = { isResolvingMetadata = false }) {
                    androidx.compose.material3.Card(
                        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color(0xFF1E1E1E)),
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            androidx.compose.material3.CircularProgressIndicator(color = androidx.compose.ui.graphics.Color(0xFFF9690E))
                            Spacer(modifier = Modifier.height(16.dp))
                            androidx.compose.material3.Text(
                                text = "Resolving Torrent Metadata...",
                                color = androidx.compose.ui.graphics.Color.White,
                                fontSize = 16.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            androidx.compose.material3.Text(
                                text = "Connecting to peer swarm trackers",
                                color = androidx.compose.ui.graphics.Color.Gray,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }

            // Episode/File Selector Dialog Overlay
            if (showFileSelector && resolvedFiles.isNotEmpty()) {
                androidx.compose.ui.window.Dialog(onDismissRequest = { showFileSelector = false }) {
                    androidx.compose.material3.Card(
                        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color(0xFF1E1E1E)),
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 400.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            androidx.compose.material3.Text(
                                text = "Select File/Episode to Stream",
                                color = androidx.compose.ui.graphics.Color(0xFFF9690E),
                                fontSize = 16.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )
                            androidx.compose.material3.HorizontalDivider(color = androidx.compose.ui.graphics.Color.DarkGray)
                            LazyColumn(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(vertical = 8.dp)
                            ) {
                                itemsIndexed(resolvedFiles) { index, filePath ->
                                    val fileName = filePath.substringAfterLast("/")
                                    val isVideo = filePath.endsWith(".mp4", ignoreCase = true) ||
                                            filePath.endsWith(".mkv", ignoreCase = true) ||
                                            filePath.endsWith(".avi", ignoreCase = true)
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clickable {
                                                showFileSelector = false
                                                val port = loopbackServer.getPort()
                                                activeVideoUrl = "http://127.0.0.1:$port/stream/$currentSessionId?file=$index"
                                                com.ucplayer.app.core.stream.PlaybackTracker.log("Loopback URL Created")
                                                activeVideoTitle = currentTitle
                                            }
                                            .padding(vertical = 10.dp, horizontal = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        androidx.compose.material3.Icon(
                                            imageVector = Icons.Default.PlayArrow,
                                            contentDescription = "File Type",
                                            tint = if (isVideo) androidx.compose.ui.graphics.Color(0xFF2ECC71) else androidx.compose.ui.graphics.Color.Gray,
                                            modifier = Modifier.size(20.dp)
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        androidx.compose.material3.Text(
                                            text = fileName,
                                            color = if (isVideo) androidx.compose.ui.graphics.Color.White else androidx.compose.ui.graphics.Color.Gray,
                                            fontSize = 14.sp,
                                            fontWeight = if (isVideo) androidx.compose.ui.text.font.FontWeight.SemiBold else androidx.compose.ui.text.font.FontWeight.Normal,
                                            maxLines = 1,
                                            overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                                        )
                                    }
                                    androidx.compose.material3.HorizontalDivider(color = androidx.compose.ui.graphics.Color(0xFF2D2D2D))
                                }
                            }
                            androidx.compose.material3.Button(
                                onClick = {
                                    showFileSelector = false
                                    val port = loopbackServer.getPort()
                                    activeVideoUrl = "http://127.0.0.1:$port/stream/$currentSessionId?file=-1"
                                    com.ucplayer.app.core.stream.PlaybackTracker.log("Loopback URL Created")
                                    activeVideoTitle = currentTitle
                                },
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color.DarkGray),
                                modifier = Modifier.align(Alignment.End)
                            ) {
                                androidx.compose.material3.Text("Play Default (Largest)", color = androidx.compose.ui.graphics.Color.White)
                            }
                        }
                    }
                }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loopbackServer.stop()
        kotlinx.coroutines.runBlocking {
            sessionManager.clearAll()
            torrentEngine.stop()
        }
    }
}
