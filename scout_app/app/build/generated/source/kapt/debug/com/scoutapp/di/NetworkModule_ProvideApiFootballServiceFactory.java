package com.scoutapp.di;

import com.scoutapp.data.api.ApiFootballService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NetworkModule_ProvideApiFootballServiceFactory implements Factory<ApiFootballService> {
  @Override
  public ApiFootballService get() {
    return provideApiFootballService();
  }

  public static NetworkModule_ProvideApiFootballServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiFootballService provideApiFootballService() {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideApiFootballService());
  }

  private static final class InstanceHolder {
    private static final NetworkModule_ProvideApiFootballServiceFactory INSTANCE = new NetworkModule_ProvideApiFootballServiceFactory();
  }
}
