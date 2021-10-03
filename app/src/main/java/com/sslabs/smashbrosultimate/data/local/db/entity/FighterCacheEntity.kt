package com.sslabs.smashbrosultimate.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sslabs.smashbrosultimate.FighterDbConstants

@Entity(tableName = FighterDbConstants.TABLE_NAME)
data class FighterCacheEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = FighterDbConstants.ID)
    var id: Int?,

    @ColumnInfo(name = FighterDbConstants.NAME)
    var name: String,

    @ColumnInfo(name = FighterDbConstants.UNIVERSE)
    var universe: String,

    @ColumnInfo(name = FighterDbConstants.PRICE)
    var price: String,

    @ColumnInfo(name = FighterDbConstants.POPULAR)
    var popular: Boolean,

    @ColumnInfo(name = FighterDbConstants.RATE)
    var rate: Int,

    @ColumnInfo(name = FighterDbConstants.DOWNLOAD)
    var downloads: Int,

    @ColumnInfo(name = FighterDbConstants.DESCRIPTION)
    var description: String,

    @ColumnInfo(name = FighterDbConstants.IMAGE_URL)
    var imageUrl: String,
)
