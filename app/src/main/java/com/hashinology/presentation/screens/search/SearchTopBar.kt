package com.hashinology.presentation.screens.search

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.MaterialTheme
import com.hashinology.borutoapp.R
import com.hashinology.borutoapp.ui.theme.TOP_APP_BAR_HEIGHT
import com.hashinology.borutoapp.ui.theme.topAppBarBackgroundColor
import com.hashinology.borutoapp.ui.theme.topAppBarContentColor

@Composable
fun SearchTopBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClosClicked: () -> Unit
) {
    SearchWidget(
        text = text,
        onTextChanged = onTextChanged,
        onSearch = onSearch,
        onClosClicked = onClosClicked
    )
}

@Composable
fun SearchWidget(
    text: String,
    onTextChanged: (String) -> Unit,
    onSearch: (String) -> Unit,
    onClosClicked: () -> Unit
) {
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        shadowElevation = 4.dp,
        tonalElevation  = 4.dp,
        color = topAppBarBackgroundColor
    ){
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { onTextChanged(it) },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Search here ...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = topAppBarContentColor
            ),
            singleLine = true,
            leadingIcon =
            {
                IconButton(
                    modifier = Modifier.alpha(alpha = ContentAlpha.medium),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_icon),
                        tint = topAppBarContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {
                        if (text.isNotEmpty()){
                            onTextChanged("")
                        }else{
                            onClosClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = topAppBarContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearch(text)
                }
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                cursorColor = topAppBarContentColor
            )
        )
    }
}

@Preview
@Composable
private fun SearchWidgetPreview() {
    SearchWidget(
        text = "",
        onTextChanged = {},
        onSearch = {},
        onClosClicked = {}
    )
}