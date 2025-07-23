package com.hashinology.domain.repoistory

import com.hashinology.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}