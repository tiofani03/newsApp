package com.tiooooo.newsapp.ui.component.top_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchTopBar(
    modifier: Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    SearchWidget(
        modifier = modifier,
        text = text,
        onTextChange = onTextChange,
        onSearchClicked = onSearchClicked,
        onCloseClicked = onCloseClicked
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchWidget(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var isClicked by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier,
        shadowElevation = 4.dp,
    ) {
        TextField(
            modifier = Modifier,
            value = text,
            onValueChange = { onTextChange(it) },
            placeholder = {
                Text(
                    text = "Search here...",
                    color = MaterialTheme.colorScheme.tertiary,
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(modifier = Modifier, onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search",
                        tint = MaterialTheme.colorScheme.tertiary,
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (text.isNotEmpty()) onTextChange("") else {
                        isClicked = !isClicked
                        if (isClicked) {
                            keyboardController?.hide()
                            onCloseClicked()
                        }
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close",
                        tint = MaterialTheme.colorScheme.tertiary,
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,
            ),
            keyboardActions = KeyboardActions(onSearch = {
                keyboardController?.hide()
                onSearchClicked(text)
            }),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                disabledContainerColor = MaterialTheme.colorScheme.background,
            )
        )
    }
}

@Composable
@Preview
fun SearchWidgetPreview() {
    SearchWidget(
        modifier = Modifier
            .fillMaxWidth()
            .width(54.dp),
        text = "", onTextChange = {}, onSearchClicked = {}
    ) {

    }
}
