package com.hashinology.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.hashinology.borutoapp.ui.theme.LARGE_PADDING
import com.hashinology.presentation.components.RatingWidget

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    homeVM: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeVM.getAllHeroesUseCase.invoke().collectAsLazyPagingItems(

    )

    Scaffold(
        topBar = {
            HomeTopBar( onSearchClicked = {} )
        }
    ) {
        RatingWidget(
            modifier = Modifier.padding(all = LARGE_PADDING),
            rating = 4.1
        )
    }
}