package com.daniel.estrada.hackathonmonitor.di

import com.daniel.estrada.hackathonmonitor.data.api.HPApi
import com.daniel.estrada.hackathonmonitor.data.repository.HPRepositoryImpl
import com.daniel.estrada.hackathonmonitor.domain.repository.HPRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideHPApi(): HPApi {
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                })
                .build()
            )
            .build()
            .create(HPApi::class.java)
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(
        hpRepositoryImpl: HPRepositoryImpl
    ): HPRepository
}