package com.sslabs.smashbrosultimate.repository.fighter

import com.sslabs.smashbrosultimate.data.api.mapper.FighterApiMapper
import com.sslabs.smashbrosultimate.data.api.SmashBrosApi
import com.sslabs.smashbrosultimate.data.local.db.mapper.FighterDbMapper
import com.sslabs.smashbrosultimate.data.local.db.dao.FighterDao
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FighterRepositoryImpl @Inject constructor(
    private val smashBrosApi: SmashBrosApi,
    private val fighterDao: FighterDao,
    private val fighterCacheMapper: FighterDbMapper,
    private val fighterApiMapper: FighterApiMapper,
) : IFighterRepository {

    override suspend fun getFighters(universeName: String?): Flow<DataState<List<Fighter>>> = flow {
        emit(DataState.Loading)
        try {
            val apiFighters = smashBrosApi.getFighters(universeName)
            val fighters = fighterApiMapper.mapFromEntityList(apiFighters)
            val dbFighters = fighterCacheMapper.mapToEntityList(fighters)
            fighterDao.deleteAll()
            fighterDao.insertAll(dbFighters)
            val cachedFighters = fighterDao.getAll()
            emit(DataState.Success(fighterCacheMapper.mapFromEntityList(cachedFighters)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
