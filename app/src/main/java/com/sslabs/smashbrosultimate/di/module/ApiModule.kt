package com.sslabs.smashbrosultimate.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sslabs.smashbrosultimate.ApiConstants
import com.sslabs.smashbrosultimate.data.api.SmashBrosApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val logger = HttpLoggingInterceptor.Logger {
            Timber.tag("OkHttp").d(it)
        }
        val loggingInterceptor = HttpLoggingInterceptor(logger)
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return loggingInterceptor
    }

    @Singleton
    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Singleton
    @Provides
    fun provideApiBuilder(client: OkHttpClient, gson: Gson): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)

    @Singleton
    @Provides
    fun provideApi(api: Retrofit.Builder): SmashBrosApi =
        api.build().create(SmashBrosApi::class.java)
}
