package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/scoutapp/viewmodel/AIScoutViewModel;", "Landroidx/lifecycle/ViewModel;", "apiService", "Lcom/scoutapp/data/api/ScoutApiService;", "groqService", "Lcom/scoutapp/data/api/GroqService;", "(Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/api/GroqService;)V", "_isBackendConnected", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_uiState", "Lcom/scoutapp/viewmodel/AIScoutUiState;", "isBackendConnected", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "uiState", "getUiState", "checkBackendStatus", "", "performAIScout", "description", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AIScoutViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.ScoutApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.GroqService groqService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.scoutapp.viewmodel.AIScoutUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.AIScoutUiState> uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isBackendConnected = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isBackendConnected = null;
    
    @javax.inject.Inject()
    public AIScoutViewModel(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService apiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.GroqService groqService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.scoutapp.viewmodel.AIScoutUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isBackendConnected() {
        return null;
    }
    
    public final void checkBackendStatus() {
    }
    
    public final void performAIScout(@org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
}