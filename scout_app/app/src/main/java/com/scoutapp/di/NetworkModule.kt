package com.scoutapp.di

import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.api.ApiFootballService
import com.scoutapp.data.api.GroqApiService
import com.scoutapp.data.api.fbref.FbrefApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import javax.inject.Named

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request()
                android.util.Log.d("API_DEBUG", "Sending request: ${request.method} ${request.url}")
                val response = chain.proceed(request)
                android.util.Log.d("API_DEBUG", "Received response for: ${request.url} - Code: ${response.code}")
                response
            }
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    @Named("FbrefRetrofit")
    fun provideFbrefRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val baseUrl = "http://172.24.36.58:9100/fbref/"
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideFbrefApi(@Named("FbrefRetrofit") retrofit: Retrofit): FbrefApi {
        return retrofit.create(FbrefApi::class.java)
    }

    @Provides
    @Singleton
    @Named("ScoutRetrofit")
    fun provideScoutRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://172.24.36.58:8080/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("TransfermarktRetrofit")
    fun provideTransfermarktRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://172.24.36.58:8000/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @Named("GroqRetrofit")
    fun provideGroqRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.groq.com/openai/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGroqApiService(@Named("GroqRetrofit") retrofit: Retrofit): GroqApiService =
        retrofit.create(GroqApiService::class.java)

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideScoutApiService(@Named("ScoutRetrofit") retrofit: Retrofit): ScoutApiService =
        retrofit.create(ScoutApiService::class.java)

    @Provides
    @Singleton
    fun provideTransfermarktApiService(@Named("TransfermarktRetrofit") retrofit: Retrofit): TransfermarktApiService =
        retrofit.create(TransfermarktApiService::class.java)

    @Provides
    @Singleton
    fun provideApiFootballService(): ApiFootballService =
        Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiFootballService::class.java)
}
