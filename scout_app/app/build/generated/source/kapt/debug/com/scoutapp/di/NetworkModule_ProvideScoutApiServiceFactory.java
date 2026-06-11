package com.scoutapp.di;

import com.scoutapp.data.api.ScoutApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class NetworkModule_ProvideScoutApiServiceFactory implements Factory<ScoutApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideScoutApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ScoutApiService get() {
    return provideScoutApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideScoutApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideScoutApiServiceFactory(retrofitProvider);
  }

  public static ScoutApiService provideScoutApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideScoutApiService(retrofit));
  }
}
