package com.sslabs.smashbrosultimate.util

interface EntityMapper<Entity, DomainModel> {
    fun fromEntity(entity: Entity): DomainModel
    fun toEntity(domainModel: DomainModel): Entity
}