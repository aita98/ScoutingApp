package com.scoutapp;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.scoutapp.data.api.ScoutApiService;
import com.scoutapp.data.api.TransfermarktApiService;
import com.scoutapp.data.local.PlayerDao;
import com.scoutapp.data.local.ScoutDatabase;
import com.scoutapp.di.DatabaseModule_ProvideDatabaseFactory;
import com.scoutapp.di.DatabaseModule_ProvidePlayerDaoFactory;
import com.scoutapp.di.NetworkModule_ProvideOkHttpClientFactory;
import com.scoutapp.di.NetworkModule_ProvideScoutApiServiceFactory;
import com.scoutapp.di.NetworkModule_ProvideScoutRetrofitFactory;
import com.scoutapp.di.NetworkModule_ProvideTransfermarktApiServiceFactory;
import com.scoutapp.di.NetworkModule_ProvideTransfermarktRetrofitFactory;
import com.scoutapp.ui.screens.LeagueTeamsViewModel;
import com.scoutapp.ui.screens.LeagueTeamsViewModel_HiltModules;
import com.scoutapp.ui.screens.LeaguesViewModel;
import com.scoutapp.ui.screens.LeaguesViewModel_HiltModules;
import com.scoutapp.ui.screens.TeamDetailViewModel;
import com.scoutapp.ui.screens.TeamDetailViewModel_HiltModules;
import com.scoutapp.utils.NetworkHelper;
import com.scoutapp.viewmodel.AIScoutViewModel;
import com.scoutapp.viewmodel.AIScoutViewModel_HiltModules;
import com.scoutapp.viewmodel.PlayerDetailViewModel;
import com.scoutapp.viewmodel.PlayerDetailViewModel_HiltModules;
import com.scoutapp.viewmodel.ScoutingViewModel;
import com.scoutapp.viewmodel.ScoutingViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerScoutApp_HiltComponents_SingletonC {
  private DaggerScoutApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public ScoutApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements ScoutApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements ScoutApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements ScoutApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements ScoutApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements ScoutApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements ScoutApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements ScoutApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public ScoutApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends ScoutApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends ScoutApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends ScoutApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends ScoutApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(6).put(LazyClassKeyProvider.com_scoutapp_viewmodel_AIScoutViewModel, AIScoutViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_scoutapp_ui_screens_LeagueTeamsViewModel, LeagueTeamsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_scoutapp_ui_screens_LeaguesViewModel, LeaguesViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_scoutapp_viewmodel_PlayerDetailViewModel, PlayerDetailViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_scoutapp_viewmodel_ScoutingViewModel, ScoutingViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_scoutapp_ui_screens_TeamDetailViewModel, TeamDetailViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_scoutapp_viewmodel_AIScoutViewModel = "com.scoutapp.viewmodel.AIScoutViewModel";

      static String com_scoutapp_viewmodel_PlayerDetailViewModel = "com.scoutapp.viewmodel.PlayerDetailViewModel";

      static String com_scoutapp_ui_screens_LeagueTeamsViewModel = "com.scoutapp.ui.screens.LeagueTeamsViewModel";

      static String com_scoutapp_ui_screens_LeaguesViewModel = "com.scoutapp.ui.screens.LeaguesViewModel";

      static String com_scoutapp_ui_screens_TeamDetailViewModel = "com.scoutapp.ui.screens.TeamDetailViewModel";

      static String com_scoutapp_viewmodel_ScoutingViewModel = "com.scoutapp.viewmodel.ScoutingViewModel";

      @KeepFieldType
      AIScoutViewModel com_scoutapp_viewmodel_AIScoutViewModel2;

      @KeepFieldType
      PlayerDetailViewModel com_scoutapp_viewmodel_PlayerDetailViewModel2;

      @KeepFieldType
      LeagueTeamsViewModel com_scoutapp_ui_screens_LeagueTeamsViewModel2;

      @KeepFieldType
      LeaguesViewModel com_scoutapp_ui_screens_LeaguesViewModel2;

      @KeepFieldType
      TeamDetailViewModel com_scoutapp_ui_screens_TeamDetailViewModel2;

      @KeepFieldType
      ScoutingViewModel com_scoutapp_viewmodel_ScoutingViewModel2;
    }
  }

  private static final class ViewModelCImpl extends ScoutApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AIScoutViewModel> aIScoutViewModelProvider;

    private Provider<LeagueTeamsViewModel> leagueTeamsViewModelProvider;

    private Provider<LeaguesViewModel> leaguesViewModelProvider;

    private Provider<PlayerDetailViewModel> playerDetailViewModelProvider;

    private Provider<ScoutingViewModel> scoutingViewModelProvider;

    private Provider<TeamDetailViewModel> teamDetailViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.aIScoutViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.leagueTeamsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.leaguesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.playerDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.scoutingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.teamDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(6).put(LazyClassKeyProvider.com_scoutapp_viewmodel_AIScoutViewModel, ((Provider) aIScoutViewModelProvider)).put(LazyClassKeyProvider.com_scoutapp_ui_screens_LeagueTeamsViewModel, ((Provider) leagueTeamsViewModelProvider)).put(LazyClassKeyProvider.com_scoutapp_ui_screens_LeaguesViewModel, ((Provider) leaguesViewModelProvider)).put(LazyClassKeyProvider.com_scoutapp_viewmodel_PlayerDetailViewModel, ((Provider) playerDetailViewModelProvider)).put(LazyClassKeyProvider.com_scoutapp_viewmodel_ScoutingViewModel, ((Provider) scoutingViewModelProvider)).put(LazyClassKeyProvider.com_scoutapp_ui_screens_TeamDetailViewModel, ((Provider) teamDetailViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_scoutapp_viewmodel_PlayerDetailViewModel = "com.scoutapp.viewmodel.PlayerDetailViewModel";

      static String com_scoutapp_ui_screens_TeamDetailViewModel = "com.scoutapp.ui.screens.TeamDetailViewModel";

      static String com_scoutapp_viewmodel_AIScoutViewModel = "com.scoutapp.viewmodel.AIScoutViewModel";

      static String com_scoutapp_ui_screens_LeagueTeamsViewModel = "com.scoutapp.ui.screens.LeagueTeamsViewModel";

      static String com_scoutapp_viewmodel_ScoutingViewModel = "com.scoutapp.viewmodel.ScoutingViewModel";

      static String com_scoutapp_ui_screens_LeaguesViewModel = "com.scoutapp.ui.screens.LeaguesViewModel";

      @KeepFieldType
      PlayerDetailViewModel com_scoutapp_viewmodel_PlayerDetailViewModel2;

      @KeepFieldType
      TeamDetailViewModel com_scoutapp_ui_screens_TeamDetailViewModel2;

      @KeepFieldType
      AIScoutViewModel com_scoutapp_viewmodel_AIScoutViewModel2;

      @KeepFieldType
      LeagueTeamsViewModel com_scoutapp_ui_screens_LeagueTeamsViewModel2;

      @KeepFieldType
      ScoutingViewModel com_scoutapp_viewmodel_ScoutingViewModel2;

      @KeepFieldType
      LeaguesViewModel com_scoutapp_ui_screens_LeaguesViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.scoutapp.viewmodel.AIScoutViewModel 
          return (T) new AIScoutViewModel(singletonCImpl.provideScoutApiServiceProvider.get());

          case 1: // com.scoutapp.ui.screens.LeagueTeamsViewModel 
          return (T) new LeagueTeamsViewModel(singletonCImpl.provideTransfermarktApiServiceProvider.get());

          case 2: // com.scoutapp.ui.screens.LeaguesViewModel 
          return (T) new LeaguesViewModel(singletonCImpl.provideTransfermarktApiServiceProvider.get(), singletonCImpl.provideScoutApiServiceProvider.get());

          case 3: // com.scoutapp.viewmodel.PlayerDetailViewModel 
          return (T) new PlayerDetailViewModel(singletonCImpl.provideScoutApiServiceProvider.get(), singletonCImpl.provideTransfermarktApiServiceProvider.get(), singletonCImpl.playerDao());

          case 4: // com.scoutapp.viewmodel.ScoutingViewModel 
          return (T) new ScoutingViewModel(singletonCImpl.provideScoutApiServiceProvider.get(), singletonCImpl.provideTransfermarktApiServiceProvider.get(), singletonCImpl.playerDao(), singletonCImpl.networkHelperProvider.get());

          case 5: // com.scoutapp.ui.screens.TeamDetailViewModel 
          return (T) new TeamDetailViewModel(singletonCImpl.provideTransfermarktApiServiceProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends ScoutApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends ScoutApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends ScoutApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<Retrofit> provideScoutRetrofitProvider;

    private Provider<ScoutApiService> provideScoutApiServiceProvider;

    private Provider<Retrofit> provideTransfermarktRetrofitProvider;

    private Provider<TransfermarktApiService> provideTransfermarktApiServiceProvider;

    private Provider<ScoutDatabase> provideDatabaseProvider;

    private Provider<NetworkHelper> networkHelperProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private PlayerDao playerDao() {
      return DatabaseModule_ProvidePlayerDaoFactory.providePlayerDao(provideDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 2));
      this.provideScoutRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 1));
      this.provideScoutApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<ScoutApiService>(singletonCImpl, 0));
      this.provideTransfermarktRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 4));
      this.provideTransfermarktApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<TransfermarktApiService>(singletonCImpl, 3));
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<ScoutDatabase>(singletonCImpl, 5));
      this.networkHelperProvider = DoubleCheck.provider(new SwitchingProvider<NetworkHelper>(singletonCImpl, 6));
    }

    @Override
    public void injectScoutApp(ScoutApp scoutApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.scoutapp.data.api.ScoutApiService 
          return (T) NetworkModule_ProvideScoutApiServiceFactory.provideScoutApiService(singletonCImpl.provideScoutRetrofitProvider.get());

          case 1: // @javax.inject.Named("ScoutRetrofit") retrofit2.Retrofit 
          return (T) NetworkModule_ProvideScoutRetrofitFactory.provideScoutRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 2: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient();

          case 3: // com.scoutapp.data.api.TransfermarktApiService 
          return (T) NetworkModule_ProvideTransfermarktApiServiceFactory.provideTransfermarktApiService(singletonCImpl.provideTransfermarktRetrofitProvider.get());

          case 4: // @javax.inject.Named("TransfermarktRetrofit") retrofit2.Retrofit 
          return (T) NetworkModule_ProvideTransfermarktRetrofitFactory.provideTransfermarktRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 5: // com.scoutapp.data.local.ScoutDatabase 
          return (T) DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // com.scoutapp.utils.NetworkHelper 
          return (T) new NetworkHelper(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
