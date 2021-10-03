package com.sslabs.smashbrosultimate.di.module

import com.sslabs.smashbrosultimate.data.api.ApiMapper
import com.sslabs.smashbrosultimate.data.api.SmashBrosApi
import com.sslabs.smashbrosultimate.data.local.db.DbMapper
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.repository.fighter.IFighterRepository
import com.sslabs.smashbrosultimate.repository.fighter.FighterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideFighterRepository(
        smashBrosApi: SmashBrosApi,
        fighterDao: FighterDao,
        cacheMapper: DbMapper,
        apiMapper: ApiMapper
    ): IFighterRepository = FighterRepositoryImpl(
        smashBrosApi,
        fighterDao,
        cacheMapper,
        apiMapper
    )
}
