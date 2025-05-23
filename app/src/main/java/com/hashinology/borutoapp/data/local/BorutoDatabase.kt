package com.hashinology.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hashinology.borutoapp.data.local.dao.HeroDao
import com.hashinology.domain.model.Hero

@Database(
    entities = [Hero::class],
    version = 1
)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
}