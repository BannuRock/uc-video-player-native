package com.ucplayer.app.feature.home

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ucplayer.app.models.TorrentSource
import com.ucplayer.app.models.VideoInfo
import com.ucplayer.app.models.VideoSource

// Brand colors
val PrimaryOrange = Color(0xFFF9690E)
val BackgroundDark = Color(0xFF121212)
val CardGray = Color(0xFF1E1E1E)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onPlayVideo: (String, String, Map<String, String>, Boolean) -> Unit
) {
    android.util.Log.e("HomeScreen", "HomeScreen Composable ENTERED")
    var urlInput by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()
    val historyList by viewModel.historyList.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "UC PLAYER",
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundDark,
                    titleContentColor = Color.White
                )
            )
        },
        containerColor = BackgroundDark
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // URL Input Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = urlInput,
                    onValueChange = { urlInput = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Paste Video or Torrent Page URL...", color = Color.Gray) },
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        focusedBorderColor = PrimaryOrange,
                        unfocusedBorderColor = Color.DarkGray,
                        focusedContainerColor = CardGray,
                        unfocusedContainerColor = CardGray
                    ),
                    shape = RoundedCornerShape(8.dp),
                    trailingIcon = {
                        if (urlInput.isNotEmpty()) {
                            IconButton(onClick = { urlInput = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear", tint = Color.Gray)
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        viewModel.scrapeUrl(urlInput)
                    })
                )
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { viewModel.scrapeUrl(urlInput) },
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.height(56.dp)
                ) {
                    Text("Crawl", fontWeight = FontWeight.Bold)
                }
            }

            // Results and History Container
            Box(modifier = Modifier.weight(1f)) {
                when (val state = uiState) {
                    is HomeUiState.Idle -> {
                        // Show history if idle
                        if (historyList.isEmpty()) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "Ready to stream. Enter a link above to begin.",
                                    color = Color.Gray,
                                    fontSize = 15.sp
                                )
                            }
                        } else {
                            HistorySection(
                                historyList = historyList,
                                onEntryClick = { entry ->
                                    urlInput = entry.pageUrl
                                    viewModel.scrapeUrl(entry.pageUrl)
                                },
                                onDeleteClick = { viewModel.deleteHistoryEntry(it) },
                                onClearAllClick = { viewModel.clearHistory() }
                            )
                        }
                    }
                    is HomeUiState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                CircularProgressIndicator(color = PrimaryOrange)
                                Spacer(modifier = Modifier.height(16.dp))
                                Text("Analyzing target website...", color = Color.LightGray)
                            }
                        }
                    }
                    is HomeUiState.Error -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(24.dp)
                            ) {
                                Text("Crawling Failed", color = Color.Red, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(state.message, color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
                                Spacer(modifier = Modifier.height(16.dp))
                                Button(
                                    onClick = { viewModel.resetState() },
                                    colors = ButtonDefaults.buttonColors(containerColor = CardGray)
                                ) {
                                    Text("Back to Home", color = Color.White)
                                }
                            }
                        }
                    }
                    is HomeUiState.Success -> {
                        SuccessResults(
                            info = state.info,
                            onPlayVideo = onPlayVideo,
                            onBack = { viewModel.resetState() }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun HistorySection(
    historyList: List<com.ucplayer.app.core.database.HistoryEntry>,
    onEntryClick: (com.ucplayer.app.core.database.HistoryEntry) -> Unit,
    onDeleteClick: (com.ucplayer.app.core.database.HistoryEntry) -> Unit,
    onClearAllClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Recents & History",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.LightGray
            )
            Text(
                text = "Clear All",
                color = PrimaryOrange,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { onClearAllClick() }
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(historyList) { entry ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(CardGray)
                        .clickable { onEntryClick(entry) }
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = entry.title,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "${entry.website} • ${entry.pageUrl}",
                            color = Color.Gray,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    IconButton(onClick = { onDeleteClick(entry) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.Gray)
                    }
                }
            }
        }
    }
}

@Composable
fun SuccessResults(
    info: VideoInfo,
    onPlayVideo: (String, String, Map<String, String>, Boolean) -> Unit,
    onBack: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Crawl Results",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.LightGray
            )
            Text(
                text = "Back",
                color = PrimaryOrange,
                fontSize = 14.sp,
                modifier = Modifier
                    .clickable { onBack() }
                    .padding(8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = info.title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            if (info.videos.isNotEmpty()) {
                item {
                    Text(
                        text = "Video Streams",
                        color = PrimaryOrange,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
                items(info.videos) { video ->
                    VideoItem(video = video, onPlayClick = {
                        onPlayVideo(video.url, info.title, video.headers, false)
                    })
                }
            }

            if (info.torrents.isNotEmpty()) {
                item {
                    Text(
                        text = "Torrent Attachments (${info.torrents.size})",
                        color = PrimaryOrange,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 12.dp)
                    )
                }
                items(info.torrents) { torrent ->
                    TorrentItem(torrent = torrent, onPlayClick = {
                        onPlayVideo(torrent.url, torrent.name, emptyMap(), true)
                    })
                }
            }
        }
    }
}

@Composable
fun VideoItem(
    video: VideoSource,
    onPlayClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(CardGray)
            .clickable { onPlayClick() }
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Quality: ${video.quality}",
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = video.url,
                color = Color.Gray,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = onPlayClick,
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(PrimaryOrange)
        ) {
            Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color.White)
        }
    }
}

@Composable
fun TorrentItem(
    torrent: TorrentSource,
    onPlayClick: () -> Unit
) {
    val context = LocalContext.current
    Card(
        colors = CardDefaults.cardColors(containerColor = CardGray),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = torrent.name,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                // Transport Badge
                Box(
                    modifier = Modifier
                        .background(
                            if (torrent.isMagnet) PrimaryOrange.copy(alpha = 0.2f) else Color.Green.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = if (torrent.isMagnet) "MAGNET" else "TORRENT",
                        color = if (torrent.isMagnet) PrimaryOrange else Color.Green,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            
            Text(
                text = torrent.url,
                color = Color.Gray,
                fontSize = 11.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 6.dp)
            )

            HorizontalDivider(color = Color.DarkGray.copy(alpha = 0.5f), modifier = Modifier.padding(vertical = 8.dp))

            // Action row: Stream / Download
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Stream Button
                Button(
                    onClick = onPlayClick,
                    colors = ButtonDefaults.buttonColors(containerColor = PrimaryOrange),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Stream", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Download Button
                Button(
                    onClick = {
                        try {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(torrent.url))
                            context.startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(context, "No external app found for downloading", Toast.LENGTH_LONG).show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    shape = RoundedCornerShape(6.dp),
                    contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                    modifier = Modifier.height(32.dp)
                ) {
                    Text("Download", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
