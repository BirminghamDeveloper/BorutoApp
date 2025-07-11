package com.hashinology.borutoapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hashinology.domain.model.HeroRemoteKeys

@Dao
interface HeroRemoteKeysDao {
    @Query("SELECT * FROM hero_remote_keys_table WHERE id= :heroID")
    suspend fun getRemoteKeys(heroID: Int): HeroRemoteKeys?
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKeys>)
    @Query("Delete FROM hero_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}