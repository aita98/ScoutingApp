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
public final class TeamDetailViewModel_Factory implements Factory<TeamDetailViewModel> {
  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  public TeamDetailViewModel_Factory(Provider<TransfermarktApiService> tmApiServiceProvider) {
    this.tmApiServiceProvider = tmApiServiceProvider;
  }

  @Override
  public TeamDetailViewModel get() {
    return newInstance(tmApiServiceProvider.get());
  }

  public static TeamDetailViewModel_Factory create(
      Provider<TransfermarktApiService> tmApiServiceProvider) {
    return new TeamDetailViewModel_Factory(tmApiServiceProvider);
  }

  public static TeamDetailViewModel newInstance(TransfermarktApiService tmApiService) {
    return new TeamDetailViewModel(tmApiService);
  }
}
