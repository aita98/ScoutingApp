package com.scoutapp.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/scoutapp/di/NetworkModule;", "", "()V", "provideApiFootballService", "Lcom/scoutapp/data/api/ApiFootballService;", "provideFbrefApi", "Lcom/scoutapp/data/api/fbref/FbrefApi;", "retrofit", "Lretrofit2/Retrofit;", "provideFbrefRetrofit", "okHttpClient", "Lokhttp3/OkHttpClient;", "provideGson", "Lcom/google/gson/Gson;", "provideMoshi", "Lcom/squareup/moshi/Moshi;", "provideOkHttpClient", "provideScoutApiService", "Lcom/scoutapp/data/api/ScoutApiService;", "provideScoutRetrofit", "provideTransfermarktApiService", "Lcom/scoutapp/data/api/TransfermarktApiService;", "provideTransfermarktRetrofit", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.scoutapp.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "FbrefRetrofit")
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideFbrefRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.fbref.FbrefApi provideFbrefApi(@javax.inject.Named(value = "FbrefRetrofit")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "ScoutRetrofit")
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideScoutRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @javax.inject.Named(value = "TransfermarktRetrofit")
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideTransfermarktRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.squareup.moshi.Moshi provideMoshi() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.ScoutApiService provideScoutApiService(@javax.inject.Named(value = "ScoutRetrofit")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.TransfermarktApiService provideTransfermarktApiService(@javax.inject.Named(value = "TransfermarktRetrofit")
    @org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.ApiFootballService provideApiFootballService() {
        return null;
    }
}