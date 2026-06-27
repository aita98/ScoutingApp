package com.scoutapp.data.repository;

import com.google.gson.Gson;
import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.PlayerDao;
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
public final class EnrichmentRepository_Factory implements Factory<EnrichmentRepository> {
  private final Provider<ScoutApiService> apiServiceProvider;

  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<PlayerDao> playerDaoProvider;

  private final Provider<Gson> gsonProvider;

  public EnrichmentRepository_Factory(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider, Provider<PlayerDao> playerDaoProvider,
      Provider<Gson> gsonProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.playerDaoProvider = playerDaoProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public EnrichmentRepository get() {
    return newInstance(apiServiceProvider.get(), tmApiServiceProvider.get(), playerDaoProvider.get(), gsonProvider.get());
  }

  public static EnrichmentRepository_Factory create(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider, Provider<PlayerDao> playerDaoProvider,
      Provider<Gson> gsonProvider) {
    return new EnrichmentRepository_Factory(apiServiceProvider, tmApiServiceProvider, playerDaoProvider, gsonProvider);
  }

  public static EnrichmentRepository newInstance(ScoutApiService apiService,
      TransfermarktApiService tmApiService, PlayerDao playerDao, Gson gson) {
    return new EnrichmentRepository(apiService, tmApiService, playerDao, gson);
  }
}
