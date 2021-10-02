package com.sslabs.smashbrosultimate.data.local.pref

interface IPreferences {
    suspend fun wasWalkthroughDisplayed(): Boolean
    suspend fun setWalkthroughDisplayed()
}
