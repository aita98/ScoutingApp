package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0017H\u0002J\b\u0010>\u001a\u00020?H\u0002J \u0010@\u001a\u00020?2\u0006\u0010=\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u00122\u0006\u0010B\u001a\u00020\u0012H\u0002J\u0006\u0010C\u001a\u00020?J\u000e\u0010D\u001a\u00020?H\u0082@\u00a2\u0006\u0002\u0010EJ\b\u0010F\u001a\u00020?H\u0002J\b\u0010G\u001a\u00020?H\u0002J\b\u0010H\u001a\u00020?H\u0002J\u0012\u0010I\u001a\u00020<2\b\u0010J\u001a\u0004\u0018\u00010\u0012H\u0002J\u0006\u0010K\u001a\u00020?J\u001c\u0010L\u001a\u00020?2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0082@\u00a2\u0006\u0002\u0010NJ\u000e\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\u0012J\u0006\u0010Q\u001a\u00020?J\u0006\u0010R\u001a\u00020?R\"\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00160\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R%\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00110$\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120$\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160$\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190$\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190$\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00190$\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160$\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u001201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u001201X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00160$\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u001d\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00160$\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0019\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0$\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160$\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010&\u00a8\u0006S"}, d2 = {"Lcom/scoutapp/viewmodel/ScoutingViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/scoutapp/data/api/ScoutApiService;", "tmApiService", "Lcom/scoutapp/data/api/TransfermarktApiService;", "playerRepository", "Lcom/scoutapp/domain/repository/PlayerRepository;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "enrichmentRepository", "Lcom/scoutapp/data/repository/EnrichmentRepository;", "networkHelper", "Lcom/scoutapp/utils/NetworkHelper;", "(Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/api/TransfermarktApiService;Lcom/scoutapp/domain/repository/PlayerRepository;Lcom/scoutapp/data/local/PlayerDao;Lcom/scoutapp/data/repository/EnrichmentRepository;Lcom/scoutapp/utils/NetworkHelper;)V", "_backendStatusInfo", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "_error", "_hiddenGems", "", "Lcom/scoutapp/data/api/PlayerResponse;", "_isBackendConnected", "", "_isLoading", "_isOffline", "_otw", "_scoutFeed", "Lcom/scoutapp/data/api/ScoutEventResponse;", "_searchResults", "Lcom/scoutapp/data/model/TransfermarktSearchResult;", "_syncStatus", "Lcom/scoutapp/data/model/SyncStatus;", "backendStatusInfo", "Lkotlinx/coroutines/flow/StateFlow;", "getBackendStatusInfo", "()Lkotlinx/coroutines/flow/StateFlow;", "error", "getError", "hiddenGems", "getHiddenGems", "isBackendConnected", "isLoading", "isOffline", "otw", "getOtw", "previousGemIds", "", "previousOtwIds", "scoutFeed", "getScoutFeed", "searchResults", "getSearchResults", "syncStatus", "getSyncStatus", "watchlist", "getWatchlist", "calculateOwnership", "", "player", "enrichPlayersMissingData", "", "generateLocalFeedEvent", "type", "description", "loadAllData", "loadDataFromTransfermarkt", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadMockData", "monitorBackendSync", "observeDatabasePlayers", "parseMarketValueToDouble", "valueStr", "resetBackendData", "savePlayersToDb", "players", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPlayers", "query", "startupBackend", "triggerSync", "app_debug"})
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
    private final com.scoutapp.data.repository.EnrichmentRepository enrichmentRepository = null;
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
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> previousOtwIds;
    @org.jetbrains.annotations.NotNull()
    private java.util.Set<java.lang.String> previousGemIds;
    
    @javax.inject.Inject()
    public ScoutingViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService apiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.TransfermarktApiService tmApiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.domain.repository.PlayerRepository playerRepository, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerDao playerDao, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.repository.EnrichmentRepository enrichmentRepository, @org.jetbrains.annotations.NotNull()
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
    
    private final void enrichPlayersMissingData() {
    }
    
    private final void observeDatabasePlayers() {
    }
    
    private final void generateLocalFeedEvent(com.scoutapp.data.api.PlayerResponse player, java.lang.String type, java.lang.String description) {
    }
    
    private final double calculateOwnership(com.scoutapp.data.api.PlayerResponse player) {
        return 0.0;
    }
    
    private final void monitorBackendSync() {
    }
    
    public final void loadAllData() {
    }
    
    private final java.lang.Object savePlayersToDb(java.util.List<com.scoutapp.data.api.PlayerResponse> players, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
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