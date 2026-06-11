package com.scoutapp.di;

import com.scoutapp.data.api.TransfermarktApiService;
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
public final class NetworkModule_ProvideTransfermarktApiServiceFactory implements Factory<TransfermarktApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideTransfermarktApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public TransfermarktApiService get() {
    return provideTransfermarktApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideTransfermarktApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideTransfermarktApiServiceFactory(retrofitProvider);
  }

  public static TransfermarktApiService provideTransfermarktApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideTransfermarktApiService(retrofit));
  }
}
