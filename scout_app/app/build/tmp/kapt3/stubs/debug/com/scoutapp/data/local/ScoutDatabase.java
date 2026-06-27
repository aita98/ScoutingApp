package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/scoutapp/data/local/ScoutDatabase;", "Landroidx/room/RoomDatabase;", "()V", "matchDao", "Lcom/scoutapp/data/local/MatchDao;", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "app_debug"})
@androidx.room.Database(entities = {com.scoutapp.data.local.PlayerEntity.class, com.scoutapp.data.local.PlayerEnrichmentEntity.class, com.scoutapp.data.local.MatchEntity.class, com.scoutapp.data.local.MatchPerformanceEntity.class}, version = 15, exportSchema = false)
public abstract class ScoutDatabase extends androidx.room.RoomDatabase {
    
    public ScoutDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.PlayerDao playerDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.MatchDao matchDao();
}