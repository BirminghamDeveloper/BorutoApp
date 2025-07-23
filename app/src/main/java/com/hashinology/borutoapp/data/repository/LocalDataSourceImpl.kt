package com.hashinology.borutoapp.data.repository

import com.hashinology.borutoapp.data.local.BorutoDatabase
import com.hashinology.domain.model.Hero
import com.hashinology.domain.repoistory.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase): LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}