package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u00c6\u0003J9\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/scoutapp/data/model/MatchStatistics;", "", "goalStatistics", "Lcom/scoutapp/data/model/GoalStatistics;", "cardStatistics", "Lcom/scoutapp/data/model/CardStatistics;", "distributionStatistics", "Lcom/scoutapp/data/model/DistributionStatistics;", "playingTimeStatistics", "Lcom/scoutapp/data/model/PlayingTimeStatistics;", "(Lcom/scoutapp/data/model/GoalStatistics;Lcom/scoutapp/data/model/CardStatistics;Lcom/scoutapp/data/model/DistributionStatistics;Lcom/scoutapp/data/model/PlayingTimeStatistics;)V", "getCardStatistics", "()Lcom/scoutapp/data/model/CardStatistics;", "getDistributionStatistics", "()Lcom/scoutapp/data/model/DistributionStatistics;", "getGoalStatistics", "()Lcom/scoutapp/data/model/GoalStatistics;", "getPlayingTimeStatistics", "()Lcom/scoutapp/data/model/PlayingTimeStatistics;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class MatchStatistics {
    @com.google.gson.annotations.SerializedName(value = "goalStatistics")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.GoalStatistics goalStatistics = null;
    @com.google.gson.annotations.SerializedName(value = "cardStatistics")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.CardStatistics cardStatistics = null;
    @com.google.gson.annotations.SerializedName(value = "distributionStatistics")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.DistributionStatistics distributionStatistics = null;
    @com.google.gson.annotations.SerializedName(value = "playingTimeStatistics")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.PlayingTimeStatistics playingTimeStatistics = null;
    
    public MatchStatistics(@org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.GoalStatistics goalStatistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.CardStatistics cardStatistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.DistributionStatistics distributionStatistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.PlayingTimeStatistics playingTimeStatistics) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.GoalStatistics getGoalStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.CardStatistics getCardStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.DistributionStatistics getDistributionStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.PlayingTimeStatistics getPlayingTimeStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.GoalStatistics component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.CardStatistics component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.DistributionStatistics component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.PlayingTimeStatistics component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.MatchStatistics copy(@org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.GoalStatistics goalStatistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.CardStatistics cardStatistics, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.DistributionStatistics distributionStatistics, @org.jetbrains.annotations.Nullable()
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