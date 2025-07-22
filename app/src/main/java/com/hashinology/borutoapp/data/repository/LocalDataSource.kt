package com.hashinology.borutoapp.data.repository

import com.hashinology.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}