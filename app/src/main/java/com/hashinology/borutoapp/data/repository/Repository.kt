package com.hashinology.borutoapp.data.repository

import com.hashinology.domain.manager.LocalManager
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val localManager: LocalManager
){
    suspend fun saveOnBoadingState(completed: Boolean){
        localManager.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean>{
        return localManager.readOnBoardingState()
    }
}