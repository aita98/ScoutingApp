package com.scoutapp.data.repository;

import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.api.fbref.FbrefApi;
import com.scoutapp.data.local.MatchDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PlayerRepositoryImpl_Factory implements Factory<PlayerRepositoryImpl> {
  private final Provider<TransfermarktApiService> tmApiProvider;

  private final Provider<FbrefApi> fbrefApiProvider;

  private final Provider<ScoutApiService> apiServiceProvider;

  private final Provider<MatchDao> matchDaoProvider;

  public PlayerRepositoryImpl_Factory(Provider<TransfermarktApiService> tmApiProvider,
      Provider<FbrefApi> fbrefApiProvider, Provider<ScoutApiService> apiServiceProvider,
      Provider<MatchDao> matchDaoProvider) {
    this.tmApiProvider = tmApiProvider;
    this.fbrefApiProvider = fbrefApiProvider;
    this.apiServiceProvider = apiServiceProvider;
    this.matchDaoProvider = matchDaoProvider;
  }

  @Override
  public PlayerRepositoryImpl get() {
    return newInstance(tmApiProvider.get(), fbrefApiProvider.get(), apiServiceProvider.get(), matchDaoProvider.get());
  }

  public static PlayerRepositoryImpl_Factory create(Provider<TransfermarktApiService> tmApiProvider,
      Provider<FbrefApi> fbrefApiProvider, Provider<ScoutApiService> apiServiceProvider,
      Provider<MatchDao> matchDaoProvider) {
    return new PlayerRepositoryImpl_Factory(tmApiProvider, fbrefApiProvider, apiServiceProvider, matchDaoProvider);
  }

  public static PlayerRepositoryImpl newInstance(TransfermarktApiService tmApi, FbrefApi fbrefApi,
      ScoutApiService apiService, MatchDao matchDao) {
    return new PlayerRepositoryImpl(tmApi, fbrefApi, apiService, matchDao);
  }
}
