package com.scoutapp.ui.screens;

import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.TeamDao;
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
public final class LeagueTeamsViewModel_Factory implements Factory<LeagueTeamsViewModel> {
  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<ScoutApiService> scoutApiServiceProvider;

  private final Provider<TeamDao> teamDaoProvider;

  public LeagueTeamsViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider, Provider<TeamDao> teamDaoProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.scoutApiServiceProvider = scoutApiServiceProvider;
    this.teamDaoProvider = teamDaoProvider;
  }

  @Override
  public LeagueTeamsViewModel get() {
    return newInstance(tmApiServiceProvider.get(), scoutApiServiceProvider.get(), teamDaoProvider.get());
  }

  public static LeagueTeamsViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider, Provider<TeamDao> teamDaoProvider) {
    return new LeagueTeamsViewModel_Factory(tmApiServiceProvider, scoutApiServiceProvider, teamDaoProvider);
  }

  public static LeagueTeamsViewModel newInstance(TransfermarktApiService tmApiService,
      ScoutApiService scoutApiService, TeamDao teamDao) {
    return new LeagueTeamsViewModel(tmApiService, scoutApiService, teamDao);
  }
}
