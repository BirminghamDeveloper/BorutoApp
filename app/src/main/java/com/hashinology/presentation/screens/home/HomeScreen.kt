package com.hashinology.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hashinology.presentation.common.ListContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeVM: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeVM.getAllHeroesUseCase.invoke().collectAsLazyPagingItems(

    )

    Scaffold(
        topBar = {
            HomeTopBar( onSearchClicked = {} )
        },
        content = { padding ->
            ListContent(
                heroes = allHeroes,
                navController = navController,
                padding = padding
            )
        }
    )
}