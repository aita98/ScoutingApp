package com.scoutapp.domain.model

import java.util.Date

data class Match(
    val id: Int,
    val competitionCode: String,
    val season: String,
    val matchDate: Date,
    val homeClubId: Int,
    val awayClubId: Int,
    val homeScore: Int,
    val awayScore: Int
)

data class PlayerMatchPerformance(
    val playerId: String,
    val matchId: Int,
    val participationState: String,
    val minutesPlayed: Int,
    val goals: Int,
    val assists: Int,
    val yellowCard: Boolean,
    val shots: Int,
    val passesCompleted: Int,
    val passesTotal: Int,
    val isStarting: Boolean = false
)
