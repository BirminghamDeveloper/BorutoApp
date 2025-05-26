package com.hashinology.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hashinology.borutoapp.data.local.dao.HeroDao
import com.hashinology.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.hashinology.domain.model.Hero
import com.hashinology.domain.model.HeroRemoteKey

@Database(
    entities = [Hero::class, HeroRemoteKey::class],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}