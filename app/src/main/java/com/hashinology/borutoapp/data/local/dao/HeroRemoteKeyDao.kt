package com.hashinology.borutoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hashinology.domain.model.HeroRemoteKeys

@Dao
interface HeroRemoteKeyDao {
    @Query("SELECT * FROM hero_remote_key_table WHERE id= :id")
    suspend fun getRemoteKeys(id: Int): HeroRemoteKeys?
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKeys>)
    @Query("Delete FROM HERO_REMOTE_KEY_TABLE")
    suspend fun deleteAllRemoteKeys()
}