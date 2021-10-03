package com.sslabs.smashbrosultimate.di.module

import com.sslabs.smashbrosultimate.data.api.SmashBrosApi
import com.sslabs.smashbrosultimate.data.api.mapper.FighterApiMapper
import com.sslabs.smashbrosultimate.data.api.mapper.UniverseApiMapper
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.data.local.db.dao.UniverseDao
import com.sslabs.smashbrosultimate.data.local.db.mapper.FighterDbMapper
import com.sslabs.smashbrosultimate.data.local.db.mapper.UniverseDbMapper
import com.sslabs.smashbrosultimate.repository.fighter.FighterRepositoryImpl
import com.sslabs.smashbrosultimate.repository.fighter.IFighterRepository
import com.sslabs.smashbrosultimate.repository.universe.IUniverseRepository
import com.sslabs.smashbrosultimate.repository.universe.UniverseRepositoryImpl
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
        fighterCacheMapper: FighterDbMapper,
        fighterApiMapper: FighterApiMapper
    ): IFighterRepository = FighterRepositoryImpl(
        smashBrosApi,
        fighterDao,
        fighterCacheMapper,
        fighterApiMapper
    )

    @Singleton
    @Provides
    fun provideUniverseRepository(
        smashBrosApi: SmashBrosApi,
        universeDao: UniverseDao,
        universeCacheMapper: UniverseDbMapper,
        universeApiMapper: UniverseApiMapper
    ): IUniverseRepository = UniverseRepositoryImpl(
        smashBrosApi,
        universeDao,
        universeCacheMapper,
        universeApiMapper
    )
}
