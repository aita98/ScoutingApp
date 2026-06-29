package com.scoutapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0002R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/scoutapp/ui/screens/TeamDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "tmApiService", "Lcom/scoutapp/data/api/TransfermarktApiService;", "scoutApiService", "Lcom/scoutapp/data/api/ScoutApiService;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "(Lcom/scoutapp/data/api/TransfermarktApiService;Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/local/PlayerDao;)V", "_dbPlayers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/scoutapp/data/api/PlayerResponse;", "_error", "", "_isLoading", "", "_players", "displayPlayers", "Lkotlinx/coroutines/flow/StateFlow;", "getDisplayPlayers", "()Lkotlinx/coroutines/flow/StateFlow;", "error", "getError", "isLoading", "players", "getPlayers", "loadTeamPlayers", "", "teamId", "parseMarketValue", "", "valueStr", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TeamDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.TransfermarktApiService tmApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.ScoutApiService scoutApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.local.PlayerDao playerDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> _players = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> players = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> _dbPlayers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> displayPlayers = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    
    @javax.inject.Inject()
    public TeamDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.TransfermarktApiService tmApiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService scoutApiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerDao playerDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> getPlayers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> getDisplayPlayers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    public final void loadTeamPlayers(@org.jetbrains.annotations.NotNull()
    java.lang.String teamId) {
    }
    
    private final double parseMarketValue(java.lang.String valueStr) {
        return 0.0;
    }
}