package com.sslabs.smashbrosultimate.data.api.mapper

import com.sslabs.smashbrosultimate.data.api.entity.FighterApiEntity
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.EntityMapper
import javax.inject.Inject

class FighterApiMapper @Inject constructor() : EntityMapper<FighterApiEntity, Fighter> {

    override fun fromEntity(entity: FighterApiEntity): Fighter =
        Fighter(
            id = null,
            name = entity.name,
            universe = entity.universe,
            price = entity.price.toDouble(),
            popular = entity.popular,
            rate = entity.rate,
            downloads = entity.downloads.toInt(),
            description = entity.description,
            imageUrl = entity.imageUrl
        )

    override fun toEntity(domainModel: Fighter): FighterApiEntity {
        TODO("Not yet implemented")
    }
}
