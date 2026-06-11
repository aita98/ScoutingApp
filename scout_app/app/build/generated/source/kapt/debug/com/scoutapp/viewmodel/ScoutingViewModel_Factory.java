package com.scoutapp.viewmodel;

import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.PlayerDao;
import com.scoutapp.utils.NetworkHelper;
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
public final class ScoutingViewModel_Factory implements Factory<ScoutingViewModel> {
  private final Provider<ScoutApiService> apiServiceProvider;

  private final Provider<TransfermarktApiService> tmApiServiceProvider;

  private final Provider<PlayerDao> playerDaoProvider;

  private final Provider<NetworkHelper> networkHelperProvider;

  public ScoutingViewModel_Factory(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider, Provider<PlayerDao> playerDaoProvider,
      Provider<NetworkHelper> networkHelperProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.tmApiServiceProvider = tmApiServiceProvider;
    this.playerDaoProvider = playerDaoProvider;
    this.networkHelperProvider = networkHelperProvider;
  }

  @Override
  public ScoutingViewModel get() {
    return newInstance(apiServiceProvider.get(), tmApiServiceProvider.get(), playerDaoProvider.get(), networkHelperProvider.get());
  }

  public static ScoutingViewModel_Factory create(Provider<ScoutApiService> apiServiceProvider,
      Provider<TransfermarktApiService> tmApiServiceProvider, Provider<PlayerDao> playerDaoProvider,
      Provider<NetworkHelper> networkHelperProvider) {
    return new ScoutingViewModel_Factory(apiServiceProvider, tmApiServiceProvider, playerDaoProvider, networkHelperProvider);
  }

  public static ScoutingViewModel newInstance(ScoutApiService apiService,
      TransfermarktApiService tmApiService, PlayerDao playerDao, NetworkHelper networkHelper) {
    return new ScoutingViewModel(apiService, tmApiService, playerDao, networkHelper);
  }
}
