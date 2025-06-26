package com.hashinology.presentation.screens.search

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.hashinology.presentation.common.ListContent

@Composable
fun SearchScreen() {
    Scaffold (
        topBar = {
            SearchTopBar(
                text = "",
                onTextChanged = {},
                onSearch = {},
                onClosClicked = {}
            )
        }
    ){ innerPadding ->
       innerPadding
    }
}