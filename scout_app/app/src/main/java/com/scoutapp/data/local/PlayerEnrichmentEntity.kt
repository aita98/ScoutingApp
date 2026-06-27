package com.scoutapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_enrichment_cache")
data class PlayerEnrichmentEntity(
    @PrimaryKey
    val tmId: String,
    val backendId: Long,
    val jsonData: String, // Serialized PlayerFullData
    val rating: Float = 0f,
    val lastUpdated: Long = System.currentTimeMillis()
)
