package com.scoutapp.data.model

import com.google.gson.annotations.SerializedName

data class TransfermarktMatchLogResponse(
    @SerializedName("success")
    val success: Boolean? = null,
    @SerializedName("data")
    val data: TransfermarktMatchLogData? = null,
    // Fallback if the structure is different
    @SerializedName("performance")
    val performance: List<TransfermarktMatchPerformance>? = null
)

data class TransfermarktMatchLogData(
    @SerializedName("playerId")
    val playerId: String?,
    @SerializedName("performance")
    val performance: List<TransfermarktMatchPerformance>?
)

data class TransfermarktMatchPerformance(
    @SerializedName("participationState")
    val participationState: String?,
    @SerializedName("gameInformation")
    val gameInformation: GameInformation?,
    @SerializedName("clubsInformation")
    val clubsInformation: ClubsInformation?,
    @SerializedName("statistics")
    val statistics: MatchStatistics?,
    // Nested playing time might appear in statistics or root
    @SerializedName("playingTimeStatistics")
    val playingTimeStatistics: PlayingTimeStatistics?
)

data class GameInformation(
    @SerializedName("gameId")
    val gameId: String?, // Using String to be safe with IDs
    @SerializedName("competitionId")
    val competitionId: String?,
    @SerializedName("season")
    val season: SeasonInfo?,
    @SerializedName("date")
    val date: DateInfo?
)

data class SeasonInfo(
    @SerializedName("nonCyclicalName")
    val nonCyclicalName: String?
)

data class DateInfo(
    @SerializedName("dateTimeUTC")
    val dateTimeUTC: String?
)

data class ClubsInformation(
    @SerializedName("clubId")
    val clubId: Int?,
    @SerializedName("venue")
    val venue: String?,
    @SerializedName("goalsTotal")
    val goalsTotal: Int?,
    @SerializedName("opponentGoalsTotal")
    val opponentGoalsTotal: Int?
)

data class MatchStatistics(
    @SerializedName("goalStatistics")
    val goalStatistics: GoalStatistics?,
    @SerializedName("cardStatistics")
    val cardStatistics: CardStatistics?,
    @SerializedName("distributionStatistics")
    val distributionStatistics: DistributionStatistics?,
    @SerializedName("playingTimeStatistics")
    val playingTimeStatistics: PlayingTimeStatistics?
)

data class PlayingTimeStatistics(
    @SerializedName("playedMinutes")
    val playedMinutes: Int?,
    @SerializedName("isStarting")
    val isStarting: Boolean?
)

data class GoalStatistics(
    @SerializedName("goalsScoredTotalOfficial")
    val goalsScoredTotalOfficial: Int?,
    @SerializedName("assistsOfficial")
    val assistsOfficial: Int?,
    @SerializedName("scoringAttempts")
    val scoringAttempts: Int?
)

data class CardStatistics(
    @SerializedName("yellowCardGross")
    val yellowCardGross: Int?
)

data class DistributionStatistics(
    @SerializedName("passesReached")
    val passesReached: Int?,
    @SerializedName("passes")
    val passes: Int?
)
