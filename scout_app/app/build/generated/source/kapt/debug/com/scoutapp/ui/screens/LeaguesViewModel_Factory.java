package com.scoutapp.ui.screens;

import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.LeagueDao;
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
public final class LeaguesViewModel_Factory implements Factory<LeaguesViewModel> {
  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<ScoutApiService> scoutApiServiceProvider;

  private final Provider<LeagueDao> leagueDaoProvider;

  public LeaguesViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider, Provider<LeagueDao> leagueDaoProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.scoutApiServiceProvider = scoutApiServiceProvider;
    this.leagueDaoProvider = leagueDaoProvider;
  }

  @Override
  public LeaguesViewModel get() {
    return newInstance(tmApiServiceProvider.get(), scoutApiServiceProvider.get(), leagueDaoProvider.get());
  }

  public static LeaguesViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider, Provider<LeagueDao> leagueDaoProvider) {
    return new LeaguesViewModel_Factory(tmApiServiceProvider, scoutApiServiceProvider, leagueDaoProvider);
  }

  public static LeaguesViewModel newInstance(TransfermarktApiService tmApiService,
      ScoutApiService scoutApiService, LeagueDao leagueDao) {
    return new LeaguesViewModel(tmApiService, scoutApiService, leagueDao);
  }
}
