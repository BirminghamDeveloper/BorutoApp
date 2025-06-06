package com.hashinology.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.hashinology.borutoapp.data.repository.Repository
import com.hashinology.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repo: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>>{
        return repo.getAllHeroes()
    }
}