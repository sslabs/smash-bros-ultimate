package com.sslabs.smashbrosultimate.di.module

import android.content.Context
import com.sslabs.smashbrosultimate.data.local.pref.AppPreferences
import com.sslabs.smashbrosultimate.data.local.pref.IPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppPreferences(@ApplicationContext context: Context): IPreferences =
        AppPreferences(context)
}