package com.sslabs.smashbrosultimate.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.data.local.db.entity.FighterCacheEntity

@Database(entities = [FighterCacheEntity::class], version = 1)
abstract class SmashBrosDatabase : RoomDatabase() {
    abstract fun fighterDao(): FighterDao

    companion object {
        const val DATABASE_NAME: String = "smash_bros.db"
    }
}