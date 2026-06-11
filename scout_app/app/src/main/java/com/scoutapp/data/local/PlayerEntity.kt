package com.scoutapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached_players")
data class PlayerEntity(
    @PrimaryKey val id: Long,
    val tmId: String? = null,
    val name: String,
    val club: String,
    val age: Int? = null,
    val marketValue: Double? = null,
    val talentScore: Double,
    val hiddenGemScore: Double,
    val position: String,
    val isWatchlisted: Boolean = false
)
