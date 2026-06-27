package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003JE\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/scoutapp/data/model/TransfermarktMatchPerformance;", "", "participationState", "", "gameInformation", "Lcom/scoutapp/data/model/GameInformation;", "clubsInformation", "Lcom/scoutapp/data/model/ClubsInformation;", "statistics", "Lcom/scoutapp/data/model/MatchStatistics;", "playingTimeStatistics", "Lcom/scoutapp/data/model/PlayingTimeStatistics;", "(Ljava/lang/String;Lcom/scoutapp/data/model/GameInformation;Lcom/scoutapp/data/model/ClubsInformation;Lcom/scoutapp/data/model/MatchStatistics;Lcom/scoutapp/data/model/PlayingTimeStatistics;)V", "getClubsInformation", "()Lcom/scoutapp/data/model/ClubsInformation;", "getGameInformation", "()Lcom/scoutapp/data/model/GameInformation;", "getParticipationState", "()Ljava/lang/String;", "getPlayingTimeStatistics", "()Lcom/scoutapp/data/model/PlayingTimeStatistics;", "getStatistics", "()Lcom/scoutapp/data/model/MatchStatistics;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class TransfermarktMatchPerformance {
    @com.google.gson.annotations.SerializedName(value = "participationState")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String participationState = null;
    @com.google.gson.annotations.SerializedName(value = "gameInformation")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.GameInformation gameInformation = null;
    @com.google.gson.annotations.SerializedName(value = "clubsInformation")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.ClubsInformation clubsInformation = null;
    @com.google.gson.annotations.SerializedName(value = "statistics")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.MatchStatistics statistics = null;
    @com.google.gson.annotations.SerializedName(value = "playingTimeStatistics")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.PlayingTimeStatistics playingTimeStatistics = null;
    
    public TransfermarktMatchPerformance(@org.jetbrains.annotations.Nullable()
    java.lang.String participationState, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.GameInformation gameInformation, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.ClubsInformation clubsInformation, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.MatchStatistics statistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.PlayingTimeStatistics playingTimeStatistics) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParticipationState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.GameInformation getGameInformation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.ClubsInformation getClubsInformation() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.MatchStatistics getStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.PlayingTimeStatistics getPlayingTimeStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.GameInformation component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.ClubsInformation component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.MatchStatistics component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.PlayingTimeStatistics component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.TransfermarktMatchPerformance copy(@org.jetbrains.annotations.Nullable()
    java.lang.String participationState, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.GameInformation gameInformation, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.ClubsInformation clubsInformation, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.MatchStatistics statistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.PlayingTimeStatistics playingTimeStatistics) {
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