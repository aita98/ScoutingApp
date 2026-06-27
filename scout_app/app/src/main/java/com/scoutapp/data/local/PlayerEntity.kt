package com.scoutapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_players")
data class PlayerEntity(
    @PrimaryKey val id: Long,
    val tmId: String? = null,
    val fbrefSlug: String? = null,
    val fbrefId: String? = null,
    val name: String,
    val club: String?,
    val age: Int? = null,
    val marketValue: Double? = null,
    val talentScore: Double,
    val hiddenGemScore: Double,
    val position: String?,
    val photoUrl: String? = null,
    val isRetired: Boolean = false,
    val isWatchlisted: Boolean = false,
    
    val season: String? = null,
    val goals: Int? = null,
    val assists: Int? = null,
    val xG: Double? = null,
    val minutes: Int? = null,
    val goalsConceded: Int? = null,
    val cleanSheets: Int? = null,

    // Technical & Profile Details
    val foot: String? = null,
    val shirtNumber: String? = null,
    val citizenship: String? = null, // JSON list
    val contractExpires: String? = null,
    val birthDate: String? = null,
    
    // Complex Data (JSON strings)
    val seasonalStats: String? = null,
    val detailedStats: String? = null,
    val achievements: String? = null,
    val marketValueHistory: String? = null,
    val transfers: String? = null,
    val injuries: String? = null,
    val radarData: String? = null,
    val recentPerformanceJson: String? = null,
    
    // FBRef data
    val fbrefStatsJson: String? = null,

    val lastUpdated: Long = System.currentTimeMillis()
)
