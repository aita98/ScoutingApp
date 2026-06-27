package com.scoutapp.data.api.fbref;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010(\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010)\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0092\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0005H\u00d6\u0001J\t\u00102\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001e\u00a8\u00063"}, d2 = {"Lcom/scoutapp/data/api/fbref/FbrefStatsDto;", "", "season", "", "minutes", "", "matches", "goals", "assists", "xG", "", "xA", "keyPasses", "progressivePasses", "progressiveCarries", "pressures", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAssists", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGoals", "getKeyPasses", "getMatches", "getMinutes", "getPressures", "getProgressiveCarries", "getProgressivePasses", "getSeason", "()Ljava/lang/String;", "getXA", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getXG", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/scoutapp/data/api/fbref/FbrefStatsDto;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class FbrefStatsDto {
    @com.google.gson.annotations.SerializedName(value = "season")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String season = null;
    @com.google.gson.annotations.SerializedName(value = "minutes", alternate = {"minutes_played"})
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer minutes = null;
    @com.google.gson.annotations.SerializedName(value = "matches", alternate = {"matches_played"})
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer matches = null;
    @com.google.gson.annotations.SerializedName(value = "goals")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer goals = null;
    @com.google.gson.annotations.SerializedName(value = "assists")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer assists = null;
    @com.google.gson.annotations.SerializedName(value = "xG")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double xG = null;
    @com.google.gson.annotations.SerializedName(value = "xA")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double xA = null;
    @com.google.gson.annotations.SerializedName(value = "key_passes")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer keyPasses = null;
    @com.google.gson.annotations.SerializedName(value = "progressive_passes")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer progressivePasses = null;
    @com.google.gson.annotations.SerializedName(value = "progressive_carries")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer progressiveCarries = null;
    @com.google.gson.annotations.SerializedName(value = "pressures")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer pressures = null;
    
    public FbrefStatsDto(@org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer matches, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Double xG, @org.jetbrains.annotations.Nullable()
    java.lang.Double xA, @org.jetbrains.annotations.Nullable()
    java.lang.Integer keyPasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressivePasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressiveCarries, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pressures) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSeason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMinutes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMatches() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGoals() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAssists() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getXG() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getXA() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getKeyPasses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getProgressivePasses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getProgressiveCarries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPressures() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.fbref.FbrefStatsDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer matches, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Double xG, @org.jetbrains.annotations.Nullable()
    java.lang.Double xA, @org.jetbrains.annotations.Nullable()
    java.lang.Integer keyPasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressivePasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressiveCarries, @org.jetbrains.annotations.Nullable()
    java.lang.Integer pressures) {
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