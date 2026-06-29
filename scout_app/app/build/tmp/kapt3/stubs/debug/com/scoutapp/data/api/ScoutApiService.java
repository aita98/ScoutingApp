package com.scoutapp.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\fJ \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0010J,\u0010\u0014\u001a\u00020\u00152\b\b\u0001\u0010\u0016\u001a\u00020\u000f2\b\b\u0001\u0010\u0017\u001a\u00020\u000f2\b\b\u0001\u0010\u0018\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u001d\u001a\u00020\u00132\b\b\u0001\u0010\u001e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020!2\b\b\u0001\u0010\u001e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u0018\u0010\"\u001a\u00020#2\b\b\u0001\u0010\u001e\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010%\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0003\u0010\'\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010-\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00122\b\b\u0001\u00100\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0018\u00104\u001a\u0002052\b\b\u0001\u00106\u001a\u000207H\u00a7@\u00a2\u0006\u0002\u00108J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J \u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e0\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\'\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ,\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\n\b\u0003\u0010=\u001a\u0004\u0018\u00010\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ\u001e\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010?\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001fJ$\u0010@\u001a\u00020\u00132\b\b\u0001\u0010\u001e\u001a\u00020\u00062\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u00a7@\u00a2\u0006\u0002\u0010A\u00a8\u0006B"}, d2 = {"Lcom/scoutapp/data/api/ScoutApiService;", "", "addToWatchlist", "Lretrofit2/Response;", "", "playerId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "comparePlayers", "Lcom/scoutapp/data/api/ComparisonResponse;", "id1", "id2", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBackendStatus", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHiddenGems", "", "Lcom/scoutapp/data/api/PlayerResponse;", "getHybridStats", "Lcom/scoutapp/data/api/fbref/FbrefStatsResponseDto;", "tmId", "fbrefId", "slug", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeagues", "Lcom/scoutapp/data/api/LeagueResponse;", "getOneToWatch", "getPlayerDetail", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerPerformance", "Lcom/scoutapp/data/api/CompetitionStatsResponse;", "getPlayerRadar", "Lcom/scoutapp/data/api/RadarResponse;", "getPlayersByClub", "clubName", "getPlayersFromDb", "query", "getScoutFeed", "Lcom/scoutapp/data/api/ScoutEventResponse;", "getSyncStatus", "Lcom/scoutapp/data/model/SyncStatus;", "getTeamPlayers", "teamId", "getTeams", "Lcom/scoutapp/data/api/TeamResponse;", "leagueId", "getTopProspects", "getWatchlist", "Lcom/scoutapp/data/api/WatchlistResponse;", "performAIScout", "Lcom/scoutapp/data/model/AIScoutResponse;", "request", "Lcom/scoutapp/data/model/AIScoutRequest;", "(Lcom/scoutapp/data/model/AIScoutRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromWatchlist", "resetBackendData", "searchPlayersBackend", "startupBackend", "season", "syncLeague", "code", "syncPlayerWithTM", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ScoutApiService {
    
    @retrofit2.http.GET(value = "api/players/otw")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOneToWatch(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/players/hidden-gems")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHiddenGems(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/scout-feed")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getScoutFeed(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.ScoutEventResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/players/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerDetail(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.PlayerResponse> $completion);
    
    @retrofit2.http.GET(value = "api/players/{id}/radar")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerRadar(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.RadarResponse> $completion);
    
    @retrofit2.http.GET(value = "api/players/{id}/performance")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerPerformance(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.CompetitionStatsResponse> $completion);
    
    @retrofit2.http.GET(value = "api/leagues")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLeagues(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.LeagueResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/leagues/{id}/teams")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTeams(@retrofit2.http.Path(value = "id")
    long leagueId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.TeamResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/leagues/team/{teamId}/players")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTeamPlayers(@retrofit2.http.Path(value = "teamId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String teamId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/players/club/{clubName}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayersByClub(@retrofit2.http.Path(value = "clubName")
    @org.jetbrains.annotations.NotNull()
    java.lang.String clubName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/players/top-prospects")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTopProspects(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.GET(value = "api/players/compare")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object comparePlayers(@retrofit2.http.Query(value = "playerA")
    long id1, @retrofit2.http.Query(value = "playerB")
    long id2, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.ComparisonResponse> $completion);
    
    @retrofit2.http.GET(value = "api/watchlist")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWatchlist(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.WatchlistResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/watchlist/{playerId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addToWatchlist(@retrofit2.http.Path(value = "playerId")
    long playerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.DELETE(value = "api/watchlist/{playerId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeFromWatchlist(@retrofit2.http.Path(value = "playerId")
    long playerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.GET(value = "api/players/search")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchPlayersBackend(@retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/players/{id}/sync-tm")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object syncPlayerWithTM(@retrofit2.http.Path(value = "id")
    long id, @retrofit2.http.Query(value = "tmId")
    @org.jetbrains.annotations.Nullable()
    java.lang.String tmId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.PlayerResponse> $completion);
    
    @retrofit2.http.POST(value = "api/sync/league/{code}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object syncLeague(@retrofit2.http.Path(value = "code")
    @org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> $completion);
    
    @retrofit2.http.POST(value = "api/ai/scout")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object performAIScout(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.scoutapp.data.model.AIScoutRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.AIScoutResponse> $completion);
    
    @retrofit2.http.GET(value = "api/players/db")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayersFromDb(@retrofit2.http.Query(value = "query")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.scoutapp.data.api.PlayerResponse>> $completion);
    
    @retrofit2.http.POST(value = "api/system/startup")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object startupBackend(@retrofit2.http.Query(value = "season")
    @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.String>>> $completion);
    
    @retrofit2.http.POST(value = "api/system/reset-data")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resetBackendData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.String>>> $completion);
    
    @retrofit2.http.GET(value = "api/system/status")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBackendStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.Map<java.lang.String, java.lang.Object>>> $completion);
    
    @retrofit2.http.GET(value = "api/sync/status")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSyncStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.scoutapp.data.model.SyncStatus>> $completion);
    
    @retrofit2.http.GET(value = "api/fbref/stats/combined/{tmId}/{fbrefId}/{slug}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHybridStats(@retrofit2.http.Path(value = "tmId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String tmId, @retrofit2.http.Path(value = "fbrefId")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fbrefId, @retrofit2.http.Path(value = "slug")
    @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.fbref.FbrefStatsResponseDto> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}