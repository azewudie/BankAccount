package com.aaron.bankaccount.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideBasicOkHttpClient():OkHttpClient{
        val okHttpClientBuilder = OkHttpClient.Builder()

        return  okHttpClientBuilder.build()

    }

}