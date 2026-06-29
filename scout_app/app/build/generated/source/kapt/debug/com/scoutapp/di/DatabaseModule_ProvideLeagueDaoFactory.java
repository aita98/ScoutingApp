package com.scoutapp.di;

import com.scoutapp.data.local.LeagueDao;
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
public final class DatabaseModule_ProvideLeagueDaoFactory implements Factory<LeagueDao> {
  private final Provider<ScoutDatabase> databaseProvider;

  public DatabaseModule_ProvideLeagueDaoFactory(Provider<ScoutDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public LeagueDao get() {
    return provideLeagueDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideLeagueDaoFactory create(
      Provider<ScoutDatabase> databaseProvider) {
    return new DatabaseModule_ProvideLeagueDaoFactory(databaseProvider);
  }

  public static LeagueDao provideLeagueDao(ScoutDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideLeagueDao(database));
  }
}
