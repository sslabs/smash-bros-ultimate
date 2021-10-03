package com.sslabs.smashbrosultimate.data.api

import com.sslabs.smashbrosultimate.ApiConstants
import com.sslabs.smashbrosultimate.data.api.entity.FighterApiEntity
import com.sslabs.smashbrosultimate.data.api.entity.UniverseApiEntity
import retrofit2.http.GET

interface SmashBrosApi {

    @GET(ApiConstants.FIGHTERS_PATH)
    suspend fun getFighters(): List<FighterApiEntity>

    @GET(ApiConstants.UNIVERSES_PATH)
    suspend fun getUniverses(): List<UniverseApiEntity>
}
