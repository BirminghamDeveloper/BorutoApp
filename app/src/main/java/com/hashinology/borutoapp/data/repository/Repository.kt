package com.hashinology.borutoapp.data.repository

import androidx.paging.PagingData
import com.hashinology.domain.manager.LocalManager
import com.hashinology.domain.manager.RemoteDataSource
import com.hashinology.domain.model.Hero
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remote: RemoteDataSource,
    private val localManager: LocalManager
){
    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    suspend fun saveOnBoadingState(completed: Boolean){
        localManager.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean>{
        return localManager.readOnBoardingState()
    }
}