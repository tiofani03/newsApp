package com.tiooooo.newsapp.ui.screen.detail

import com.tiooooo.newsapp.ui.component.top_bar.NewsTopBar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tiooooo.newsapp.data.model.Article
import com.tiooooo.newsapp.data.model.article1
import com.tiooooo.newsapp.data.model.calculateMinutesBasedOnCharCount
import com.tiooooo.newsapp.data.model.convertDateFormat
import com.tiooooo.newsapp.ui.screen.webview.WebViewScreen
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING

class DetailScreen(
    private val article: Article,
) : Screen {
    @Composable
    override fun Content() {
        DetailContent(article)
    }
}


@Composable
fun DetailContent(article: Article) {
    val navigator = LocalNavigator.currentOrThrow
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            NewsTopBar(title = "Detail Article")
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            item {
                Column {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = MEDIUM_PADDING)
                            .padding(top = EXTRA_SMALL_PADDING),
                        text = article.title,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    )

                    Text(
                        modifier = Modifier
                            .padding(horizontal = MEDIUM_PADDING)
                            .padding(top = EXTRA_SMALL_PADDING),
                        text = "${article.author}  •  ${convertDateFormat(article.publishedAt)} • ${
                            calculateMinutesBasedOnCharCount(
                                article.content
                            )
                        } min read",
                        fontWeight = FontWeight.Light,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    )

                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = MEDIUM_PADDING),
                        model = ImageRequest
                            .Builder(
                                context = LocalContext.current
                            )
                            .data(article.urlToImage)
                            .crossfade(true)
                            .build(),
//                error = painterResource(R.drawable.ic_placeholder),
//                placeholder = painterResource(R.drawable.ic_placeholder),
                        contentDescription = "content Image",
                        contentScale = ContentScale.Crop
                    )

                    Text(
                        modifier = Modifier
                            .padding(MEDIUM_PADDING),
                        text = article.description,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    )

                    Text(
                        modifier = Modifier
                            .clickable {
                                navigator.push(WebViewScreen(article.url))
                            }
                            .padding(horizontal = MEDIUM_PADDING),
                        text = "Read more",
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.tertiary,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DetailContentPreview() {
    DetailContent(article = article1)
}

