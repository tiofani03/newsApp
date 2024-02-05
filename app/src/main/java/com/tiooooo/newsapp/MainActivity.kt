package com.tiooooo.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.tiooooo.newsapp.ui.screen.home.HomeScreen
import com.tiooooo.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            NewsAppTheme {
                Navigator(HomeScreen()) { navigator ->
                    SlideTransition(navigator)
                }
            }
        }
    }
}
