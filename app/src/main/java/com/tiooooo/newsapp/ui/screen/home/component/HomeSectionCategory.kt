package com.tiooooo.newsapp.ui.screen.home.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.tiooooo.newsapp.data.model.Category
import com.tiooooo.newsapp.data.model.dummyCategory
import com.tiooooo.newsapp.ui.component.item.ItemCategory
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING

@Composable
fun HomeSectionCategory(
    modifier: Modifier = Modifier,
    contentPaddingValues: PaddingValues = PaddingValues(horizontal = MEDIUM_PADDING),
    contentPadding: Dp = EXTRA_SMALL_PADDING,
    onItemClicked: (Category) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = contentPaddingValues,
    ) {
        items(dummyCategory) {
            ItemCategory(
                modifier = Modifier
                    .padding(contentPadding),
                category = it,
                onItemClicked = onItemClicked
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun HomeSectionCategoryPreview() {
    HomeSectionCategory(
        modifier = Modifier.fillMaxWidth(),
    ) {

    }
}
