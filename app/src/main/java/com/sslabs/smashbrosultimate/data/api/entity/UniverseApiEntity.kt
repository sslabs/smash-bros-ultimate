package com.sslabs.smashbrosultimate.data.api.entity

import com.google.gson.annotations.SerializedName
import com.sslabs.smashbrosultimate.UniverseApiConstants

data class UniverseApiEntity(
    @SerializedName(UniverseApiConstants.OBJECT_ID)
    var objectId: String,

    @SerializedName(UniverseApiConstants.NAME)
    var name: String,

    @SerializedName(UniverseApiConstants.DESCRIPTION)
    var description: String,
)