package com.hashinology.borutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hashinology.borutoapp.data.local.BorutoDatabase
import com.hashinology.borutoapp.data.paging_source.HeroRemoteMediator
import com.hashinology.borutoapp.data.paging_source.SearchHeroSource
import com.hashinology.borutoapp.data.remote.BorutoApi
import com.hashinology.borutoapp.utils.Constants.ITEMS_PER_PAGE
import com.hashinology.domain.repoistory.RemoteDataSource
import com.hashinology.domain.model.Hero
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
): RemoteDataSource {
    private val heroDao = borutoDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroSource(borutoApi = borutoApi, query = query)
            }
        ).flow
    }
}