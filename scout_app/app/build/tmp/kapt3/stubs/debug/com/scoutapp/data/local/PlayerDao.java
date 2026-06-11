package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\bH\'J\u001c\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/scoutapp/data/local/PlayerDao;", "", "getPlayerById", "Lcom/scoutapp/data/local/PlayerEntity;", "playerId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWatchlist", "Lkotlinx/coroutines/flow/Flow;", "", "insertPlayers", "", "players", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWatchlistStatus", "status", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
    
    @androidx.room.Query(value = "UPDATE cached_players SET isWatchlisted = :status WHERE id = :playerId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateWatchlistStatus(long playerId, boolean status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}