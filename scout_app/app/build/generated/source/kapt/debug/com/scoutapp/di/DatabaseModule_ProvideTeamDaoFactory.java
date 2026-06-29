package com.scoutapp.di;

import com.scoutapp.data.local.ScoutDatabase;
import com.scoutapp.data.local.TeamDao;
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
public final class DatabaseModule_ProvideTeamDaoFactory implements Factory<TeamDao> {
  private final Provider<ScoutDatabase> databaseProvider;

  public DatabaseModule_ProvideTeamDaoFactory(Provider<ScoutDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TeamDao get() {
    return provideTeamDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideTeamDaoFactory create(
      Provider<ScoutDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTeamDaoFactory(databaseProvider);
  }

  public static TeamDao provideTeamDao(ScoutDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTeamDao(database));
  }
}
