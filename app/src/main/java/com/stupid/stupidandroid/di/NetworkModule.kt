package com.stupid.stupidandroid.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.stupid.stupidandroid.data.api.NetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
        )
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(
        networkJson: Json,
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .baseUrl("http://setjwklzor.us14.qoddiapp.com/")
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType()),
        )
        .client(client)
        .build()


    @Singleton
    @Provides
    fun provideNetworkService(retrofit: Retrofit): NetworkService =
        retrofit.create(
            NetworkService::class.java
        )
}
