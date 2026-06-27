package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u00106\u001a\u000207J\u000e\u00108\u001a\u000207H\u0082@\u00a2\u0006\u0002\u00109J\b\u0010:\u001a\u000207H\u0002J\b\u0010;\u001a\u000207H\u0002J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0010H\u0002J\u0006\u0010?\u001a\u000207J\u000e\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\u0010J\u0006\u0010B\u001a\u000207J\u0006\u0010C\u001a\u000207R\"\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00140\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\"\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\"\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00170\"\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170\"\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\"\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\"\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00140\"\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u001d\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\"\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0019\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\"\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$\u00a8\u0006D"}, d2 = {"Lcom/scoutapp/viewmodel/ScoutingViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/scoutapp/data/api/ScoutApiService;", "tmApiService", "Lcom/scoutapp/data/api/TransfermarktApiService;", "playerRepository", "Lcom/scoutapp/domain/repository/PlayerRepository;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "networkHelper", "Lcom/scoutapp/utils/NetworkHelper;", "(Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/api/TransfermarktApiService;Lcom/scoutapp/domain/repository/PlayerRepository;Lcom/scoutapp/data/local/PlayerDao;Lcom/scoutapp/utils/NetworkHelper;)V", "_backendStatusInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "_error", "_hiddenGems", "", "Lcom/scoutapp/data/api/PlayerResponse;", "_isBackendConnected", "", "_isLoading", "_isOffline", "_otw", "_scoutFeed", "Lcom/scoutapp/data/api/ScoutEventResponse;", "_searchResults", "Lcom/scoutapp/data/model/TransfermarktSearchResult;", "_syncStatus", "Lcom/scoutapp/data/model/SyncStatus;", "backendStatusInfo", "Lkotlinx/coroutines/flow/StateFlow;", "getBackendStatusInfo", "()Lkotlinx/coroutines/flow/StateFlow;", "error", "getError", "hiddenGems", "getHiddenGems", "isBackendConnected", "isLoading", "isOffline", "otw", "getOtw", "scoutFeed", "getScoutFeed", "searchResults", "getSearchResults", "syncStatus", "getSyncStatus", "watchlist", "getWatchlist", "loadAllData", "", "loadDataFromTransfermarkt", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMockData", "monitorBackendSync", "parseMarketValueToDouble", "", "valueStr", "resetBackendData", "searchPlayers", "query", "startupBackend", "triggerSync", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ScoutingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.ScoutApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.TransfermarktApiService tmApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.domain.repository.PlayerRepository playerRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.local.PlayerDao playerDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.utils.NetworkHelper networkHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> _otw = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> otw = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> _hiddenGems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> hiddenGems = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.scoutapp.data.model.TransfermarktSearchResult>> _searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.model.TransfermarktSearchResult>> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> watchlist = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isOffline = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOffline = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isBackendConnected = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isBackendConnected = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.lang.Object>> _backendStatusInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Object>> backendStatusInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.scoutapp.data.api.ScoutEventResponse>> _scoutFeed = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.ScoutEventResponse>> scoutFeed = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.scoutapp.data.model.SyncStatus> _syncStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.scoutapp.data.model.SyncStatus> syncStatus = null;
    
    @javax.inject.Inject()
    public ScoutingViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService apiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.TransfermarktApiService tmApiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.domain.repository.PlayerRepository playerRepository, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerDao playerDao, @org.jetbrains.annotations.NotNull()
    com.scoutapp.utils.NetworkHelper networkHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> getOtw() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> getHiddenGems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.model.TransfermarktSearchResult>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.PlayerResponse>> getWatchlist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isOffline() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isBackendConnected() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.Object>> getBackendStatusInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.scoutapp.data.api.ScoutEventResponse>> getScoutFeed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.scoutapp.data.model.SyncStatus> getSyncStatus() {
        return null;
    }
    
    private final void monitorBackendSync() {
    }
    
    public final void loadAllData() {
    }
    
    private final java.lang.Object loadDataFromTransfermarkt(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void searchPlayers(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final double parseMarketValueToDouble(java.lang.String valueStr) {
        return 0.0;
    }
    
    private final void loadMockData() {
    }
    
    public final void triggerSync() {
    }
    
    public final void startupBackend() {
    }
    
    public final void resetBackendData() {
    }
}