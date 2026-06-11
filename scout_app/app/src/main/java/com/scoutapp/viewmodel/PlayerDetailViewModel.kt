package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.RadarResponse
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.api.SeasonStats
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.local.PlayerEntity
import com.scoutapp.data.mock.MockData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PlayerDetailState {
    object Loading : PlayerDetailState()
    data class Success(
        val player: PlayerResponse, 
        val radar: RadarResponse,
        val isWatchlisted: Boolean = false
    ) : PlayerDetailState()
    data class Error(val message: String) : PlayerDetailState()
}

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val apiService: ScoutApiService,
    private val tmApiService: TransfermarktApiService,
    private val playerDao: PlayerDao
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlayerDetailState>(PlayerDetailState.Loading)
    val uiState: StateFlow<PlayerDetailState> = _uiState

    fun loadPlayer(idString: String) {
        viewModelScope.launch {
            _uiState.value = PlayerDetailState.Loading
            
            val id = idString.toLongOrNull()
            
            // Check if in watchlist/local cache first (by ID or TM ID)
            val localPlayer = if (id != null && id != 0L) {
                playerDao.getPlayerById(id)
            } else {
                // Try to find by TM ID if idString is alphanumeric or id is 0
                // Note: This requires a new DAO method if we want to be efficient,
                // but for now let's see if we can find it in the watchlist flow or similar.
                // Assuming for now it's better to just try API.
                null 
            }
            
            val isWatchlisted = localPlayer?.isWatchlisted ?: false
            
            try {
                // Prova prima il backend principale se l'ID è numerico e non 0
                if (id != null && id != 0L) {
                    try {
                        val player = apiService.getPlayerDetail(id)
                        val radar = apiService.getPlayerRadar(id)
                        _uiState.value = PlayerDetailState.Success(player, radar, isWatchlisted)
                    } catch (e: Exception) {
                        // Se il backend fallisce per un ID numerico, potrebbe essere un TM ID numerico
                        tryLoadFromTransfermarkt(idString, isWatchlisted)
                    }
                } else {
                    // Se l'ID è alfanumerico o 0, vai diretto su TM
                    tryLoadFromTransfermarkt(idString, isWatchlisted)
                }
            } catch (e: Exception) {
                // Final Fallback: Local Player data if available (prevents crash)
                if (localPlayer != null) {
                    val fallbackResponse = PlayerResponse(
                        id = localPlayer.id,
                        tmId = localPlayer.tmId,
                        name = localPlayer.name,
                        club = localPlayer.club,
                        age = localPlayer.age,
                        marketValue = localPlayer.marketValue,
                        talentScore = localPlayer.talentScore,
                        hiddenGemScore = localPlayer.hiddenGemScore,
                        position = localPlayer.position,
                        photoUrl = null,
                        statistics = emptyList()
                    )
                    _uiState.value = PlayerDetailState.Success(fallbackResponse, RadarResponse(75, 75, 75, 75, 75, 75), isWatchlisted)
                } else {
                    // Final Fallback: MockData
                    val mockPlayer = MockData.players.find { 
                        it.id.toString() == idString || it.tmId == idString 
                    }
                    if (mockPlayer != null) {
                        val radar = MockData.getRadar(mockPlayer.id)
                        _uiState.value = PlayerDetailState.Success(mockPlayer, radar, isWatchlisted)
                    } else {
                        _uiState.value = PlayerDetailState.Error("Player Not Found (ID: $idString). Error: ${e.message}")
                    }
                }
            }
        }
    }

    fun forceRefresh(id: Long, tmId: String?) {
        viewModelScope.launch {
            val currentState = _uiState.value
            val isWatchlisted = if (currentState is PlayerDetailState.Success) currentState.isWatchlisted else false
            
            _uiState.value = PlayerDetailState.Loading
            try {
                val updatedPlayer = apiService.syncPlayerWithTM(id, tmId)
                val radar = apiService.getPlayerRadar(id)
                _uiState.value = PlayerDetailState.Success(updatedPlayer, radar, isWatchlisted)
            } catch (e: Exception) {
                _uiState.value = PlayerDetailState.Error("Refresh failed: ${e.message}")
            }
        }
    }

    private suspend fun tryLoadFromTransfermarkt(id: String, isWatchlisted: Boolean = false) {
        try {
            // Attempt to get profile, fallback to header if 405 occurs
            val profile = try {
                tmApiService.getPlayerProfile(id)
            } catch (e: Exception) {
                if (e.message?.contains("405") == true || e.message?.contains("404") == true) {
                    tmApiService.getPlayerHeader(id)
                } else {
                    throw e
                }
            }

            val mappedStats = profile.stats?.map {
                SeasonStats(
                    appearances = it.appearances ?: 0,
                    goals = it.goals ?: 0,
                    assists = it.assists ?: 0,
                    yellowCards = it.yellowCards ?: 0,
                    redCards = it.redCards ?: 0,
                    minutesPlayed = it.minutesPlayed ?: 0
                )
            } ?: emptyList()

            val playerResponse = PlayerResponse(
                id = 0L,
                tmId = profile.id,
                name = profile.name ?: "Unknown Player",
                club = profile.club?.name ?: "No Club",
                age = profile.age,
                marketValue = parseMarketValue(profile.marketValue),
                talentScore = 85.0,
                hiddenGemScore = 0.0,
                position = profile.position ?: "N/A",
                photoUrl = profile.imageUrl,
                statistics = mappedStats
            )

            // Radar mock per TM
            val radar = RadarResponse(85, 80, 88, 92, 70, 85)
            _uiState.value = PlayerDetailState.Success(playerResponse, radar, isWatchlisted)
        } catch (e: Exception) {
            throw e
        }
    }

    fun toggleWatchlist(player: PlayerResponse, currentStatus: Boolean) {
        viewModelScope.launch {
            val newStatus = !currentStatus
            playerDao.insertPlayers(listOf(
                PlayerEntity(
                    id = player.id,
                    tmId = player.tmId,
                    name = player.name ?: "N/A",
                    club = player.club ?: "N/A",
                    age = player.age,
                    marketValue = player.marketValue,
                    position = player.position ?: "N/A",
                    talentScore = player.talentScore ?: 0.0,
                    hiddenGemScore = player.hiddenGemScore ?: 0.0,
                    isWatchlisted = newStatus
                )
            ))
            
            val currentState = _uiState.value
            if (currentState is PlayerDetailState.Success) {
                _uiState.value = currentState.copy(isWatchlisted = newStatus)
            }
        }
    }

    private fun parseMarketValue(valueStr: String?): Double {
        if (valueStr == null || valueStr.isEmpty() || valueStr == "N/A") return 0.0
        val cleanStr = valueStr.replace("€", "").trim().lowercase()
        return try {
            val multiplier = when {
                cleanStr.contains("m") -> 1_000_000.0
                cleanStr.contains("k") -> 1_000.0
                else -> 1.0
            }
            // Use regex to keep only digits and dots for decimal parsing
            val numericPart = cleanStr.replace(Regex("[^0-9.]"), "")
            
            if (numericPart.isEmpty()) 0.0 else numericPart.toDouble() * multiplier
        } catch (e: Exception) {
            0.0
        }
    }
}
