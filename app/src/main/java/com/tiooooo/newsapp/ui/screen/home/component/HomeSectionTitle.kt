package com.tiooooo.newsapp.ui.screen.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeSectionTitle(
    modifier: Modifier = Modifier,
    title: String = "Discovery",
    subtitle: String? = null,
    rightText: String? = null,
    onRightClicked: () -> Unit?,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
            )
            rightText?.let {
                Text(
                    modifier = Modifier.clickable {
                        onRightClicked.invoke()
                    },
                    text = rightText,
                    fontWeight = FontWeight.Light,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                )
            }
        }
        subtitle?.let {
            Text(
                text = subtitle,
                fontWeight = FontWeight.Light,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = true, name = "Light Mode")
@Composable
fun HomeSectionTitlePrev() {
    HomeSectionTitle(
        modifier = Modifier.fillMaxWidth(),
        title = "Discovery",
        subtitle = "Enjoy morning coffee with news",
        rightText = "View more",
    ){

    }
}
