package com.sslabs.smashbrosultimate.repository.fighter

import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.DataState
import kotlinx.coroutines.flow.Flow

interface IFighterRepository {
    suspend fun getAllFighters(): Flow<DataState<List<Fighter>>>
}