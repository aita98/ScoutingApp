package com.scoutapp.data.repository

import com.google.gson.Gson
import com.scoutapp.data.api.*
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.model.PlayerFullData
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EnrichmentRepository @Inject constructor(
    private val apiService: ScoutApiService,
    private val tmApiService: TransfermarktApiService,
    private val playerDao: PlayerDao,
    private val gson: Gson
) {
    suspend fun getFullPlayerData(id: Long, tmId: String): PlayerFullData = coroutineScope {
        android.util.Log.e("API_ENRICH", "Starting enrichment for TM ID: $tmId")

        // 1. PROXY TO BACKEND: Use our consolidated endpoint (MANDATORY for mapping consistency)
        val backendPlayer = try {
            apiService.syncPlayerWithTM(id, tmId)
        } catch (e: Exception) {
            android.util.Log.e("API_ENRICH", "Backend consolidated fetch failed: ${e.message}")
            null
        }

        if (backendPlayer != null) {
            android.util.Log.e("API_ENRICH", "SUCCESS: Using Backend Consolidated Data for $tmId")
            return@coroutineScope PlayerFullData(
                transfermarkt = backendPlayer,
                fbref = null, 
                apiFootball = null,
                userRating = 0f,
                radar = null
            )
        }

        // 2. MINIMAL FALLBACK (Only profile info)
        android.util.Log.e("API_ENRICH", "FALLBACK: Backend unreachable, using minimal TM data")
        val tmProfile = runCatching { tmApiService.getPlayerProfile(tmId) }.getOrNull()
        
        val tmPlayerResponse = tmProfile?.let {
            PlayerResponse(
                id = id,
                transfermarktId = it.id,
                tmId = it.id,
                fbrefSlug = null,
                name = it.name,
                club = it.club?.name,
                age = it.age,
                marketValue = null,
                marketValueDisplay = it.marketValue,
                talentScore = 0.0,
                hiddenGemScore = 0.0,
                position = it.position?.main,
                photoUrl = it.imageUrl,
                isRetired = it.isRetired ?: false,
                statistics = null,
                radar = null
            )
        }

        return@coroutineScope PlayerFullData(
            transfermarkt = tmPlayerResponse,
            fbref = null,
            apiFootball = null,
            userRating = 0f,
            radar = null
        )
    }

    suspend fun updatePlayerRating(tmId: String, rating: Float) {
        playerDao.updateRating(tmId, rating)
    }
}
