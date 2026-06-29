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
    val gameId: String?, 
    @SerializedName("competitionId")
    val competitionId: String?,
    @SerializedName("seasonId")
    val seasonId: Int?,
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
    val playingTimeStatistics: PlayingTimeStatistics?,
    @SerializedName("duelStatistics")
    val duelStatistics: DuelStatistics?,
    @SerializedName("generalStatistics")
    val generalStatistics: GeneralStatistics?
)

data class DuelStatistics(
    val tackles: Int? = null,
    val tacklesWon: Int? = null,
    val tacklesLost: Int? = null,
    val groundDuels: Int? = null,
    val groundDuelsWon: Int? = null,
    val groundDuelsLost: Int? = null,
    val aerialDuels: Int? = null,
    val aerialDuelsWon: Int? = null,
    val aerialDuelsLost: Int? = null
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
    val yellowCardGross: Int?,
    @SerializedName("secondYellowCards")
    val secondYellowCards: Int? = null,
    @SerializedName("redCards")
    val redCards: Int? = null
)

data class DistributionStatistics(
    val passes: Int? = null,
    val passesReached: Int? = null,
    val passesFailed: Int? = null,
    val crosses: Int? = null,
    val crossesReached: Int? = null,
    val crossesFailed: Int? = null,
    val longBalls: Int? = null,
    val longBallsReached: Int? = null,
    val longBallsFailed: Int? = null
)

data class GeneralStatistics(
    val shirtNumber: Int? = null,
    val isCaptain: Boolean? = null,
    val participationState: String? = null
)
