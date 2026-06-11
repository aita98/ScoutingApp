package com.scoutapp.di;

import com.scoutapp.data.local.PlayerDao;
import com.scoutapp.data.local.ScoutDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvidePlayerDaoFactory implements Factory<PlayerDao> {
  private final Provider<ScoutDatabase> databaseProvider;

  public DatabaseModule_ProvidePlayerDaoFactory(Provider<ScoutDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PlayerDao get() {
    return providePlayerDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvidePlayerDaoFactory create(
      Provider<ScoutDatabase> databaseProvider) {
    return new DatabaseModule_ProvidePlayerDaoFactory(databaseProvider);
  }

  public static PlayerDao providePlayerDao(ScoutDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePlayerDao(database));
  }
}
