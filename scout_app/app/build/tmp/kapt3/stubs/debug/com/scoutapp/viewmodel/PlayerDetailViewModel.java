package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0015J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0002J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ \u0010 \u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00152\b\b\u0002\u0010!\u001a\u00020\u001fH\u0082@\u00a2\u0006\u0002\u0010\"R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006#"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/scoutapp/data/api/ScoutApiService;", "tmApiService", "Lcom/scoutapp/data/api/TransfermarktApiService;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "(Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/api/TransfermarktApiService;Lcom/scoutapp/data/local/PlayerDao;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/scoutapp/viewmodel/PlayerDetailState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "forceRefresh", "", "id", "", "tmId", "", "loadPlayer", "idString", "parseMarketValue", "", "valueStr", "toggleWatchlist", "player", "Lcom/scoutapp/data/api/PlayerResponse;", "currentStatus", "", "tryLoadFromTransfermarkt", "isWatchlisted", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayerDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.ScoutApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.TransfermarktApiService tmApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.local.PlayerDao playerDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.scoutapp.viewmodel.PlayerDetailState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.PlayerDetailState> uiState = null;
    
    @javax.inject.Inject()
    public PlayerDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService apiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.TransfermarktApiService tmApiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerDao playerDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.PlayerDetailState> getUiState() {
        return null;
    }
    
    public final void loadPlayer(@org.jetbrains.annotations.NotNull()
    java.lang.String idString) {
    }
    
    public final void forceRefresh(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String tmId) {
    }
    
    private final java.lang.Object tryLoadFromTransfermarkt(java.lang.String id, boolean isWatchlisted, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void toggleWatchlist(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.PlayerResponse player, boolean currentStatus) {
    }
    
    private final double parseMarketValue(java.lang.String valueStr) {
        return 0.0;
    }
}