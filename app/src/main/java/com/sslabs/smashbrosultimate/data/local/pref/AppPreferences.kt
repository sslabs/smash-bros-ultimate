package com.sslabs.smashbrosultimate.data.local.pref

import android.content.Context
import androidx.core.content.edit
import com.sslabs.smashbrosultimate.PreferenceConstants

class AppPreferences (context: Context) : IPreferences {
    private val prefs =
        context.getSharedPreferences(PreferenceConstants.PREF_NAME, Context.MODE_PRIVATE)

    override suspend fun wasWalkthroughDisplayed(): Boolean {
        return prefs.getBoolean(PreferenceConstants.WALKTHROUGH_DISPLAYED, false)
    }

    override suspend fun setWalkthroughDisplayed() {
        prefs.edit() {
            putBoolean(PreferenceConstants.WALKTHROUGH_DISPLAYED, true)
        }
    }
}