package com.scoutapp.viewmodel;

import com.scoutapp.data.api.GroqService;
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

  private final Provider<GroqService> groqServiceProvider;

  public AIScoutViewModel_Factory(Provider<ScoutApiService> apiServiceProvider,
      Provider<GroqService> groqServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.groqServiceProvider = groqServiceProvider;
  }

  @Override
  public AIScoutViewModel get() {
    return newInstance(apiServiceProvider.get(), groqServiceProvider.get());
  }

  public static AIScoutViewModel_Factory create(Provider<ScoutApiService> apiServiceProvider,
      Provider<GroqService> groqServiceProvider) {
    return new AIScoutViewModel_Factory(apiServiceProvider, groqServiceProvider);
  }

  public static AIScoutViewModel newInstance(ScoutApiService apiService, GroqService groqService) {
    return new AIScoutViewModel(apiService, groqService);
  }
}
