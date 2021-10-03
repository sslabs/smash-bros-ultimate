package com.sslabs.smashbrosultimate.data.model

data class Fighter(
    var id: Int?,
    var name: String,
    var universe: String,
    var price: String,
    var popular: Boolean,
    var rate: Int,
    var downloads: Int,
    var description: String,
    var imageUrl: String
)