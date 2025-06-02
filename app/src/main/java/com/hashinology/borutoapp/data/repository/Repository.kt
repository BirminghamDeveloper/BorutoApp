package com.hashinology.borutoapp.data.repository

import com.hashinology.domain.repositories.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreOperations: DataStoreOperations
){
    suspend fun saveOnBoadingState(completed: Boolean){
        dataStoreOperations.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean>{
        return dataStoreOperations.readOnBoardingState()
    }
}