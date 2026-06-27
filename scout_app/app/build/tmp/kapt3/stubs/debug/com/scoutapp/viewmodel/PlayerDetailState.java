package com.scoutapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerDetailState;", "", "()V", "Error", "Loading", "Success", "Lcom/scoutapp/viewmodel/PlayerDetailState$Error;", "Lcom/scoutapp/viewmodel/PlayerDetailState$Loading;", "Lcom/scoutapp/viewmodel/PlayerDetailState$Success;", "app_debug"})
public abstract class PlayerDetailState {
    
    private PlayerDetailState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerDetailState$Error;", "Lcom/scoutapp/viewmodel/PlayerDetailState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Error extends com.scoutapp.viewmodel.PlayerDetailState {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.scoutapp.viewmodel.PlayerDetailState.Error copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerDetailState$Loading;", "Lcom/scoutapp/viewmodel/PlayerDetailState;", "()V", "app_debug"})
    public static final class Loading extends com.scoutapp.viewmodel.PlayerDetailState {
        @org.jetbrains.annotations.NotNull()
        public static final com.scoutapp.viewmodel.PlayerDetailState.Loading INSTANCE = null;
        
        private Loading() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\"J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00160\tH\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00160\tH\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u000f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001e0\tH\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010 H\u00c6\u0003J\t\u0010E\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010I\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u00c6\u0003J\u000f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00100\tH\u00c6\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120\tH\u00c6\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u0087\u0002\u0010N\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010O\u001a\u00020\u00072\b\u0010P\u001a\u0004\u0018\u00010QH\u00d6\u0003J\t\u0010R\u001a\u00020SH\u00d6\u0001J\t\u0010T\u001a\u00020\u0016H\u00d6\u0001R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010$R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 \u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010&R\u0011\u0010!\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010.R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\t\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010$\u00a8\u0006U"}, d2 = {"Lcom/scoutapp/viewmodel/PlayerDetailState$Success;", "Lcom/scoutapp/viewmodel/PlayerDetailState;", "player", "Lcom/scoutapp/data/api/PlayerResponse;", "radar", "Lcom/scoutapp/data/api/RadarResponse;", "isWatchlisted", "", "tmTransfers", "", "Lcom/scoutapp/data/model/TransfermarktTransfer;", "tmInjuries", "Lcom/scoutapp/data/model/TransfermarktInjury;", "tmAchievements", "Lcom/scoutapp/data/model/TransfermarktAchievement;", "tmMarketValueHistory", "Lcom/scoutapp/data/model/TransfermarktMarketValuePoint;", "tmDetailedStats", "Lcom/scoutapp/data/model/TransfermarktDetailedStat;", "fbrefStats", "Lcom/scoutapp/domain/model/PlayerStats;", "foot", "", "shirtNumber", "citizenship", "contractExpires", "birthDate", "availableSeasons", "selectedSeason", "recentMatches", "Lcom/scoutapp/data/api/RecentMatch;", "enrichedData", "Lcom/scoutapp/data/model/PlayerFullData;", "isStatsLoading", "(Lcom/scoutapp/data/api/PlayerResponse;Lcom/scoutapp/data/api/RadarResponse;ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/scoutapp/domain/model/PlayerStats;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/scoutapp/data/model/PlayerFullData;Z)V", "getAvailableSeasons", "()Ljava/util/List;", "getBirthDate", "()Ljava/lang/String;", "getCitizenship", "getContractExpires", "getEnrichedData", "()Lcom/scoutapp/data/model/PlayerFullData;", "getFbrefStats", "()Lcom/scoutapp/domain/model/PlayerStats;", "getFoot", "()Z", "getPlayer", "()Lcom/scoutapp/data/api/PlayerResponse;", "getRadar", "()Lcom/scoutapp/data/api/RadarResponse;", "getRecentMatches", "getSelectedSeason", "getShirtNumber", "getTmAchievements", "getTmDetailedStats", "getTmInjuries", "getTmMarketValueHistory", "getTmTransfers", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class Success extends com.scoutapp.viewmodel.PlayerDetailState {
        @org.jetbrains.annotations.NotNull()
        private final com.scoutapp.data.api.PlayerResponse player = null;
        @org.jetbrains.annotations.Nullable()
        private final com.scoutapp.data.api.RadarResponse radar = null;
        private final boolean isWatchlisted = false;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.scoutapp.data.model.TransfermarktTransfer> tmTransfers = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.scoutapp.data.model.TransfermarktInjury> tmInjuries = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.scoutapp.data.model.TransfermarktAchievement> tmAchievements = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.scoutapp.data.model.TransfermarktMarketValuePoint> tmMarketValueHistory = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.scoutapp.data.model.TransfermarktDetailedStat> tmDetailedStats = null;
        @org.jetbrains.annotations.Nullable()
        private final com.scoutapp.domain.model.PlayerStats fbrefStats = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String foot = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String shirtNumber = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> citizenship = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String contractExpires = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String birthDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> availableSeasons = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String selectedSeason = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.scoutapp.data.api.RecentMatch> recentMatches = null;
        @org.jetbrains.annotations.Nullable()
        private final com.scoutapp.data.model.PlayerFullData enrichedData = null;
        private final boolean isStatsLoading = false;
        
        public Success(@org.jetbrains.annotations.NotNull()
        com.scoutapp.data.api.PlayerResponse player, @org.jetbrains.annotations.Nullable()
        com.scoutapp.data.api.RadarResponse radar, boolean isWatchlisted, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktTransfer> tmTransfers, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktInjury> tmInjuries, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktAchievement> tmAchievements, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktMarketValuePoint> tmMarketValueHistory, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktDetailedStat> tmDetailedStats, @org.jetbrains.annotations.Nullable()
        com.scoutapp.domain.model.PlayerStats fbrefStats, @org.jetbrains.annotations.Nullable()
        java.lang.String foot, @org.jetbrains.annotations.Nullable()
        java.lang.String shirtNumber, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> citizenship, @org.jetbrains.annotations.Nullable()
        java.lang.String contractExpires, @org.jetbrains.annotations.Nullable()
        java.lang.String birthDate, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> availableSeasons, @org.jetbrains.annotations.Nullable()
        java.lang.String selectedSeason, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.api.RecentMatch> recentMatches, @org.jetbrains.annotations.Nullable()
        com.scoutapp.data.model.PlayerFullData enrichedData, boolean isStatsLoading) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.scoutapp.data.api.PlayerResponse getPlayer() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.scoutapp.data.api.RadarResponse getRadar() {
            return null;
        }
        
        public final boolean isWatchlisted() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktTransfer> getTmTransfers() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktInjury> getTmInjuries() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktAchievement> getTmAchievements() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktMarketValuePoint> getTmMarketValueHistory() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktDetailedStat> getTmDetailedStats() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.scoutapp.domain.model.PlayerStats getFbrefStats() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getFoot() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getShirtNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getCitizenship() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getContractExpires() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBirthDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getAvailableSeasons() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSelectedSeason() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.api.RecentMatch> getRecentMatches() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.scoutapp.data.model.PlayerFullData getEnrichedData() {
            return null;
        }
        
        public final boolean isStatsLoading() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.scoutapp.data.api.PlayerResponse component1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component10() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component11() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component12() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component13() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component14() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component15() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component16() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.api.RecentMatch> component17() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.scoutapp.data.model.PlayerFullData component18() {
            return null;
        }
        
        public final boolean component19() {
            return false;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.scoutapp.data.api.RadarResponse component2() {
            return null;
        }
        
        public final boolean component3() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktTransfer> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktInjury> component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktAchievement> component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktMarketValuePoint> component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.scoutapp.data.model.TransfermarktDetailedStat> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.scoutapp.domain.model.PlayerStats component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.scoutapp.viewmodel.PlayerDetailState.Success copy(@org.jetbrains.annotations.NotNull()
        com.scoutapp.data.api.PlayerResponse player, @org.jetbrains.annotations.Nullable()
        com.scoutapp.data.api.RadarResponse radar, boolean isWatchlisted, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktTransfer> tmTransfers, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktInjury> tmInjuries, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktAchievement> tmAchievements, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktMarketValuePoint> tmMarketValueHistory, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.model.TransfermarktDetailedStat> tmDetailedStats, @org.jetbrains.annotations.Nullable()
        com.scoutapp.domain.model.PlayerStats fbrefStats, @org.jetbrains.annotations.Nullable()
        java.lang.String foot, @org.jetbrains.annotations.Nullable()
        java.lang.String shirtNumber, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> citizenship, @org.jetbrains.annotations.Nullable()
        java.lang.String contractExpires, @org.jetbrains.annotations.Nullable()
        java.lang.String birthDate, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> availableSeasons, @org.jetbrains.annotations.Nullable()
        java.lang.String selectedSeason, @org.jetbrains.annotations.NotNull()
        java.util.List<com.scoutapp.data.api.RecentMatch> recentMatches, @org.jetbrains.annotations.Nullable()
        com.scoutapp.data.model.PlayerFullData enrichedData, boolean isStatsLoading) {
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
}