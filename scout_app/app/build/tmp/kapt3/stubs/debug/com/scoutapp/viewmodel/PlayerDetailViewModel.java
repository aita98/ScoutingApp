package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00192\b\b\u0002\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0016\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00192\u0006\u0010\'\u001a\u00020(J\u0016\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020 R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006-"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/scoutapp/data/api/ScoutApiService;", "tmApiService", "Lcom/scoutapp/data/api/TransfermarktApiService;", "playerRepository", "Lcom/scoutapp/domain/repository/PlayerRepository;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "enrichmentRepository", "Lcom/scoutapp/data/repository/EnrichmentRepository;", "gson", "Lcom/google/gson/Gson;", "(Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/api/TransfermarktApiService;Lcom/scoutapp/domain/repository/PlayerRepository;Lcom/scoutapp/data/local/PlayerDao;Lcom/scoutapp/data/repository/EnrichmentRepository;Lcom/google/gson/Gson;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/scoutapp/viewmodel/PlayerDetailState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "calculateAgeFromDescription", "", "description", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "extractBirthDate", "loadPlayer", "", "idString", "forceRefresh", "", "parseMarketValueFromProfile", "", "value", "", "ratePlayer", "tmId", "rating", "", "toggleWatchlist", "player", "Lcom/scoutapp/data/api/PlayerResponse;", "currentStatus", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PlayerDetailViewModel extends androidx.lifecycle.ViewModel {
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
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.scoutapp.viewmodel.PlayerDetailState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.PlayerDetailState> uiState = null;
    
    @javax.inject.Inject()
    public PlayerDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService apiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.TransfermarktApiService tmApiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.domain.repository.PlayerRepository playerRepository, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerDao playerDao, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.repository.EnrichmentRepository enrichmentRepository, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.PlayerDetailState> getUiState() {
        return null;
    }
    
    public final void loadPlayer(@org.jetbrains.annotations.NotNull()
    java.lang.String idString, boolean forceRefresh) {
    }
    
    private final java.lang.Integer calculateAgeFromDescription(java.lang.String description) {
        return null;
    }
    
    private final java.lang.String extractBirthDate(java.lang.String description) {
        return null;
    }
    
    private final double parseMarketValueFromProfile(java.lang.Object value) {
        return 0.0;
    }
    
    public final void toggleWatchlist(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.PlayerResponse player, boolean currentStatus) {
    }
    
    public final void ratePlayer(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, float rating) {
    }
}