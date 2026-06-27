package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00130\u0012H\'J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u00152\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u00a7@\u00a2\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u00a7@\u00a2\u0006\u0002\u0010\u001eJ.\u0010\u001f\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u00a7@\u00a2\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\'H\u00a7@\u00a2\u0006\u0002\u0010(J\u001e\u0010)\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010&\u001a\u00020\'H\u00a7@\u00a2\u0006\u0002\u0010*\u00a8\u0006+"}, d2 = {"Lcom/scoutapp/data/local/PlayerDao;", "", "getEnrichmentByBackendId", "Lcom/scoutapp/data/local/PlayerEnrichmentEntity;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnrichmentByTmId", "tmId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerById", "Lcom/scoutapp/data/local/PlayerEntity;", "playerId", "getPlayerByName", "name", "getPlayerByTmId", "getWatchlist", "Lkotlinx/coroutines/flow/Flow;", "", "insertEnrichment", "", "enrichment", "(Lcom/scoutapp/data/local/PlayerEnrichmentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPlayers", "players", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRating", "rating", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatsCache", "goals", "", "assists", "minutes", "(JIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWatchlistStatus", "status", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWatchlistStatusByTmId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface PlayerDao {
    
    @androidx.room.Query(value = "SELECT * FROM cached_players WHERE isWatchlisted = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.data.local.PlayerEntity>> getWatchlist();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPlayers(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.local.PlayerEntity> players, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM cached_players WHERE id = :playerId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerById(long playerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.PlayerEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM cached_players WHERE tmId = :tmId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerByTmId(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.PlayerEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM cached_players WHERE name LIKE :name")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.PlayerEntity> $completion);
    
    @androidx.room.Query(value = "UPDATE cached_players SET isWatchlisted = :status WHERE id = :playerId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWatchlistStatus(long playerId, boolean status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE cached_players SET isWatchlisted = :status WHERE tmId = :tmId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWatchlistStatusByTmId(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, boolean status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE cached_players SET goals = :goals, assists = :assists, minutes = :minutes WHERE id = :playerId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStatsCache(long playerId, int goals, int assists, int minutes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertEnrichment(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerEnrichmentEntity enrichment, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM player_enrichment_cache WHERE tmId = :tmId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEnrichmentByTmId(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.PlayerEnrichmentEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM player_enrichment_cache WHERE backendId = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEnrichmentByBackendId(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.PlayerEnrichmentEntity> $completion);
    
    @androidx.room.Query(value = "UPDATE player_enrichment_cache SET rating = :rating WHERE tmId = :tmId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateRating(@org.jetbrains.annotations.NotNull()
    java.lang.String tmId, float rating, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}