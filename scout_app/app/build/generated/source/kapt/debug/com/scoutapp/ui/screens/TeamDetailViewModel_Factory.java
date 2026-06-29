package com.scoutapp.ui.screens;

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
public final class TeamDetailViewModel_Factory implements Factory<TeamDetailViewModel> {
  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<ScoutApiService> scoutApiServiceProvider;

  private final Provider<PlayerDao> playerDaoProvider;

  public TeamDetailViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider, Provider<PlayerDao> playerDaoProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.scoutApiServiceProvider = scoutApiServiceProvider;
    this.playerDaoProvider = playerDaoProvider;
  }

  @Override
  public TeamDetailViewModel get() {
    return newInstance(tmApiServiceProvider.get(), scoutApiServiceProvider.get(), playerDaoProvider.get());
  }

  public static TeamDetailViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider, Provider<PlayerDao> playerDaoProvider) {
    return new TeamDetailViewModel_Factory(tmApiServiceProvider, scoutApiServiceProvider, playerDaoProvider);
  }

  public static TeamDetailViewModel newInstance(TransfermarktApiService tmApiService,
      ScoutApiService scoutApiService, PlayerDao playerDao) {
    return new TeamDetailViewModel(tmApiService, scoutApiService, playerDao);
  }
}
