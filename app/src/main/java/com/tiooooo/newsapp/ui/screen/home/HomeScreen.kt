package com.tiooooo.newsapp.ui.screen.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tiooooo.newsapp.data.model.dummyListArticle
import com.tiooooo.newsapp.ui.component.item.ItemNews
import com.tiooooo.newsapp.ui.component.top_bar.NewsHomeTopBar
import com.tiooooo.newsapp.ui.screen.category.CategoryScreen
import com.tiooooo.newsapp.ui.screen.detail.DetailScreen
import com.tiooooo.newsapp.ui.screen.home.component.HomeSectionCategory
import com.tiooooo.newsapp.ui.screen.home.component.HomeSectionHeadline
import com.tiooooo.newsapp.ui.screen.home.component.HomeSectionTitle
import com.tiooooo.newsapp.ui.screen.search.SearchScreen
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING
import com.tiooooo.newsapp.ui.theme.MEDIUM_PADDING
import com.tiooooo.newsapp.ui.theme.SMALL_PADDING

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        var text by remember { mutableStateOf("") }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                NewsHomeTopBar {
                    navigator.push(SearchScreen())
                }
            },
        ) {


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {


                item {
                    HomeSectionTitle(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = MEDIUM_PADDING),
                        title = "Discovery",
                        subtitle = "Enjoy morning coffee with news",
                        onRightClicked = {},
                    )
                }
                item {
                    HomeSectionHeadline(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = SMALL_PADDING),
                        contentPadding = 4.dp,
                        contentHeight = 180.dp,
                        contentWidth = 300.dp,
                        contentPaddingValues = PaddingValues(horizontal = 12.dp),
                    ) { article ->
                        navigator.push(DetailScreen(article))
                    }
                }

                item {
                    HomeSectionTitle(
                        modifier = Modifier.run {
                            fillMaxWidth()
                                .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING)
                        },
                        title = "Category",
                        onRightClicked = {},
                    )
                }
                item {
                    HomeSectionCategory(
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentPadding = 4.dp,
                        contentPaddingValues = PaddingValues(horizontal = 12.dp),
                    ) { category ->
                        navigator.push(
                            CategoryScreen(
                                title = category.name,
                                queryParam = category.id.toString(),
                            )
                        )
                    }
                }
                item {
                    HomeSectionTitle(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = SMALL_PADDING, horizontal = MEDIUM_PADDING),
                        title = "Daily News",
                        rightText = "View More",
                        onRightClicked = {
                            navigator.push(CategoryScreen(title = "Daily News"))
                        },
                    )
                }
                items(dummyListArticle) { article ->
                    ItemNews(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = EXTRA_SMALL_PADDING),
                        article = article
                    ) { data ->
                        navigator.push(DetailScreen(data))
                    }
                }
            }
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {

}
