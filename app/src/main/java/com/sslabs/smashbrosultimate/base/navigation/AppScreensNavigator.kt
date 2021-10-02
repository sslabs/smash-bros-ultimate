package com.sslabs.smashbrosultimate.base.navigation

import androidx.navigation.NavController
import com.sslabs.smashbrosultimate.ui.welcome.SplashViewDirections
import com.sslabs.smashbrosultimate.ui.welcome.WalkthroughStep
import com.sslabs.smashbrosultimate.ui.welcome.WalkthroughViewDirections
import javax.inject.Inject

class AppScreensNavigator @Inject constructor(
    private val navController: NavController
) : IScreensNavigator {

    override fun fromSplash(toWalkthrough: Boolean) {
        if (toWalkthrough) fromSplashToWalkthrough()
        else fromSplashToFightersList()
    }

    override fun fromWalkthrough(step: WalkthroughStep) {
        if (step.hasNext()) {
            navController.navigate(WalkthroughViewDirections.actionWalkthroughViewSelf(step.next()))
        } else {
            navController.navigate(WalkthroughViewDirections.actionWalkthroughViewToFightersListView())
        }
    }

    private fun fromSplashToWalkthrough() {
        navController.navigate(SplashViewDirections.actionSplashViewToWalkthroughView())
    }

    private fun fromSplashToFightersList() {
        navController.navigate(SplashViewDirections.actionSplashViewToFightersListView())
    }
}