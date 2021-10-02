package com.sslabs.smashbrosultimate.base.navigation

import com.sslabs.smashbrosultimate.ui.welcome.WalkthroughStep

interface IScreensNavigator {
    fun fromSplash(toWalkthrough: Boolean)
    fun fromWalkthrough(step: WalkthroughStep)
}
