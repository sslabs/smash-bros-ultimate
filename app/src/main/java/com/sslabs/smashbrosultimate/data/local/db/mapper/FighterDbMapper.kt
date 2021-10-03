package com.sslabs.smashbrosultimate.data.local.db.mapper

import com.sslabs.smashbrosultimate.data.local.db.entity.FighterCacheEntity
import com.sslabs.smashbrosultimate.data.model.Fighter
import com.sslabs.smashbrosultimate.util.EntityMapper
import javax.inject.Inject

class FighterDbMapper @Inject constructor() : EntityMapper<FighterCacheEntity, Fighter> {
    override fun fromEntity(entity: FighterCacheEntity) = Fighter(
        id = entity.id,
        name = entity.name,
        universe = entity.universe,
        price = entity.price.toDouble(),
        popular = entity.popular,
        rate = entity.rate,
        downloads = entity.downloads,
        description = entity.description,
        imageUrl = entity.imageUrl
    )

    override fun toEntity(domainModel: Fighter) = FighterCacheEntity(
        id = domainModel.id,
        name = domainModel.name,
        universe = domainModel.universe,
        price = domainModel.price.toString(),
        popular = domainModel.popular,
        rate = domainModel.rate,
        downloads = domainModel.downloads,
        description = domainModel.description,
        imageUrl = domainModel.imageUrl
    )
}