package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u0003H\'J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u0007H\'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00040\u00032\u0006\u0010\u0018\u001a\u00020\u0007H\'J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u001dJ\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u00a7@\u00a2\u0006\u0002\u0010\'J6\u0010(\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u00a7@\u00a2\u0006\u0002\u0010.J\u001e\u0010/\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u00a7@\u00a2\u0006\u0002\u00102J\u001e\u00103\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u00100\u001a\u000201H\u00a7@\u00a2\u0006\u0002\u00104J\u001c\u00105\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0097@\u00a2\u0006\u0002\u0010 \u00a8\u00066"}, d2 = {"Lcom/scoutapp/data/local/PlayerDao;", "", "getAllPlayers", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/scoutapp/data/local/PlayerEntity;", "getAvailableLeagues", "", "getEnrichmentByBackendId", "Lcom/scoutapp/data/local/PlayerEnrichmentEntity;", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnrichmentByTmId", "tmId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerById", "playerId", "getPlayerByName", "name", "getPlayerByTmId", "getPlayersInClub", "clubName", "getTeamsInLeague", "leagueName", "getWatchlist", "insertEnrichment", "", "enrichment", "(Lcom/scoutapp/data/local/PlayerEnrichmentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPlayersRaw", "players", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlayer", "player", "(Lcom/scoutapp/data/local/PlayerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRating", "rating", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateStatsCache", "goals", "", "assists", "minutes", "matchesPlayed", "(JIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWatchlistStatus", "status", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWatchlistStatusByTmId", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upsertPlayersPreservingLocalFields", "app_debug"})
@androidx.room.Dao()
public abstract interface PlayerDao {
    
    @androidx.room.Query(value = "SELECT * FROM cached_players WHERE isWatchlisted = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.data.local.PlayerEntity>> getWatchlist();
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertPlayersRaw(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.local.PlayerEntity> players, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.Long>> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updatePlayer(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.local.PlayerEntity player, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Transaction()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object upsertPlayersPreservingLocalFields(@org.jetbrains.annotations.NotNull()
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
    
    @androidx.room.Query(value = "SELECT * FROM cached_players")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.data.local.PlayerEntity>> getAllPlayers();
    
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
    
    @androidx.room.Query(value = "UPDATE cached_players SET goals = :goals, assists = :assists, minutes = :minutes, matchesPlayed = :matchesPlayed WHERE id = :playerId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateStatsCache(long playerId, int goals, int assists, int minutes, int matchesPlayed, @org.jetbrains.annotations.NotNull()
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
    
    @androidx.room.Query(value = "SELECT DISTINCT league FROM cached_players WHERE league IS NOT NULL")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getAvailableLeagues();
    
    @androidx.room.Query(value = "SELECT DISTINCT club FROM cached_players WHERE league = :leagueName")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getTeamsInLeague(@org.jetbrains.annotations.NotNull()
    java.lang.String leagueName);
    
    @androidx.room.Query(value = "SELECT * FROM cached_players WHERE club = :clubName")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.data.local.PlayerEntity>> getPlayersInClub(@org.jetbrains.annotations.NotNull()
    java.lang.String clubName);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @androidx.room.Transaction()
        @org.jetbrains.annotations.Nullable()
        public static java.lang.Object upsertPlayersPreservingLocalFields(@org.jetbrains.annotations.NotNull()
        com.scoutapp.data.local.PlayerDao $this, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.local.PlayerEntity> players, @org.jetbrains.annotations.NotNull()
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}