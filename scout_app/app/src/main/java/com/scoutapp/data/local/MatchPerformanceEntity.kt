package com.scoutapp.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "player_match_performance",
    primaryKeys = ["playerId", "matchId"],
    foreignKeys = [
        ForeignKey(
            entity = MatchEntity::class,
            parentColumns = ["id"],
            childColumns = ["matchId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["matchId"])]
)
data class MatchPerformanceEntity(
    val playerId: Long, 
    val matchId: Int,
    val participationState: String,
    val minutesPlayed: Int,
    val goals: Int,
    val assists: Int,
    val yellowCard: Boolean,
    val shots: Int,
    val passesCompleted: Int,
    val passesTotal: Int,
    val isStarting: Boolean = false // Added starting info
)
