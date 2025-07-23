package com.hashinology.presentation.screens.details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashinology.borutoapp.utils.Constants
import com.hashinology.borutoapp.utils.Constants.DETAILS_ARGUMENT_KEY
import com.hashinology.domain.model.Hero
import com.hashinology.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedHero: MutableStateFlow<Hero?> = MutableStateFlow(null)
    val selectedHero: StateFlow<Hero?> = _selectedHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedHero.value = heroId?.let { useCases.getSelectedHeroUseCase(heroId = heroId) }
        }
    }

    private val _uiEvent: MutableState<UiEvent?> = mutableStateOf(null)
    val uiEvent: State<UiEvent?> = _uiEvent

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette

    fun generateColorPalette() {
        viewModelScope.launch {
            _uiEvent.value = UiEvent.GenerateColorPalette
        }
    }

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }

}

sealed class UiEvent {
    data object GenerateColorPalette : UiEvent()
}