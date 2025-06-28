package com.hashinology.presentation.screens.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.hashinology.presentation.common.ListContent

@ExperimentalMaterial3Api
@Composable
fun SearchScreen() {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    SearchTopBar(
                        text = "",
                        onTextChanged = {},
                        onSearch = {},
                        onClosClicked = {}
                    )
                },
            )
        }
    ){ innerPadding ->
       innerPadding
    }
}