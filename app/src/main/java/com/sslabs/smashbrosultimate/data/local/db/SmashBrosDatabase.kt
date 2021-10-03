package com.sslabs.smashbrosultimate.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.data.local.db.dao.UniverseDao
import com.sslabs.smashbrosultimate.data.local.db.entity.FighterCacheEntity
import com.sslabs.smashbrosultimate.data.local.db.entity.UniverseCacheEntity

@Database(
    entities = [
        FighterCacheEntity::class,
        UniverseCacheEntity::class],
    version = 1
)
abstract class SmashBrosDatabase : RoomDatabase() {
    abstract fun fighterDao(): FighterDao
    abstract fun universeDao(): UniverseDao

    companion object {
        const val DATABASE_NAME: String = "smash_bros.db"
    }
}