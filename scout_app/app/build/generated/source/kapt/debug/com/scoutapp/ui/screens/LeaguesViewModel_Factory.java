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
public final class LeaguesViewModel_Factory implements Factory<LeaguesViewModel> {
  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<ScoutApiService> scoutApiServiceProvider;

  public LeaguesViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.scoutApiServiceProvider = scoutApiServiceProvider;
  }

  @Override
  public LeaguesViewModel get() {
    return newInstance(tmApiServiceProvider.get(), scoutApiServiceProvider.get());
  }

  public static LeaguesViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<ScoutApiService> scoutApiServiceProvider) {
    return new LeaguesViewModel_Factory(tmApiServiceProvider, scoutApiServiceProvider);
  }

  public static LeaguesViewModel newInstance(TransfermarktApiService tmApiService,
      ScoutApiService scoutApiService) {
    return new LeaguesViewModel(tmApiService, scoutApiService);
  }
}
