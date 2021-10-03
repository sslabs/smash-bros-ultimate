package com.sslabs.smashbrosultimate.data.local.db.mapper

import com.sslabs.smashbrosultimate.data.local.db.entity.UniverseCacheEntity
import com.sslabs.smashbrosultimate.data.model.Universe
import com.sslabs.smashbrosultimate.util.EntityMapper
import javax.inject.Inject

class UniverseDbMapper @Inject constructor() : EntityMapper<UniverseCacheEntity, Universe> {
    override fun fromEntity(entity: UniverseCacheEntity): Universe =
        Universe(
            id = entity.id,
            name = entity.name,
            description = entity.description
        )

    override fun toEntity(domainModel: Universe): UniverseCacheEntity =
        UniverseCacheEntity(
            id = domainModel.id,
            name = domainModel.name,
            description = domainModel.description
        )
}