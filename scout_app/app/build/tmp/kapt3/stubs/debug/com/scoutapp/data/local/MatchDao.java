package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\'J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0097@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/scoutapp/data/local/MatchDao;", "", "getMatchById", "Lcom/scoutapp/data/local/MatchEntity;", "matchId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPerformancesForPlayer", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/scoutapp/data/local/MatchPerformanceEntity;", "playerId", "", "getPlayerTotals", "Lcom/scoutapp/data/local/PlayerTotals;", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMatch", "", "match", "(Lcom/scoutapp/data/local/MatchEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMatchWithPerformance", "performance", "(Lcom/scoutapp/data/local/MatchEntity;Lcom/scoutapp/data/local/MatchPerformanceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPerformance", "(Lcom/scoutapp/data/local/MatchPerformanceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface MatchDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMatch(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.MatchEntity match, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPerformance(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.MatchPerformanceEntity performance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMatchWithPerformance(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.MatchEntity match, @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.MatchPerformanceEntity performance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM matches WHERE id = :matchId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMatchById(int matchId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.MatchEntity> $completion);
    
    @androidx.room.Query(value = "\n        SELECT * FROM player_match_performance \n        WHERE playerId = :playerId \n        ORDER BY matchId DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.data.local.MatchPerformanceEntity>> getPerformancesForPlayer(long playerId);
    
    @androidx.room.Query(value = "\n        SELECT SUM(goals) as totalGoals, SUM(assists) as totalAssists, SUM(minutesPlayed) as totalMinutes \n        FROM player_match_performance \n        WHERE playerId = :playerId\n    ")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerTotals(long playerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.PlayerTotals> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object insertMatchWithPerformance(@org.jetbrains.annotations.NotNull()
        com.scoutapp.data.local.MatchDao $this, @org.jetbrains.annotations.NotNull()
        com.scoutapp.data.local.MatchEntity match, @org.jetbrains.annotations.NotNull()
        com.scoutapp.data.local.MatchPerformanceEntity performance, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}