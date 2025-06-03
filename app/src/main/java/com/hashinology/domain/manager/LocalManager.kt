package com.hashinology.domain.manager


import kotlinx.coroutines.flow.Flow

interface LocalManager {
    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}