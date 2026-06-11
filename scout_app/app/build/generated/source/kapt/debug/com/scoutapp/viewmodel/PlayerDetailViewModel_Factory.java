package com.scoutapp.viewmodel;

import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.PlayerDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class PlayerDetailViewModel_Factory implements Factory<PlayerDetailViewModel> {
  private final Provider<ScoutApiService> apiServiceProvider;

  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<PlayerDao> playerDaoProvider;

  public PlayerDetailViewModel_Factory(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<PlayerDao> playerDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.playerDaoProvider = playerDaoProvider;
  }

  @Override
  public PlayerDetailViewModel get() {
    return newInstance(apiServiceProvider.get(), tmApiServiceProvider.get(), playerDaoProvider.get());
  }

  public static PlayerDetailViewModel_Factory create(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<PlayerDao> playerDaoProvider) {
    return new PlayerDetailViewModel_Factory(apiServiceProvider, tmApiServiceProvider, playerDaoProvider);
  }

  public static PlayerDetailViewModel newInstance(ScoutApiService apiService,
      TransfermarktApiService tmApiService, PlayerDao playerDao) {
    return new PlayerDetailViewModel(apiService, tmApiService, playerDao);
  }
}
