package com.scoutapp.domain.model

data class PlayerStats(
    val season: String,
    val minutes: Int,
    val matches: Int = 0,
    val goals: Int,
    val assists: Int,
    val xG: Double,
    val xA: Double,
    val keyPasses: Int,
    val progressivePasses: Int,
    val progressiveCarries: Int,
    val pressures: Int,
    val goalsConceded: Int = 0,
    val cleanSheets: Int = 0,
    val marketValue: String? = null
)
