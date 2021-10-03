package com.sslabs.smashbrosultimate.di.module

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.sslabs.smashbrosultimate.base.navigation.AppScreensNavigator
import com.sslabs.smashbrosultimate.base.navigation.IScreensNavigator
import com.sslabs.smashbrosultimate.ui.fighter.adapter.UniverseOptionsAdapter
import com.sslabs.smashbrosultimate.ui.fighter.adapter.UniverseViewHolder
import com.sslabs.smashbrosultimate.ui.fighter.adapter.UniverseViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    fun provideNavController(fragment: Fragment): NavController = fragment.findNavController()

    @Provides
    fun provideScreensNavigator(navController: NavController): IScreensNavigator =
        AppScreensNavigator(navController)

    @Provides
    fun provideUniverseClickListener(fragment: Fragment): UniverseViewHolder.OnUniverseClickListener =
        fragment as UniverseViewHolder.OnUniverseClickListener

    @Provides
    fun provideUniverseViewHolderFactory(
        listener: UniverseViewHolder.OnUniverseClickListener
    ): UniverseViewHolderFactory = UniverseViewHolderFactory(listener)

    @Provides
    fun provideUniverseOptionsAdapter(factory: UniverseViewHolderFactory) =
        UniverseOptionsAdapter(factory)
}