package com.tiooooo.newsapp.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tiooooo.newsapp.data.model.Article
import com.tiooooo.newsapp.data.model.dummyListArticle
import com.tiooooo.newsapp.ui.component.item.ItemHeadline
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING

@Composable
fun HomeSectionHeadline(
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = MEDIUM_PADDING),
    contentHeight: Dp = 180.dp,
    contentWidth: Dp = 300.dp,
    contentPadding: Dp = EXTRA_SMALL_PADDING,
    onHeadlineClicked: (Article) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPaddingValues,
    ) {
        items(dummyListArticle) {
            ItemHeadline(
                modifier = Modifier
                    .height(contentHeight)
                    .width(contentWidth)
                    .padding(contentPadding),
                article = it,
                onHeadlineClicked = onHeadlineClicked,
            )
        }
    }
}
