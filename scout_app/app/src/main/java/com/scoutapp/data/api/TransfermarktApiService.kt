package com.scoutapp.data.api

import com.scoutapp.data.model.TransfermarktClubPlayers
import com.scoutapp.data.model.TransfermarktPlayerProfile
import com.scoutapp.data.model.TransfermarktSearchResponse
import com.scoutapp.data.model.TransfermarktCompetition
import com.scoutapp.data.model.TransfermarktCompetitionClubs
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TransfermarktApiService {
    @GET("players/search/{query}/")
    suspend fun searchAll(
        @Path("query") query: String
    ): TransfermarktSearchResponse

    @GET("players/{id}/profile")
    suspend fun getPlayerProfile(@Path("id") id: String): TransfermarktPlayerProfile

    @GET("players/{id}/profile")
    suspend fun getPlayerHeader(@Path("id") id: String): TransfermarktPlayerProfile

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
}
