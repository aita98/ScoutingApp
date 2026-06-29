package com.scoutapp.data.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class GroqService_Factory implements Factory<GroqService> {
  private final Provider<GroqApiService> groqApiServiceProvider;

  public GroqService_Factory(Provider<GroqApiService> groqApiServiceProvider) {
    this.groqApiServiceProvider = groqApiServiceProvider;
  }

  @Override
  public GroqService get() {
    return newInstance(groqApiServiceProvider.get());
  }

  public static GroqService_Factory create(Provider<GroqApiService> groqApiServiceProvider) {
    return new GroqService_Factory(groqApiServiceProvider);
  }

  public static GroqService newInstance(GroqApiService groqApiService) {
    return new GroqService(groqApiService);
  }
}
