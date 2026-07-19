package com.ucplayer.app.feature.player

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.media3.common.MediaItem
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.datasource.okhttp.OkHttpDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.ui.PlayerView
import com.ucplayer.app.core.cache.CacheManager
import com.ucplayer.app.core.network.NetworkClient
import com.ucplayer.app.core.stream.SessionManager
import com.ucplayer.app.core.stream.models.PieceState
import com.ucplayer.app.core.stream.models.StreamState

@androidx.media3.common.util.UnstableApi
@Composable
fun PlayerScreen(
    videoUrl: String,
    title: String,
    headers: Map<String, String>,
    cacheManager: CacheManager,
    networkClient: NetworkClient,
    sessionManager: SessionManager,
    onBack: () -> Unit
) {
    val context = LocalContext.current

    // Parse session ID from loopback URL
    val sessionId = remember(videoUrl) {
        if (videoUrl.contains("/stream/")) {
            videoUrl.substringAfter("/stream/").substringBefore("?")
        } else {
            null
        }
    }

    val streamSession = remember(sessionId) {
        sessionId?.let { sessionManager.getSession(it) }
    }

    // Collect stream state & statistics reactive flows if playing from torrent
    val streamState by (streamSession?.state?.collectAsState() ?: remember { mutableStateOf(StreamState.CREATED) })
    val stats by (streamSession?.statistics?.collectAsState() ?: remember { mutableStateOf(null) })

    // Retrieve file list from current torrent session
    val torrentFiles = remember(stats) {
        streamSession?.provider?.getTorrentFiles() ?: emptyList()
    }
    var showFileSelector by remember { mutableStateOf(false) }

    // Initialize ExoPlayer with OkHttp + Caching
    val exoPlayer = remember {
        val okHttpDataSourceFactory = OkHttpDataSource.Factory(networkClient.okHttpClient)
        if (headers.isNotEmpty()) {
            okHttpDataSourceFactory.setDefaultRequestProperties(headers)
        }

        val cacheDataSourceFactory = CacheDataSource.Factory()
            .setCache(cacheManager.mediaCache)
            .setUpstreamDataSourceFactory(okHttpDataSourceFactory)
            .setFlags(CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR)

        val loadControl = DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                15000, // minBufferMs
                30000, // maxBufferMs
                1000,  // bufferForPlaybackMs (1 second instead of 2.5s)
                1500   // bufferForPlaybackAfterRebufferMs
            )
            .build()

        ExoPlayer.Builder(context)
            .setMediaSourceFactory(DefaultMediaSourceFactory(context).setDataSourceFactory(cacheDataSourceFactory))
            .setLoadControl(loadControl)
            .build()
            .apply {
                android.util.Log.e("PLAYER", "Video URL = $videoUrl")
                val mediaItem = MediaItem.fromUri(videoUrl)
                setMediaItem(mediaItem)
                prepare()
                com.ucplayer.app.core.stream.PlaybackTracker.log("Player Opened")
                addListener(object : androidx.media3.common.Player.Listener {
                    private var playbackStartedLogged = false

                    override fun onPlayerError(error: androidx.media3.common.PlaybackException) {
                        android.util.Log.e("PLAYER", "Player Error", error)
                    }

                    override fun onPlaybackStateChanged(state: Int) {
                        android.util.Log.e("PLAYER", "Playback State = $state")
                    }

                    override fun onRenderedFirstFrame() {
                        com.ucplayer.app.core.stream.PlaybackTracker.log("First Frame Rendered")
                    }

                    override fun onIsPlayingChanged(isPlaying: Boolean) {
                        if (isPlaying && !playbackStartedLogged) {
                            playbackStartedLogged = true
                            com.ucplayer.app.core.stream.PlaybackTracker.log("Playback Started")
                        }
                    }
                })
                playWhenReady = true
            }
    }

    // Check for multiple files in torrent session and trigger selector overlay
    LaunchedEffect(torrentFiles) {
        if (torrentFiles.size > 1 && !videoUrl.contains("file=")) {
            showFileSelector = true
            exoPlayer.pause()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // ExoPlayer Layout
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                PlayerView(ctx).apply {
                    player = exoPlayer
                    useController = true
                    layoutParams = FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            }
        )

        // Overlay controls
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Top Action bar: Back button & Title
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.background(Color.Black.copy(alpha = 0.6f), shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(Color.Black.copy(alpha = 0.6f), shape = CircleShape)
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }

            // Bottom HUD: Real-time Stats Overlay & Piece map visualizer
            if (stats != null) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .background(Color.Black.copy(alpha = 0.7f))
                        .padding(12.dp)
                ) {
                    // Speeds, Seeds, and State labels
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "State: $streamState",
                            color = Color.Green,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Speed: ${formatSpeed(stats!!.speed)} | Peers: ${stats!!.peers} (${stats!!.seeders}s)",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Buffered: ${(stats!!.progress * 100).toInt()}%",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Dynamic Piece Map Progress Timeline Canvas
                    val pieces = stats!!.pieceCompletion
                    if (pieces.isNotEmpty()) {
                        Canvas(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp)
                        ) {
                            val canvasWidth = size.width
                            val pieceCount = pieces.size
                            val pieceWidth = canvasWidth / pieceCount

                            for (i in 0 until pieceCount) {
                                val color = when (pieces[i]) {
                                    PieceState.DOWNLOADED, PieceState.VERIFIED -> Color(0xFF2ECC71) // Green
                                    PieceState.DOWNLOADING -> Color(0xFFE67E22) // Orange
                                    PieceState.REQUESTED -> Color(0xFF9B59B6) // Purple
                                    PieceState.FAILED -> Color(0xFFE74C3C) // Red
                                    PieceState.SKIPPED -> Color.DarkGray
                                    PieceState.EMPTY -> Color(0xFF333333) // Gray
                                }
                                drawRect(
                                    color = color,
                                    topLeft = Offset(x = i * pieceWidth, y = 0f),
                                    size = Size(width = pieceWidth + 0.5f, height = size.height)
                                )
                            }
                        }
                    }
                }
            }
        }

        // Multi-file selection dialog overlay
        if (showFileSelector && torrentFiles.isNotEmpty()) {
            Dialog(onDismissRequest = {
                showFileSelector = false
                exoPlayer.play()
            }) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 400.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Select File/Episode to Stream",
                            color = Color(0xFFE67E22),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                        HorizontalDivider(color = Color.DarkGray)
                        LazyColumn(
                            modifier = Modifier
                                .weight(1f)
                                .padding(vertical = 8.dp)
                        ) {
                            itemsIndexed(torrentFiles) { index, filePath ->
                                val fileName = filePath.substringAfterLast("/")
                                val isVideo = filePath.endsWith(".mp4", ignoreCase = true) ||
                                        filePath.endsWith(".mkv", ignoreCase = true) ||
                                        filePath.endsWith(".avi", ignoreCase = true)
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            showFileSelector = false
                                            val separator = if (videoUrl.contains("?")) "&" else "?"
                                            val newUrl = "$videoUrl${separator}file=$index"
                                            exoPlayer.setMediaItem(MediaItem.fromUri(newUrl))
                                            exoPlayer.prepare()
                                            exoPlayer.play()
                                        }
                                        .padding(vertical = 10.dp, horizontal = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = if (isVideo) Icons.Default.PlayArrow else Icons.Default.Clear,
                                        contentDescription = "File Type",
                                        tint = if (isVideo) Color(0xFF2ECC71) else Color.Gray,
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = fileName,
                                        color = if (isVideo) Color.White else Color.Gray,
                                        fontSize = 14.sp,
                                        fontWeight = if (isVideo) FontWeight.SemiBold else FontWeight.Normal,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                                HorizontalDivider(color = Color(0xFF2D2D2D))
                            }
                        }
                        Button(
                            onClick = {
                                showFileSelector = false
                                exoPlayer.play()
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Play Default", color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

private fun formatSpeed(bytesPerSec: Long): String {
    if (bytesPerSec <= 0) return "0 B/s"
    val kb = bytesPerSec / 1024f
    if (kb < 1024) return String.format(java.util.Locale.US, "%.1f KB/s", kb)
    val mb = kb / 1024f
    return String.format(java.util.Locale.US, "%.1f MB/s", mb)
}
