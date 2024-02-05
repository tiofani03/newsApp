package com.tiooooo.newsapp.ui.screen.category

import com.tiooooo.newsapp.ui.component.top_bar.NewsTopBar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tiooooo.newsapp.data.model.dummyListArticle
import com.tiooooo.newsapp.ui.component.item.ItemNews
import com.tiooooo.newsapp.ui.screen.detail.DetailScreen
import com.tiooooo.newsapp.ui.theme.EXTRA_SMALL_PADDING

class CategoryScreen(
    private val title: String,
    private val queryParam: String? = null,
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                NewsTopBar(
                    title = title,
                )
            },
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
            ) {
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
