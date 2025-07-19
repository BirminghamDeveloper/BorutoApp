package com.hashinology.presentation.screens.search

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hashinology.presentation.common.ListContent

@ExperimentalMaterial3Api
@Composable
fun SearchScreen(
    navHostController: NavHostController,
    searchVM: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchVM.searchQuery
    val heroes = searchVM.searchedHero.collectAsLazyPagingItems()

    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    SearchTopBar(
                        text = searchQuery,
                        onTextChanged = {
                            searchVM.updateSearchQuery(query = it)
                        },
                        onSearch = {
                            searchVM.searchHeroes(query = it)
                        },
                        onClosClicked = {
                            navHostController.popBackStack()
                        }
                    )
                }
            )
        },
        content = { padding ->
            ListContent(
                padding = padding,
                heroes = heroes,
                navController = navHostController
            )
        }
    )
}