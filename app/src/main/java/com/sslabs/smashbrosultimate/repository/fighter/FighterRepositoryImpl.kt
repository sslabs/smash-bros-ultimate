package com.sslabs.smashbrosultimate.repository.fighter

import com.sslabs.smashbrosultimate.data.api.ApiMapper
import com.sslabs.smashbrosultimate.data.api.SmashBrosApi
import com.sslabs.smashbrosultimate.data.local.db.DbMapper
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FighterRepositoryImpl @Inject constructor(
    private val smashBrosApi: SmashBrosApi,
    private val fighterDao: FighterDao,
    private val cacheMapper: DbMapper,
    private val apiMapper: ApiMapper,
) : IFighterRepository {

    override suspend fun getAllFighters(): Flow<DataState<List<Fighter>>> = flow {
        emit(DataState.Loading)
        try {
            val apiFighters = smashBrosApi.getFighters()
            val fighters = apiMapper.mapFromEntityList(apiFighters)
            val dbFighters = fighters.map { cacheMapper.toEntity(it) }
            fighterDao.deleteAll()
            fighterDao.insertAll(dbFighters)
            val cachedFighters = fighterDao.getAll()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedFighters)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
