package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J+\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerStatsViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/scoutapp/domain/repository/PlayerRepository;", "(Lcom/scoutapp/domain/repository/PlayerRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/scoutapp/viewmodel/PlayerStatsState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadPlayerStats", "", "playerSlug", "", "tmId", "internalId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayerStatsViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.domain.repository.PlayerRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.scoutapp.viewmodel.PlayerStatsState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.PlayerStatsState> uiState = null;
    
    @javax.inject.Inject()
    public PlayerStatsViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.domain.repository.PlayerRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.PlayerStatsState> getUiState() {
        return null;
    }
    
    public final void loadPlayerStats(@org.jetbrains.annotations.NotNull()
    java.lang.String playerSlug, @org.jetbrains.annotations.Nullable()
    java.lang.String tmId, @org.jetbrains.annotations.Nullable()
    java.lang.Long internalId) {
    }
}