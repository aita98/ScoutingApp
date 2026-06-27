package com.scoutapp.di;

import com.scoutapp.data.local.MatchDao;
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
public final class DatabaseModule_ProvideMatchDaoFactory implements Factory<MatchDao> {
  private final Provider<ScoutDatabase> databaseProvider;

  public DatabaseModule_ProvideMatchDaoFactory(Provider<ScoutDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public MatchDao get() {
    return provideMatchDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideMatchDaoFactory create(
      Provider<ScoutDatabase> databaseProvider) {
    return new DatabaseModule_ProvideMatchDaoFactory(databaseProvider);
  }

  public static MatchDao provideMatchDao(ScoutDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideMatchDao(database));
  }
}
