package com.scoutapp.data.api

import com.scoutapp.data.model.*
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TransfermarktApiService {
    @GET("players/search/{query}")
    suspend fun searchAll(
        @Path("query") query: String
    ): TransfermarktSearchResponse

    @GET("players/{id}/profile")
    suspend fun getPlayerProfile(@Path("id") id: String): TransfermarktPlayerProfile

    @GET("players/{id}/market_value")
    suspend fun getPlayerMarketValue(@Path("id") id: String): TransfermarktMarketValueHistoryResponse

    @GET("players/{id}/transfers")
    suspend fun getPlayerTransfers(@Path("id") id: String): TransfermarktTransfersResponse

    @GET("players/{id}/jersey_numbers")
    suspend fun getPlayerJerseyNumbers(@Path("id") id: String): TransfermarktJerseyNumbersResponse

    @GET("players/{id}/performance-game")
    suspend fun getPlayerPerformanceGame(@Path("id") id: String): TransfermarktMatchLogResponse

    @GET("players/{id}/stats")
    suspend fun getPlayerDetailedStats(
        @Path("id") id: String,
        @Query("season_id") seasonId: String? = null,
        @Query("competition_id") competitionId: String? = null
    ): TransfermarktDetailedStatsResponse

    @GET("players/{id}/injuries")
    suspend fun getPlayerInjuries(@Path("id") id: String): TransfermarktInjuriesResponse

    @GET("players/{id}/achievements")
    suspend fun getPlayerAchievements(@Path("id") id: String): TransfermarktAchievementsResponse

    @GET("clubs/{id}/players")
    suspend fun getClubPlayers(
        @Path("id") id: String,
        @Query("season_id") seasonId: Int? = null
    ): TransfermarktClubPlayers

    @GET("competitions/{id}/clubs")
    suspend fun getCompetitionClubs(
        @Path("id") competitionId: String,
        @Query("season_id") seasonId: Int? = null
    ): TransfermarktCompetitionClubs

    // Nota: getPlayerMatchLog e getDirectStats sono state rimosse 
    // perché la logica è stata migrata interamente sul Backend Spring Boot.
}
