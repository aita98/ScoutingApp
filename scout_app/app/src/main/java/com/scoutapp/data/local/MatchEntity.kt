package com.scoutapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity(
    @PrimaryKey val id: Int,
    val competitionCode: String,
    val season: String,
    val matchDate: Long, 
    val homeClubId: Int,
    val awayClubId: Int,
    val homeScore: Int,
    val awayScore: Int,
    val venue: String? = null // Added venue info
)
