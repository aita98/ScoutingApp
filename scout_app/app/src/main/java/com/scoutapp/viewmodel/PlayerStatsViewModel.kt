package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.domain.model.PlayerMatchPerformance
import com.scoutapp.domain.model.PlayerStats
import com.scoutapp.domain.repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class PlayerStatsState {
    object Idle : PlayerStatsState()
    object Loading : PlayerStatsState()
    data class Success(
        val stats: PlayerStats,
        val matchLog: List<PlayerMatchPerformance> = emptyList()
    ) : PlayerStatsState()
    data class Error(val message: String) : PlayerStatsState()
}

@HiltViewModel
class PlayerStatsViewModel @Inject constructor(
    private val repository: PlayerRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlayerStatsState>(PlayerStatsState.Idle)
    val uiState: StateFlow<PlayerStatsState> = _uiState

    fun loadPlayerStats(playerSlug: String, tmId: String? = null, internalId: Long? = null) {
        viewModelScope.launch {
            _uiState.value = PlayerStatsState.Loading
            try {
                // 1. Resolve Name/Slug to FBref ID
                val resolved = repository.resolvePlayer(playerSlug)
                
                if (resolved != null) {
                    val (fbrefId, officialSlug) = resolved
                    // 2. Fetch Stats using ID and Slug
                    val stats = repository.getPlayerStats(fbrefId, officialSlug)
                    
                    // 3. Recuperiamo il Match Log dal DB locale se presente
                    val matchLog = if (internalId != null) {
                        repository.getPlayerMatchLog(internalId).first()
                    } else emptyList()

                    _uiState.value = PlayerStatsState.Success(stats, matchLog)
                } else {
                    // Fallback: se FBref fallisce, il backend dovrebbe aver già popolato i dati TM 
                    // nella risposta di dettaglio. Qui mostriamo errore se FBref è critico.
                    _uiState.value = PlayerStatsState.Error("Player not found on FBref")
                }
            } catch (e: Exception) {
                _uiState.value = PlayerStatsState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}
