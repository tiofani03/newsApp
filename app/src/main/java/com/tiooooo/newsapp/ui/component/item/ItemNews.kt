package com.tiooooo.newsapp.ui.component.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tiooooo.newsapp.data.model.Article
import com.tiooooo.newsapp.data.model.article1
import com.tiooooo.newsapp.data.model.convertDateFormat
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.newsapp.ui.theme.SMALL_PADDING

@Composable
fun ItemNews(
    modifier: Modifier = Modifier,
    article: Article,
    onArticleClicked: (Article) -> Unit,
) {
    Surface(
        modifier = modifier.clickable {
            onArticleClicked.invoke(article)
        },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(10))
                    .size(80.dp),
                model = ImageRequest
                    .Builder(context = LocalContext.current)
                    .data(article.urlToImage)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
//                error = painterResource(R.drawable.ic_placeholder),
//                placeholder = painterResource(R.drawable.ic_placeholder),
                contentDescription = "content Image",
            )

            Column(
                modifier = Modifier.padding(start = SMALL_PADDING)
            ) {
                Text(
                    text = article.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = SMALL_PADDING),
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(end = EXTRA_SMALL_PADDING),
                        text = article.author,
                        fontWeight = FontWeight.Light,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = convertDateFormat(article.publishedAt),
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun ItemNewsPreview() {
    ItemNews(article = article1){

    }
}
