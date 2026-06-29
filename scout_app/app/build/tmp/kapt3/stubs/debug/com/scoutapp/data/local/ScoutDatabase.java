package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/scoutapp/data/local/ScoutDatabase;", "Landroidx/room/RoomDatabase;", "()V", "leagueDao", "Lcom/scoutapp/data/local/LeagueDao;", "matchDao", "Lcom/scoutapp/data/local/MatchDao;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "teamDao", "Lcom/scoutapp/data/local/TeamDao;", "app_debug"})
@androidx.room.Database(entities = {com.scoutapp.data.local.PlayerEntity.class, com.scoutapp.data.local.PlayerEnrichmentEntity.class, com.scoutapp.data.local.MatchEntity.class, com.scoutapp.data.local.MatchPerformanceEntity.class, com.scoutapp.data.local.LeagueEntity.class, com.scoutapp.data.local.TeamEntity.class}, version = 21, exportSchema = false)
public abstract class ScoutDatabase extends androidx.room.RoomDatabase {
    
    public ScoutDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.PlayerDao playerDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.MatchDao matchDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.LeagueDao leagueDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.TeamDao teamDao();
}