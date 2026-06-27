package com.scoutapp.data.model

import com.google.gson.annotations.SerializedName

data class ApiFootballResponse<T>(
    val response: List<T>
)

data class ApiFootballPlayerData(
    val player: ApiFootballPlayerSummary?,
    val statistics: List<ApiFootballStat>?
)

data class ApiFootballPlayerSummary(
    val id: Long,
    val name: String,
    val age: Int?,
    val nationality: String?,
    val photo: String?
)

data class ApiFootballStat(
    val team: ApiFootballTeam?,
    val league: ApiFootballLeague?,
    val games: ApiFootballGameStats?,
    val goals: ApiFootballGoalStats?,
    val passes: ApiFootballPassStats?,
    val cards: ApiFootballCardStats?
)

data class ApiFootballTeam(val id: Long?, val name: String?, val logo: String?)
data class ApiFootballLeague(val id: Long?, val name: String?, val country: String?, val season: Int?)
data class ApiFootballGameStats(val appearances: Int?, val lineups: Int?, val minutes: Int?, val rating: String?)
data class ApiFootballGoalStats(val total: Int?, val assists: Int?)
data class ApiFootballPassStats(val total: Int?, val key: Int?, val accuracy: Int?)
data class ApiFootballCardStats(val yellow: Int?, val yellowred: Int?, val red: Int?)
