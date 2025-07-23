package com.hashinology.domain.repoistory

import androidx.paging.PagingData
import com.hashinology.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
    fun searchHeroes(query: String): Flow<PagingData<Hero>>
}