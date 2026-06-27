package com.scoutapp.viewmodel;

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
public final class PlayerStatsViewModel_Factory implements Factory<PlayerStatsViewModel> {
  private final Provider<PlayerRepository> repositoryProvider;

  public PlayerStatsViewModel_Factory(Provider<PlayerRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PlayerStatsViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PlayerStatsViewModel_Factory create(Provider<PlayerRepository> repositoryProvider) {
    return new PlayerStatsViewModel_Factory(repositoryProvider);
  }

  public static PlayerStatsViewModel newInstance(PlayerRepository repository) {
    return new PlayerStatsViewModel(repository);
  }
}
