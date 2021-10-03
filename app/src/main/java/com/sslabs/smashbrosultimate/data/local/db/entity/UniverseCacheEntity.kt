package com.sslabs.smashbrosultimate.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sslabs.smashbrosultimate.UniverseDbConstants

@Entity(tableName = UniverseDbConstants.TABLE_NAME)
data class UniverseCacheEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = UniverseDbConstants.ID)
    var id: Int?,

    @ColumnInfo(name = UniverseDbConstants.NAME)
    var name: String,

    @ColumnInfo(name = UniverseDbConstants.DESCRIPTION)
    var description: String,
)