package com.sslabs.smashbrosultimate.data.api.entity

import com.google.gson.annotations.SerializedName
import com.sslabs.smashbrosultimate.FighterApiConstants

data class FighterApiEntity(
    @SerializedName(FighterApiConstants.OBJECT_ID)
    var objectId: String,

    @SerializedName(FighterApiConstants.NAME)
    var name: String,

    @SerializedName(FighterApiConstants.UNIVERSE)
    var universe: String,

    @SerializedName(FighterApiConstants.PRICE)
    var price: String,

    @SerializedName(FighterApiConstants.POPULAR)
    var popular: Boolean,

    @SerializedName(FighterApiConstants.RATE)
    var rate: Int,

    @SerializedName(FighterApiConstants.DOWNLOAD)
    var downloads: String,

    @SerializedName(FighterApiConstants.DESCRIPTION)
    var description: String,

    @SerializedName(FighterApiConstants.CREATE_AT)
    var createdAt: String,

    @SerializedName(FighterApiConstants.IMAGE_URL)
    var imageUrl: String
)