package com.hashinology.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.annotation.ExperimentalCoilApi
import com.hashinology.borutoapp.utils.Constants.BASE_URL
import com.hashinology.borutoapp.utils.PaletteGenerator.convertImageUrlToBitmap
import com.hashinology.borutoapp.utils.PaletteGenerator.extractColorsFromBitmap

@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    onCloseClicked : () -> Unit,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val selectedHero by detailsViewModel.selectedHero.collectAsState()
    val colorPalette by detailsViewModel.colorPalette
    val uiEvent by detailsViewModel.uiEvent

    LaunchedEffect(key1 = uiEvent) {
        when (uiEvent) {
            is UiEvent.GenerateColorPalette -> {
                val bitmap = convertImageUrlToBitmap(
                    imageUrl = "$BASE_URL${selectedHero?.image}",
                    context = context
                )
                if (bitmap != null) {
                    detailsViewModel.setColorPalette(
                        colors = extractColorsFromBitmap(
                            bitmap = bitmap
                        )
                    )
                }
            }
            else -> {}
        }
    }

    if (colorPalette.isNotEmpty()) {
        DetailsContent(
            onCloseClicked = onCloseClicked,
            selectedHero = selectedHero,
            colors = colorPalette
        )
    } else {
        detailsViewModel.generateColorPalette()
    }
}

@Preview
@Composable
private fun PreviewDetailsScreen() {
    DetailsScreen({})
}