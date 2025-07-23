package com.hashinology.borutoapp.data.repository

import androidx.paging.PagingData
import com.hashinology.domain.manager.LocalManager
import com.hashinology.domain.repoistory.RemoteDataSource
import com.hashinology.domain.model.Hero
import com.hashinology.domain.repoistory.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val localManager: LocalManager
){
    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchQuery(query: String): Flow<PagingData<Hero>>{
        return remote.searchHeroes(query =  query)
    }

    suspend fun getSelectedHero(heroId: Int): Hero{
        return local.getSelectedHero(heroId = heroId)
    }

    suspend fun saveOnBoadingState(completed: Boolean){
        localManager.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean>{
        return localManager.readOnBoardingState()
    }
}