package com.scoutapp.data.api.fbref;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/scoutapp/data/api/fbref/FbrefApi;", "", "getStats", "Lcom/scoutapp/data/api/fbref/FbrefStatsResponseDto;", "fbrefId", "", "slug", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolvePlayer", "Lcom/scoutapp/data/api/fbref/FbrefResolveResponseDto;", "name", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FbrefApi {
    
    @retrofit2.http.GET(value = "resolve/{name}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object resolvePlayer(@retrofit2.http.Path(value = "name")
    @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.fbref.FbrefResolveResponseDto> $completion);
    
    @retrofit2.http.GET(value = "stats/{fbref_id}/{slug}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStats(@retrofit2.http.Path(value = "fbref_id")
    @org.jetbrains.annotations.NotNull()
    java.lang.String fbrefId, @retrofit2.http.Path(value = "slug")
    @org.jetbrains.annotations.NotNull()
    java.lang.String slug, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.scoutapp.data.api.fbref.FbrefStatsResponseDto> $completion);
}