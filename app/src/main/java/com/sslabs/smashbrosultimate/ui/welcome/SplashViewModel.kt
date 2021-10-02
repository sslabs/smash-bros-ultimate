package com.sslabs.smashbrosultimate.ui.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.sslabs.smashbrosultimate.data.local.pref.IPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val prefs: IPreferences
) : ViewModel() {

    val walkthroughDisplayed: LiveData<Boolean> = liveData {
        val displayed = prefs.wasWalkthroughDisplayed()
        emit(displayed)
    }
}