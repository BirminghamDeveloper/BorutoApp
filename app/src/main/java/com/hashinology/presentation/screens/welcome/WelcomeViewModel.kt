package com.hashinology.presentation.screens.welcome

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hashinology.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val useCase: UseCases
): ViewModel() {
    fun saveOnBoardingState(complete: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            /* rememebr that invoke() is suspended function so  to be called it
            you need either call it from another suspended or coroutine
             */
            useCase.saveOnBoardingUseCase.invoke(complete)
            useCase.readOnBoardingUseCase.invoke().collect{
                Log.d("Saved", "Button Status: $it")
            }

        }
    }
}