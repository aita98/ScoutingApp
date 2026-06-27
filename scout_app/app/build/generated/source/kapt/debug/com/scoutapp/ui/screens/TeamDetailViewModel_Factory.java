package com.scoutapp.ui.screens;

import com.scoutapp.data.api.ScoutApiService;
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
public final class TeamDetailViewModel_Factory implements Factory<TeamDetailViewModel> {
  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<ScoutApiService> scoutApiServiceProvider;

  public TeamDetailViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.scoutApiServiceProvider = scoutApiServiceProvider;
  }

  @Override
  public TeamDetailViewModel get() {
    return newInstance(tmApiServiceProvider.get(), scoutApiServiceProvider.get());
  }

  public static TeamDetailViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider) {
    return new TeamDetailViewModel_Factory(tmApiServiceProvider, scoutApiServiceProvider);
  }

  public static TeamDetailViewModel newInstance(TransfermarktApiService tmApiService,
      ScoutApiService scoutApiService) {
    return new TeamDetailViewModel(tmApiService, scoutApiService);
  }
}
