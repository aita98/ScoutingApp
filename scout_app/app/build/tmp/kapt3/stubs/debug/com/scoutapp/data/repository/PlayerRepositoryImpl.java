package com.scoutapp.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00162\u0006\u0010!\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ,\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b%\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\'"}, d2 = {"Lcom/scoutapp/data/repository/PlayerRepositoryImpl;", "Lcom/scoutapp/domain/repository/PlayerRepository;", "tmApi", "Lcom/scoutapp/data/api/TransfermarktApiService;", "fbrefApi", "Lcom/scoutapp/data/api/fbref/FbrefApi;", "apiService", "Lcom/scoutapp/data/api/ScoutApiService;", "matchDao", "Lcom/scoutapp/data/local/MatchDao;", "(Lcom/scoutapp/data/api/TransfermarktApiService;Lcom/scoutapp/data/api/fbref/FbrefApi;Lcom/scoutapp/data/api/ScoutApiService;Lcom/scoutapp/data/local/MatchDao;)V", "getDirectTransfermarktStats", "Lcom/scoutapp/domain/model/PlayerStats;", "tmId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHybridPlayerStats", "fbrefId", "slug", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerMatchLog", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/scoutapp/domain/model/PlayerMatchPerformance;", "playerId", "", "getPlayerStats", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolvePlayer", "Lkotlin/Pair;", "name", "searchPlayers", "Lcom/scoutapp/domain/model/Player;", "query", "syncPlayerMatchLog", "Lkotlin/Result;", "", "syncPlayerMatchLog-0E7RQCE", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class PlayerRepositoryImpl implements com.scoutapp.domain.repository.PlayerRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.TransfermarktApiService tmApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.fbref.FbrefApi fbrefApi = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.api.ScoutApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.scoutapp.data.local.MatchDao matchDao = null;
    
    @javax.inject.Inject()
    public PlayerRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.TransfermarktApiService tmApi, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.fbref.FbrefApi fbrefApi, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.ScoutApiService apiService, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.MatchDao matchDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object searchPlayers(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.domain.model.Player>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getPlayerStats(@org.jetbrains.annotations.NotNull()
    java.lang.String fbrefId, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.domain.model.PlayerStats> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getHybridPlayerStats(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, @org.jetbrains.annotations.NotNull()
    java.lang.String fbrefId, @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.domain.model.PlayerStats> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object resolvePlayer(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.String>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getDirectTransfermarktStats(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.domain.model.PlayerStats> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.domain.model.PlayerMatchPerformance>> getPlayerMatchLog(long playerId) {
        return null;
    }
}