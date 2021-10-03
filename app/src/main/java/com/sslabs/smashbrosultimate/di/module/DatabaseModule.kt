package com.sslabs.smashbrosultimate.di.module

import android.content.Context
import androidx.room.Room
import com.sslabs.smashbrosultimate.data.local.db.SmashBrosDatabase
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.data.local.db.dao.UniverseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): SmashBrosDatabase =
        Room.databaseBuilder(
            context,
            SmashBrosDatabase::class.java,
            SmashBrosDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideFighterDao(smashBrosDatabase: SmashBrosDatabase): FighterDao =
        smashBrosDatabase.fighterDao()

    @Singleton
    @Provides
    fun provideUniverseDao(smashBrosDatabase: SmashBrosDatabase): UniverseDao =
        smashBrosDatabase.universeDao()
}