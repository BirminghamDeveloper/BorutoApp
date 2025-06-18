package com.hashinology.presentation.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.annotation.ExperimentalCoilApi
import com.hashinology.presentation.common.ListContent

@OptIn(ExperimentalCoilApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeVM: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeVM.getAllHeroes.collectAsLazyPagingItems()

    Log.d("HomeScreen", "HomeScreen: ${allHeroes.loadState.toString()}")

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