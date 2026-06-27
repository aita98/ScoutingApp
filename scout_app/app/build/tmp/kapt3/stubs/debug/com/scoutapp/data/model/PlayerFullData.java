package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\tH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JC\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020#H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006$"}, d2 = {"Lcom/scoutapp/data/model/PlayerFullData;", "", "transfermarkt", "Lcom/scoutapp/data/api/PlayerResponse;", "fbref", "Lcom/scoutapp/domain/model/PlayerStats;", "apiFootball", "Lcom/scoutapp/data/model/ApiFootballPlayerData;", "userRating", "", "radar", "Lcom/scoutapp/data/api/RadarResponse;", "(Lcom/scoutapp/data/api/PlayerResponse;Lcom/scoutapp/domain/model/PlayerStats;Lcom/scoutapp/data/model/ApiFootballPlayerData;FLcom/scoutapp/data/api/RadarResponse;)V", "getApiFootball", "()Lcom/scoutapp/data/model/ApiFootballPlayerData;", "getFbref", "()Lcom/scoutapp/domain/model/PlayerStats;", "getRadar", "()Lcom/scoutapp/data/api/RadarResponse;", "getTransfermarkt", "()Lcom/scoutapp/data/api/PlayerResponse;", "getUserRating", "()F", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class PlayerFullData {
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.api.PlayerResponse transfermarkt = null;
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.domain.model.PlayerStats fbref = null;
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.ApiFootballPlayerData apiFootball = null;
    private final float userRating = 0.0F;
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.api.RadarResponse radar = null;
    
    public PlayerFullData(@org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.PlayerResponse transfermarkt, @org.jetbrains.annotations.Nullable()
    com.scoutapp.domain.model.PlayerStats fbref, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.ApiFootballPlayerData apiFootball, float userRating, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.RadarResponse radar) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.PlayerResponse getTransfermarkt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.domain.model.PlayerStats getFbref() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.ApiFootballPlayerData getApiFootball() {
        return null;
    }
    
    public final float getUserRating() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.RadarResponse getRadar() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.PlayerResponse component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.domain.model.PlayerStats component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.ApiFootballPlayerData component3() {
        return null;
    }
    
    public final float component4() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.RadarResponse component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.PlayerFullData copy(@org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.PlayerResponse transfermarkt, @org.jetbrains.annotations.Nullable()
    com.scoutapp.domain.model.PlayerStats fbref, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.ApiFootballPlayerData apiFootball, float userRating, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.RadarResponse radar) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}