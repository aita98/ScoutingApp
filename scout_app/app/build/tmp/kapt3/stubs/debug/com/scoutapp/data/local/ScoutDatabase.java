package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/scoutapp/data/local/ScoutDatabase;", "Landroidx/room/RoomDatabase;", "()V", "playerDao", "Lcom/scoutapp/data/local/PlayerDao;", "app_debug"})
@androidx.room.Database(entities = {com.scoutapp.data.local.PlayerEntity.class}, version = 2)
public abstract class ScoutDatabase extends androidx.room.RoomDatabase {
    
    public ScoutDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.scoutapp.data.local.PlayerDao playerDao();
}