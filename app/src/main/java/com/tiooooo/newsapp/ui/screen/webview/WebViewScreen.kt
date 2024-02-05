package com.tiooooo.newsapp.ui.screen.webview

import com.tiooooo.newsapp.ui.component.top_bar.NewsTopBar
import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.newsapp.ui.theme.SMALL_PADDING

class WebViewScreen(
    private val url: String,
) : Screen {
    @SuppressLint("SetJavaScriptEnabled")
    @Composable
    override fun Content() {
        var loading by remember { mutableStateOf(true) }

        if (loading) {
            Dialog(onDismissRequest = {
                loading = false
            }) {
                Surface(
                    modifier = Modifier.size(150.dp),
                    shape = RoundedCornerShape(size = SMALL_PADDING),
                ) {
                    Column(
                        modifier = Modifier.padding(MEDIUM_PADDING),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(56.dp),
                        )

                        Text(
                            modifier = Modifier.padding(top = MEDIUM_PADDING),
                            text = "Loading...",
                            fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        )
                    }
                }
            }
        }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                NewsTopBar(title = "Detail Article")
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            settings.javaScriptEnabled = true
                            webViewClient = object : WebViewClient() {
                                override fun onPageFinished(view: WebView?, url: String?) {
                                    loading = false
                                }

                                override fun onPageStarted(
                                    view: WebView?,
                                    url: String?,
                                    favicon: Bitmap?,
                                ) {
                                    loading = true
                                }
                            }
                            settings.loadWithOverviewMode = true
                            settings.useWideViewPort = true
                            settings.setSupportZoom(true)
                        }
                    },
                    update = { webView ->
                        webView.loadUrl(url)
                    }
                )
            }
        }
    }
}

