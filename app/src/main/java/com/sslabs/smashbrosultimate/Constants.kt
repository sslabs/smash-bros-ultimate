package com.sslabs.smashbrosultimate

object ApiConstants {
    const val BASE_URL = "https://593cdf8fb56f410011e7e7a9.mockapi.io/"
    const val FIGHTERS_PATH = "fighters"
    const val UNIVERSES_PATH = "universes"
}

object PreferenceConstants {
    const val PREF_NAME = "smashbrosultimate.prefs"
    const val WALKTHROUGH_DISPLAYED = "walkthrough.displayed"
}

object FighterApiConstants {
    const val OBJECT_ID = "objectID"
    const val NAME = "name"
    const val UNIVERSE = "universe"
    const val PRICE = "price"
    const val POPULAR = "popular"
    const val RATE = "rate"
    const val DOWNLOAD = "downloads"
    const val DESCRIPTION = "description"
    const val CREATE_AT = "created_at"
    const val IMAGE_URL = "imageURL"
}

object FighterDbConstants {
    const val TABLE_NAME = "fighter"
    const val ID = "id"
    const val NAME = "name"
    const val UNIVERSE = "universe"
    const val PRICE = "price"
    const val POPULAR = "popular"
    const val RATE = "rate"
    const val DOWNLOAD = "downloads"
    const val DESCRIPTION = "description"
    const val IMAGE_URL = "imageURL"
}

object UniverseApiConstants {
    const val OBJECT_ID = "objectID"
    const val NAME = "name"
    const val DESCRIPTION = "description"
}

object UniverseDbConstants {
    const val TABLE_NAME = "universe"
    const val ID = "id"
    const val NAME = "name"
    const val DESCRIPTION = "description"
}