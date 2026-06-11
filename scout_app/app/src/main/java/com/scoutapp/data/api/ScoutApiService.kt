package com.scoutapp.data.api

import com.scoutapp.data.model.AIScoutRequest
import com.scoutapp.data.model.AIScoutResponse
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.DELETE

interface ScoutApiService {
    @GET("api/players/recommended")
    suspend fun getRecommended(): List<PlayerResponse>

    @GET("api/players/hidden-gems")
    suspend fun getHiddenGems(): List<PlayerResponse>

    @GET("api/scout-feed")
    suspend fun getScoutFeed(): List<ScoutEventResponse>

    @GET("api/players/{id}")
    suspend fun getPlayerDetail(@Path("id") id: Long): PlayerResponse

    @GET("api/players/{id}/radar")
    suspend fun getPlayerRadar(@Path("id") id: Long): RadarResponse

    @GET("api/leagues")
    suspend fun getLeagues(): List<LeagueResponse>

    @GET("api/leagues/{id}/teams")
    suspend fun getTeams(@Path("id") leagueId: Long): List<TeamResponse>

    @GET("api/leagues/team/{teamId}/players")
    suspend fun getTeamPlayers(@Path("teamId") teamId: String): List<PlayerResponse>

    @GET("api/players/club/{clubName}")
    suspend fun getPlayersByClub(@Path("clubName") clubName: String): List<PlayerResponse>

    @GET("api/players/top-prospects")
    suspend fun getTopProspects(): List<PlayerResponse>

    @GET("api/players/compare")
    suspend fun comparePlayers(@Query("playerA") id1: Long, @Query("playerB") id2: Long): ComparisonResponse

    @GET("api/watchlist")
    suspend fun getWatchlist(): List<WatchlistResponse>

    @POST("api/watchlist/{playerId}")
    suspend fun addToWatchlist(@Path("playerId") playerId: Long): retrofit2.Response<Unit>

    @DELETE("api/watchlist/{playerId}")
    suspend fun removeFromWatchlist(@Path("playerId") playerId: Long): retrofit2.Response<Unit>

    @GET("api/players/search")
    suspend fun searchPlayersBackend(@Query("query") query: String): List<PlayerResponse>

    @POST("api/players/{id}/sync-tm")
    suspend fun syncPlayerWithTM(@Path("id") id: Long, @Query("tmId") tmId: String?): PlayerResponse

    @POST("api/sync/league/{code}")
    suspend fun syncLeague(@Path("code") code: String): retrofit2.Response<Unit>

    @POST("api/ai/scout")
    suspend fun performAIScout(@Body request: AIScoutRequest): AIScoutResponse

    @POST("api/system/startup")
    suspend fun startupBackend(): retrofit2.Response<Map<String, String>>

    @POST("api/system/reset-data")
    suspend fun resetBackendData(): retrofit2.Response<Map<String, String>>

    @GET("api/system/status")
    suspend fun getBackendStatus(): retrofit2.Response<Map<String, Any>>
}

data class LeagueResponse(val id: Long, val name: String, val country: String, val logoUrl: String?)
data class TeamResponse(val id: Long, val name: String, val city: String, val logoUrl: String?)

data class RadarResponse(
    val pace: Int,
    val shooting: Int,
    val passing: Int,
    val dribbling: Int,
    val physical: Int,
    val intelligence: Int
)

data class ComparisonResponse(
    val playerA: PlayerSummaryResponse,
    val playerB: PlayerSummaryResponse
)

data class PlayerSummaryResponse(
    val name: String,
    val club: String?,
    val goalsPer90: Double,
    val assistsPer90: Double,
    val minutesPlayed: Int,
    val starterPercentage: Double,
    val talentScore: Double,
    val hiddenGemScore: Double
)

data class WatchlistResponse(
    val id: Long,
    val player: PlayerResponse,
    val dateAdded: String,
    val talentScoreAtAdd: Double,
    val hiddenGemScoreAtAdd: Double
)

data class PlayerResponse(
    val id: Long,
    @SerializedName("tmId")
    val tmId: String? = null,
    val name: String?,
    val club: String?,
    val age: Int? = null,
    val marketValue: Double? = null,
    val talentScore: Double?,
    val hiddenGemScore: Double?,
    val position: String?,
    val photoUrl: String?,
    @SerializedName("statistics")
    val statistics: List<SeasonStats>? = null
) {
    val seasonStats: SeasonStats?
        get() = statistics?.firstOrNull()
}

data class SeasonStats(
    val appearances: Int,
    val goals: Int,
    val assists: Int,
    val yellowCards: Int,
    val redCards: Int,
    @SerializedName("minutes")
    val minutesPlayed: Int
)

data class ScoutEventResponse(
    val id: Long,
    val eventType: String?,
    val description: String?,
    val createdAt: String?,
    val player: PlayerResponse?
)
