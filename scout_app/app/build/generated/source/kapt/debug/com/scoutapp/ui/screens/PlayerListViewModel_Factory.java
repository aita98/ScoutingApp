package com.scoutapp.ui.screens;

import com.scoutapp.data.api.ScoutApiService;
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
public final class PlayerListViewModel_Factory implements Factory<PlayerListViewModel> {
  private final Provider<ScoutApiService> scoutApiServiceProvider;

  public PlayerListViewModel_Factory(Provider<ScoutApiService> scoutApiServiceProvider) {
    this.scoutApiServiceProvider = scoutApiServiceProvider;
  }

  @Override
  public PlayerListViewModel get() {
    return newInstance(scoutApiServiceProvider.get());
  }

  public static PlayerListViewModel_Factory create(
      Provider<ScoutApiService> scoutApiServiceProvider) {
    return new PlayerListViewModel_Factory(scoutApiServiceProvider);
  }

  public static PlayerListViewModel newInstance(ScoutApiService scoutApiService) {
    return new PlayerListViewModel(scoutApiService);
  }
}
