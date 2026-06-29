package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0014J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u00c6\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0006H\u00d6\u0001J\t\u0010!\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\""}, d2 = {"Lcom/scoutapp/data/model/GameInformation;", "", "gameId", "", "competitionId", "seasonId", "", "season", "Lcom/scoutapp/data/model/SeasonInfo;", "date", "Lcom/scoutapp/data/model/DateInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/scoutapp/data/model/SeasonInfo;Lcom/scoutapp/data/model/DateInfo;)V", "getCompetitionId", "()Ljava/lang/String;", "getDate", "()Lcom/scoutapp/data/model/DateInfo;", "getGameId", "getSeason", "()Lcom/scoutapp/data/model/SeasonInfo;", "getSeasonId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/scoutapp/data/model/SeasonInfo;Lcom/scoutapp/data/model/DateInfo;)Lcom/scoutapp/data/model/GameInformation;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class GameInformation {
    @com.google.gson.annotations.SerializedName(value = "gameId")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String gameId = null;
    @com.google.gson.annotations.SerializedName(value = "competitionId")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String competitionId = null;
    @com.google.gson.annotations.SerializedName(value = "seasonId")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer seasonId = null;
    @com.google.gson.annotations.SerializedName(value = "season")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.SeasonInfo season = null;
    @com.google.gson.annotations.SerializedName(value = "date")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.DateInfo date = null;
    
    public GameInformation(@org.jetbrains.annotations.Nullable()
    java.lang.String gameId, @org.jetbrains.annotations.Nullable()
    java.lang.String competitionId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer seasonId, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.SeasonInfo season, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.DateInfo date) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGameId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCompetitionId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSeasonId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.SeasonInfo getSeason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.DateInfo getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.SeasonInfo component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.DateInfo component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.GameInformation copy(@org.jetbrains.annotations.Nullable()
    java.lang.String gameId, @org.jetbrains.annotations.Nullable()
    java.lang.String competitionId, @org.jetbrains.annotations.Nullable()
    java.lang.Integer seasonId, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.SeasonInfo season, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.DateInfo date) {
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