package com.hashinology.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.hashinology.borutoapp.data.repository.Repository
import com.hashinology.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>>{
        return repository.searchQuery(query = query)
    }
}