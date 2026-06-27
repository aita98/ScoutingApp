package com.scoutapp.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJJ\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\tH\u00a7@\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/scoutapp/data/api/ApiFootballService;", "", "getPlayer", "Lcom/scoutapp/data/model/ApiFootballResponse;", "Lcom/scoutapp/data/model/ApiFootballPlayerData;", "apiKey", "", "host", "id", "", "season", "", "(Ljava/lang/String;Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPlayer", "name", "leagueId", "teamId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiFootballService {
    
    @retrofit2.http.GET(value = "players")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getPlayer(@retrofit2.http.Header(value = "x-rapidapi-key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Header(value = "x-rapidapi-host")
    @org.jetbrains.annotations.NotNull()
    java.lang.String host, @retrofit2.http.Query(value = "id")
    long id, @retrofit2.http.Query(value = "season")
    int season, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.ApiFootballResponse<com.scoutapp.data.model.ApiFootballPlayerData>> $completion);
    
    @retrofit2.http.GET(value = "players")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object searchPlayer(@retrofit2.http.Header(value = "x-rapidapi-key")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Header(value = "x-rapidapi-host")
    @org.jetbrains.annotations.NotNull()
    java.lang.String host, @retrofit2.http.Query(value = "search")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @retrofit2.http.Query(value = "league")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long leagueId, @retrofit2.http.Query(value = "team")
    @org.jetbrains.annotations.Nullable()
    java.lang.Long teamId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.model.ApiFootballResponse<com.scoutapp.data.model.ApiFootballPlayerData>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}