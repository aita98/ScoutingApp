package com.scoutapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scoutapp.data.api.ScoutApiService
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
    private val apiService: ScoutApiService
) : ViewModel() {
    private val _uiState = MutableStateFlow<AIScoutUiState>(AIScoutUiState.Idle)
    val uiState: StateFlow<AIScoutUiState> = _uiState

    fun performAIScout(description: String) {
        viewModelScope.launch {
            _uiState.value = AIScoutUiState.Loading
            try {
                val response = apiService.performAIScout(AIScoutRequest(description))
                _uiState.value = AIScoutUiState.Success(response)
            } catch (e: Exception) {
                _uiState.value = AIScoutUiState.Error(e.message ?: "AI Service Unavailable")
            }
        }
    }
}
