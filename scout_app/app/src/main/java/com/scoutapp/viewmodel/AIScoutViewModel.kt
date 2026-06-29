package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.GroqService
import com.scoutapp.data.model.AIScoutResponse
import com.scoutapp.data.model.AIScoutRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class AIScoutUiState {
    object Idle : AIScoutUiState()
    object Loading : AIScoutUiState()
    data class Success(val data: AIScoutResponse) : AIScoutUiState()
    data class Error(val message: String) : AIScoutUiState()
}

@HiltViewModel
class AIScoutViewModel @Inject constructor(
    private val apiService: ScoutApiService,
    private val groqService: GroqService
) : ViewModel() {
    private val _uiState = MutableStateFlow<AIScoutUiState>(AIScoutUiState.Idle)
    val uiState: StateFlow<AIScoutUiState> = _uiState

    private val _isBackendConnected = MutableStateFlow(false)
    val isBackendConnected: StateFlow<Boolean> = _isBackendConnected

    init {
        checkBackendStatus()
    }

    fun checkBackendStatus() {
        viewModelScope.launch {
            try {
                val response = apiService.getBackendStatus()
                _isBackendConnected.value = response.isSuccessful
            } catch (e: Exception) {
                _isBackendConnected.value = false
            }
        }
    }

    fun performAIScout(description: String) {
        viewModelScope.launch {
            _uiState.value = AIScoutUiState.Loading
            // Re-check status before searching
            checkBackendStatus()
            
            try {
                // 1. Get detailed AI analysis from Groq
                val groqResponse = try {
                    groqService.generateScoutingReport(description)
                } catch (e: Exception) {
                    throw Exception("AI Analysis Service (Groq) unreachable: ${e.message}")
                }
                
                // 2. Try to get similar players from backend (optional enhancement)
                val finalResponse = try {
                    val backendResponse = apiService.performAIScout(AIScoutRequest(description))
                    _isBackendConnected.value = true
                    groqResponse.copy(similarPlayers = backendResponse.similarPlayers)
                } catch (e: Exception) {
                    android.util.Log.w("AIScoutVM", "Backend AI search failed: ${e.message}")
                    // If backend fails, we still have Groq data
                    _isBackendConnected.value = false
                    groqResponse
                }

                _uiState.value = AIScoutUiState.Success(finalResponse)
            } catch (e: Exception) {
                val errorMsg = when {
                    e.message?.contains("Status not found", ignoreCase = true) == true -> 
                        "AI Service reported: Status not found. Please try again or check API configuration."
                    else -> e.message ?: "AI Service Unavailable"
                }
                _uiState.value = AIScoutUiState.Error(errorMsg)
            }
        }
    }
}
