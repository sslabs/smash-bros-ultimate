package com.sslabs.smashbrosultimate.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sslabs.smashbrosultimate.FighterDbConstants
import com.sslabs.smashbrosultimate.data.local.db.entity.FighterCacheEntity

@Dao
interface FighterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fighterEntities: List<FighterCacheEntity>)

    @Query("DELETE FROM ${FighterDbConstants.TABLE_NAME}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${FighterDbConstants.TABLE_NAME}")
    suspend fun getAll(): List<FighterCacheEntity>
}