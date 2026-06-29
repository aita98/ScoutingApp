package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u001c\u0010\r\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u00a7@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/scoutapp/data/local/TeamDao;", "", "deleteTeamsByLeague", "", "leagueId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTeamById", "Lcom/scoutapp/data/local/TeamEntity;", "id", "getTeamsByLeague", "Lkotlinx/coroutines/flow/Flow;", "", "insertTeams", "teams", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface TeamDao {
    
    @androidx.room.Query(value = "SELECT * FROM teams WHERE leagueId = :leagueId ORDER BY name ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scoutapp.data.local.TeamEntity>> getTeamsByLeague(@org.jetbrains.annotations.NotNull()
    java.lang.String leagueId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertTeams(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.local.TeamEntity> teams, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM teams WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTeamById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.local.TeamEntity> $completion);
    
    @androidx.room.Query(value = "DELETE FROM teams WHERE leagueId = :leagueId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTeamsByLeague(@org.jetbrains.annotations.NotNull()
    java.lang.String leagueId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}