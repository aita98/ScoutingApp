package com.scoutapp.di

import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.inject.Named

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                println("API Request: ${request.method} ${request.url}")
                val response = chain.proceed(request)
                println("API Response: ${response.code} ${request.url}")
                response
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @Named("ScoutRetrofit")
    fun provideScoutRetrofit(okHttpClient: OkHttpClient): Retrofit {
        // IP ZeroTier di default per il backend: "http://172.24.36.58:8080/"
        // Per emulatore Android locale usare: "http://10.0.2.2:8080/"
        val baseUrl = "http://172.24.36.58:8080/"
        
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("TransfermarktRetrofit")
    fun provideTransfermarktRetrofit(okHttpClient: OkHttpClient): Retrofit {
        // IP ZeroTier di default per l'API Transfermarkt: "http://172.24.36.58:8000/"
        val baseUrl = "http://172.24.36.58:8000/"
        
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideScoutApiService(@Named("ScoutRetrofit") retrofit: Retrofit): ScoutApiService {
        return retrofit.create(ScoutApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTransfermarktApiService(@Named("TransfermarktRetrofit") retrofit: Retrofit): TransfermarktApiService {
        return retrofit.create(TransfermarktApiService::class.java)
    }
}
