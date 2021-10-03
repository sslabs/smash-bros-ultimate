package com.sslabs.smashbrosultimate.data.api

import com.sslabs.smashbrosultimate.data.api.entity.FighterApiEntity
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.EntityMapper
import javax.inject.Inject

class ApiMapper @Inject constructor() : EntityMapper<FighterApiEntity, Fighter> {

    override fun fromEntity(entity: FighterApiEntity): Fighter {
        return Fighter(
            id = null,
            name = entity.name,
            universe = entity.universe,
            price = entity.price,
            popular = entity.popular,
            rate = entity.rate,
            downloads = entity.downloads.toInt(),
            description = entity.description,
            imageUrl = entity.imageUrl
        )
    }

    override fun toEntity(domainModel: Fighter): FighterApiEntity {
        TODO("Not yet implemented")
    }

    fun mapFromEntityList(entities: List<FighterApiEntity>): List<Fighter> {
        return entities.map { fromEntity(it) }
    }
}
