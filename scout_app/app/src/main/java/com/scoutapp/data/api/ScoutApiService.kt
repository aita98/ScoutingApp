package com.scoutapp.data.api

import com.scoutapp.data.model.AIScoutRequest
import com.scoutapp.data.model.AIScoutResponse
import com.scoutapp.data.model.SyncStatus
import com.scoutapp.data.api.fbref.FbrefStatsResponseDto
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.POST
import retrofit2.http.Body
import retrofit2.http.DELETE

interface ScoutApiService {
    @GET("api/players/otw")
    suspend fun getOneToWatch(): List<PlayerResponse>

    @GET("api/players/hidden-gems")
    suspend fun getHiddenGems(): List<PlayerResponse>

    @GET("api/scout-feed")
    suspend fun getScoutFeed(): List<ScoutEventResponse>

    @GET("api/players/{id}")
    suspend fun getPlayerDetail(@Path("id") id: String): PlayerResponse

    @GET("api/players/{id}/radar")
    suspend fun getPlayerRadar(@Path("id") id: String): RadarResponse

    @GET("api/players/{id}/performance")
    suspend fun getPlayerPerformance(@Path("id") id: String): CompetitionStatsResponse

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

    @GET("api/players/db")
    suspend fun getPlayersFromDb(@Query("query") query: String = ""): List<PlayerResponse>

    @POST("api/system/startup")
    suspend fun startupBackend(@Query("season") season: String? = null): retrofit2.Response<Map<String, String>>

    @POST("api/system/reset-data")
    suspend fun resetBackendData(): retrofit2.Response<Map<String, String>>

    @GET("api/system/status")
    suspend fun getBackendStatus(): retrofit2.Response<Map<String, Any>>

    @GET("api/sync/status")
    suspend fun getSyncStatus(): retrofit2.Response<SyncStatus>

    @GET("api/fbref/stats/combined/{tmId}/{fbrefId}/{slug}")
    suspend fun getHybridStats(
        @Path("tmId") tmId: String,
        @Path("fbrefId") fbrefId: String,
        @Path("slug") slug: String
    ): FbrefStatsResponseDto
}

data class LeagueResponse(val id: Long, val name: String, val country: String, val logoUrl: String?)
data class TeamResponse(val id: Long, val name: String, val city: String, val logoUrl: String?)

data class RadarResponse(
    val pace: Int? = null,
    val shooting: Int? = null,
    val passing: Int? = null,
    val dribbling: Int? = null,
    val physical: Int? = null,
    val intelligence: Int? = null
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
    @SerializedName("transfermarktId")
    val transfermarktId: String? = null,
    @SerializedName("tmId")
    val tmId: String? = null,
    @SerializedName("fbrefSlug")
    val fbrefSlug: String? = null,
    val name: String? = null,
    val club: String? = null,
    val league: String? = null,
    val age: Int? = null,
    val marketValue: Double? = null,
    val marketValueDisplay: String? = null,
    val talentScore: Double? = null,
    val hiddenGemScore: Double? = null,
    
    val season: String? = null,
    val minutes: Int? = null,
    
    // Status flags
    val isConsigliato: Boolean? = false,
    val isHiddenGem: Boolean? = false,
    
    // Advanced Stats
    val goals: Int? = null,
    val assists: Int? = null,
    val xG: Double? = null,
    val xA: Double? = null,
    val keyPasses: Int? = null,
    val progressivePasses: Int? = null,
    val progressiveCarries: Int? = null,
    val matchesPlayed: Int? = null,
    val appearances: Int? = null,

    // Goalkeeper specific
    val goalsConceded: Int? = null,
    val cleanSheets: Int? = null,

    val position: String? = null,
    val photoUrl: String? = null,
    val isRetired: Boolean? = false,
    @SerializedName("statistics")
    val statistics: List<SeasonStats>? = null,
    @SerializedName("recentMatches")
    val recentMatches: List<RecentMatch>? = null,
    @SerializedName("radar")
    val radar: RadarResponse? = null
) {
    val seasonStats: SeasonStats?
        get() = statistics?.firstOrNull()
}

data class RecentMatch(
    val goals: Int? = null,
    val assists: Int? = null,
    val minutes: Int? = null,
    val isStarting: Boolean? = null
)

data class SeasonStats(
    val appearances: Int? = null,
    val goals: Int? = null,
    val assists: Int? = null,
    val yellowCards: Int? = null,
    val redCards: Int? = null,
    @SerializedName("minutes")
    val minutesPlayed: Int? = null,
    val goalsConceded: Int? = null,
    val cleanSheets: Int? = null
)

data class ScoutEventResponse(
    val id: Long,
    val eventType: String?,
    val description: String?,
    val createdAt: String?,
    val player: PlayerResponse?
)

data class CompetitionStatsResponse(
    val player: String?,
    val season: Int?,
    val competitions: Map<String, CompetitionData>?
)

data class CompetitionData(
    val competitionName: String? = null,
    val competitionIconUrl: String? = null,
    val games: List<GameStats>?
)

data class GameStats(
    val gameId: String?,
    val date: GameDate? = null,
    val minutes: Int?,
    val isStarting: Boolean?,
    val goals: Int?,
    val assists: Int?,
    val yellow: Int?,
    val secondYellow: Int? = null,
    val red: Int?,
    val tackles: Int? = null,
    val tacklesWon: Int? = null,
    val tacklesLost: Int? = null,
    val groundDuels: Int? = null,
    val groundDuelsWon: Int? = null,
    val groundDuelsLost: Int? = null,
    val aerialDuels: Int? = null,
    val aerialDuelsWon: Int? = null,
    val aerialDuelsLost: Int? = null,
    val passes: Int? = null,
    val passesReached: Int? = null,
    val passesFailed: Int? = null,
    val crosses: Int? = null,
    val crossesReached: Int? = null,
    val crossesFailed: Int? = null,
    val longBalls: Int? = null,
    val longBallsReached: Int? = null,
    val longBallsFailed: Int? = null,
    val shirtNumber: Int? = null,
    val isCaptain: Boolean? = false,
    val participationState: String?
)

data class GameDate(
    val dateTimeUTC: String?,
    val isTimeDefined: Boolean?
)
