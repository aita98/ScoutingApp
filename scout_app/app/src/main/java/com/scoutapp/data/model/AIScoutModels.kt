package com.scoutapp.data.model

data class AIScoutRequest(
    val description: String? = null,
    val playerId: Long? = null
)

data class AIScoutResponse(
    val scoutingReport: String,
    val similarPlayers: List<SimilarPlayer>,
    val similarityScore: Int,
    val recommendations: String
)

data class SimilarPlayer(
    val id: Long,
    val name: String,
    val club: String,
    val similarityScore: Int,
    val photoUrl: String? = null,
    val age: Int? = null,
    val isHiddenGem: Boolean? = false,
    val isConsigliato: Boolean? = false
)
