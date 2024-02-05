package com.tiooooo.newsapp.ui.component.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.tiooooo.newsapp.ui.theme.LARGE_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.newsapp.ui.theme.SMALL_PADDING

@Composable
fun ItemHeadline(
    modifier: Modifier = Modifier,
    article: Article,
    onHeadlineClicked: (Article) -> Unit,
) {
    Box(
        modifier = modifier
            .clickable {
                onHeadlineClicked.invoke(article)
            }
            .clip(RoundedCornerShape(LARGE_PADDING)),
        contentAlignment = Alignment.BottomStart,
    ) {
        Surface(
            shape = RoundedCornerShape(size = LARGE_PADDING),
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
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
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black.copy(alpha = 0.5f)
        ) {}

        Column(
            modifier = Modifier.padding(MEDIUM_PADDING),
        ) {
            Text(
                text = article.title,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                modifier = Modifier.padding(bottom = SMALL_PADDING),
                text = "3 Feb 2024",
                fontWeight = FontWeight.Light,
                color = Color.White,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
        }
    }
}

@Preview
@Composable
fun ItemHeadlinePreview() {
    ItemHeadline(
        modifier = Modifier.height(200.dp),
        article = article1
    ){

    }
}
