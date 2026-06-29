package com.scoutapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues")
data class LeagueEntity(
    @PrimaryKey val id: String,
    val name: String,
    val country: String?,
    val logoUrl: String?,
    val lastUpdated: Long = System.currentTimeMillis()
)
