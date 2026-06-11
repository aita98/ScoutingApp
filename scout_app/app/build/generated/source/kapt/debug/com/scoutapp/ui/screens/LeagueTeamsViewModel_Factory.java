package com.scoutapp.ui.screens;

import com.scoutapp.data.api.TransfermarktApiService;
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

  public LeagueTeamsViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
  }

  @Override
  public LeagueTeamsViewModel get() {
    return newInstance(tmApiServiceProvider.get());
  }

  public static LeagueTeamsViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider) {
    return new LeagueTeamsViewModel_Factory(tmApiServiceProvider);
  }

  public static LeagueTeamsViewModel newInstance(TransfermarktApiService tmApiService) {
    return new LeagueTeamsViewModel(tmApiService);
  }
}
