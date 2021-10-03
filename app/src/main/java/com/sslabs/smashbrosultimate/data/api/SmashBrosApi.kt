package com.sslabs.smashbrosultimate.data.api

import com.sslabs.smashbrosultimate.data.api.entity.FighterApiEntity
import retrofit2.http.GET

interface SmashBrosApi {

    @GET("fighters")
    suspend fun getFighters(): List<FighterApiEntity>
}
