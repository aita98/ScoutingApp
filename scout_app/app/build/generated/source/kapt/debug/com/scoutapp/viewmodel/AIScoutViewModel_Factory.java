package com.scoutapp.viewmodel;

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
public final class AIScoutViewModel_Factory implements Factory<AIScoutViewModel> {
  private final Provider<ScoutApiService> apiServiceProvider;

  public AIScoutViewModel_Factory(Provider<ScoutApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public AIScoutViewModel get() {
    return newInstance(apiServiceProvider.get());
  }

  public static AIScoutViewModel_Factory create(Provider<ScoutApiService> apiServiceProvider) {
    return new AIScoutViewModel_Factory(apiServiceProvider);
  }

  public static AIScoutViewModel newInstance(ScoutApiService apiService) {
    return new AIScoutViewModel(apiService);
  }
}
