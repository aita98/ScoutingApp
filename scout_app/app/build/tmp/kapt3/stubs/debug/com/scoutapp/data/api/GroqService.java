package com.scoutapp.data.api;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/scoutapp/data/api/GroqService;", "", "groqApiService", "Lcom/scoutapp/data/api/GroqApiService;", "(Lcom/scoutapp/data/api/GroqApiService;)V", "apiKey", "", "model", "systemPrompt", "generateScoutingReport", "Lcom/scoutapp/data/model/AIScoutResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GroqService {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.GroqApiService groqApiService = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String apiKey = "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";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String model = "llama-3.3-70b-versatile";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String systemPrompt = null;
    
    @javax.inject.Inject()
    public GroqService(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.GroqApiService groqApiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generateScoutingReport(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.AIScoutResponse> $completion) {
        return null;
    }
}