package com.sslabs.smashbrosultimate.repository.universe

import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.util.DataState
import kotlinx.coroutines.flow.Flow

interface IUniverseRepository {
    suspend fun getAllUniverses(): Flow<DataState<List<Universe>>>
}