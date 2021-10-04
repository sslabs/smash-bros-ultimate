package com.sslabs.smashbrosultimate.base.navigation

import androidx.navigation.NavController
import com.sslabs.smashbrosultimate.ui.fighter.SelectFighterViewDirections
import com.sslabs.smashbrosultimate.ui.filter.Filters
import com.sslabs.smashbrosultimate.ui.filter.FiltersViewDirections
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

    override fun fromSelectFighterToFilters() {
        navController.navigate(SelectFighterViewDirections.actionFightersListViewToFiltersView())
    }

    override fun fromFilters(filter: Filters?) {
        navController.navigate(FiltersViewDirections.actionFiltersViewToFightersListView(filter))
    }

    private fun fromSplashToWalkthrough() {
        navController.navigate(SplashViewDirections.actionSplashViewToWalkthroughView())
    }

    private fun fromSplashToFightersList() {
        navController.navigate(SplashViewDirections.actionSplashViewToFightersListView())
    }
}