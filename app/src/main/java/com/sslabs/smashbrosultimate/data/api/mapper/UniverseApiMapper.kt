package com.sslabs.smashbrosultimate.data.api.mapper

import com.sslabs.smashbrosultimate.data.api.entity.UniverseApiEntity
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.util.EntityMapper
import javax.inject.Inject

class UniverseApiMapper @Inject constructor() : EntityMapper<UniverseApiEntity, Universe> {
    override fun fromEntity(entity: UniverseApiEntity): Universe =
        Universe(
            id = null,
            name = entity.name,
            description = entity.description
        )

    override fun toEntity(domainModel: Universe): UniverseApiEntity {
        TODO("Not yet implemented")
    }
}