package com.scoutapp.viewmodel;

import com.google.gson.Gson;
import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.PlayerDao;
import com.scoutapp.data.repository.EnrichmentRepository;
import com.scoutapp.domain.repository.PlayerRepository;
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
public final class PlayerDetailViewModel_Factory implements Factory<PlayerDetailViewModel> {
  private final Provider<ScoutApiService> apiServiceProvider;

  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<PlayerRepository> playerRepositoryProvider;

  private final Provider<PlayerDao> playerDaoProvider;

  private final Provider<EnrichmentRepository> enrichmentRepositoryProvider;

  private final Provider<Gson> gsonProvider;

  public PlayerDetailViewModel_Factory(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<PlayerRepository> playerRepositoryProvider, Provider<PlayerDao> playerDaoProvider,
      Provider<EnrichmentRepository> enrichmentRepositoryProvider, Provider<Gson> gsonProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.playerRepositoryProvider = playerRepositoryProvider;
    this.playerDaoProvider = playerDaoProvider;
    this.enrichmentRepositoryProvider = enrichmentRepositoryProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public PlayerDetailViewModel get() {
    return newInstance(apiServiceProvider.get(), tmApiServiceProvider.get(), playerRepositoryProvider.get(), playerDaoProvider.get(), enrichmentRepositoryProvider.get(), gsonProvider.get());
  }

  public static PlayerDetailViewModel_Factory create(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider,
      Provider<PlayerRepository> playerRepositoryProvider, Provider<PlayerDao> playerDaoProvider,
      Provider<EnrichmentRepository> enrichmentRepositoryProvider, Provider<Gson> gsonProvider) {
    return new PlayerDetailViewModel_Factory(apiServiceProvider, tmApiServiceProvider, playerRepositoryProvider, playerDaoProvider, enrichmentRepositoryProvider, gsonProvider);
  }

  public static PlayerDetailViewModel newInstance(ScoutApiService apiService,
      TransfermarktApiService tmApiService, PlayerRepository playerRepository, PlayerDao playerDao,
      EnrichmentRepository enrichmentRepository, Gson gson) {
    return new PlayerDetailViewModel(apiService, tmApiService, playerRepository, playerDao, enrichmentRepository, gson);
  }
}
