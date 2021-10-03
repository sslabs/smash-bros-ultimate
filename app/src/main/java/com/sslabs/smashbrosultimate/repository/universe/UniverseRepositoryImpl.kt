package com.sslabs.smashbrosultimate.repository.universe

import com.sslabs.smashbrosultimate.data.api.SmashBrosApi
import com.sslabs.smashbrosultimate.data.api.mapper.UniverseApiMapper
import com.sslabs.smashbrosultimate.data.local.db.dao.UniverseDao
import com.sslabs.smashbrosultimate.data.local.db.mapper.UniverseDbMapper
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UniverseRepositoryImpl @Inject constructor(
    private val smashBrosApi: SmashBrosApi,
    private val universeDao: UniverseDao,
    private val universeCacheMapper: UniverseDbMapper,
    private val universeApiMapper: UniverseApiMapper,
) : IUniverseRepository {

    override suspend fun getAllUniverses(): Flow<DataState<List<Universe>>> = flow {
        emit(DataState.Loading)
        try {
            val apiUniverses = smashBrosApi.getUniverses()
            val universes = universeApiMapper.mapFromEntityList(apiUniverses)
            val dbUniverses = universeCacheMapper.mapToEntityList(universes)
            universeDao.deleteAll()
            universeDao.insertAll(dbUniverses)
            val cachedUniverses = universeDao.getAll()
            emit(DataState.Success(universeCacheMapper.mapFromEntityList(cachedUniverses)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}