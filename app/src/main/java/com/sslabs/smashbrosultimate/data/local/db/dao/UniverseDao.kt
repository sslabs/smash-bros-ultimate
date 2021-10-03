package com.sslabs.smashbrosultimate.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sslabs.smashbrosultimate.UniverseDbConstants
import com.sslabs.smashbrosultimate.data.local.db.entity.UniverseCacheEntity

@Dao
interface UniverseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fighterEntities: List<UniverseCacheEntity>)

    @Query("DELETE FROM ${UniverseDbConstants.TABLE_NAME}")
    suspend fun deleteAll()

    @Query("SELECT * FROM ${UniverseDbConstants.TABLE_NAME}")
    suspend fun getAll(): List<UniverseCacheEntity>
}