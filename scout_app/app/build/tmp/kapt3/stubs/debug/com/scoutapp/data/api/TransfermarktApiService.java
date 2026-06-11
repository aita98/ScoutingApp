package com.scoutapp.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\r2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0012\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/scoutapp/data/api/TransfermarktApiService;", "", "getClubPlayers", "Lcom/scoutapp/data/model/TransfermarktClubPlayers;", "id", "", "seasonId", "", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompetitionClubs", "Lcom/scoutapp/data/model/TransfermarktCompetitionClubs;", "competitionId", "getPlayerHeader", "Lcom/scoutapp/data/model/TransfermarktPlayerProfile;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayerProfile", "searchAll", "Lcom/scoutapp/data/model/TransfermarktSearchResponse;", "query", "app_debug"})
public abstract interface TransfermarktApiService {
    
    @retrofit2.http.GET(value = "players/search/{query}/")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchAll(@retrofit2.http.Path(value = "query")
    @org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.TransfermarktSearchResponse> $completion);
    
    @retrofit2.http.GET(value = "players/{id}/profile")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerProfile(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.TransfermarktPlayerProfile> $completion);
    
    @retrofit2.http.GET(value = "players/{id}/profile")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayerHeader(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.TransfermarktPlayerProfile> $completion);
    
    @retrofit2.http.GET(value = "clubs/{id}/players")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getClubPlayers(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String id, @retrofit2.http.Query(value = "season_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer seasonId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.TransfermarktClubPlayers> $completion);
    
    @retrofit2.http.GET(value = "competitions/{id}/clubs")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCompetitionClubs(@retrofit2.http.Path(value = "id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String competitionId, @retrofit2.http.Query(value = "season_id")
    @org.jetbrains.annotations.Nullable()
    java.lang.Integer seasonId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.TransfermarktCompetitionClubs> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}