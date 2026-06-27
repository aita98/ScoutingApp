package com.scoutapp.data.api

import com.scoutapp.data.model.ApiFootballPlayerData
import com.scoutapp.data.model.ApiFootballResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiFootballService {
    @GET("players")
    suspend fun getPlayer(
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String = "api-football-v1.p.rapidapi.com",
        @Query("id") id: Long,
        @Query("season") season: Int
    ): ApiFootballResponse<ApiFootballPlayerData>

    @GET("players")
    suspend fun searchPlayer(
        @Header("x-rapidapi-key") apiKey: String,
        @Header("x-rapidapi-host") host: String = "api-football-v1.p.rapidapi.com",
        @Query("search") name: String,
        @Query("league") leagueId: Long? = null,
        @Query("team") teamId: Long? = null
    ): ApiFootballResponse<ApiFootballPlayerData>
}
