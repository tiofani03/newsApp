package com.tiooooo.newsapp.ui.component.item

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.tiooooo.newsapp.data.model.Category
import com.tiooooo.newsapp.data.model.dummyCategory
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.newsapp.ui.theme.SMALL_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCategory(
    modifier: Modifier = Modifier,
    category: Category,
    onItemClicked: (Category) -> Unit,
) {
    Card(
        modifier = modifier,
        onClick = {
            onItemClicked.invoke(category)
        }
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(start = SMALL_PADDING)
                    .size(MEDIUM_PADDING)
                    .clip(CircleShape),
                model = ImageRequest
                    .Builder(
                        context = LocalContext.current
                    )
                    .data("https://avatars.githubusercontent.com/u/43690617?v=4")
                    .crossfade(true)
                    .build(),
//                error = painterResource(R.drawable.ic_placeholder),
//                placeholder = painterResource(R.drawable.ic_placeholder),
                contentDescription = "content Image",
            )
            Text(
                modifier = Modifier.padding(SMALL_PADDING),
                text = category.name,
                fontWeight = FontWeight.Light,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
        }
    }
}

@Preview
@Composable
fun ItemCategoryPreview() {
    ItemCategory(
        category = dummyCategory.first()
    ){}
}
