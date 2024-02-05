package com.tiooooo.newsapp.ui.component.top_bar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsHomeTopBar(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Good Morning,",
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
                Text(
                    modifier = Modifier.padding(start = EXTRA_SMALL_PADDING),
                    text = "Tio!",
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }
        },
        actions = {
            IconButton(onClick = { onSearchClick() }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = MaterialTheme.colorScheme.tertiary,
                )
            }
        },
    )
}

@Preview
@Composable
fun NewsTopBarPreview() {
    NewsHomeTopBar() {

    }
}
