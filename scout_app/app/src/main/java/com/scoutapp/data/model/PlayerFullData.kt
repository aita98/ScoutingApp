package com.scoutapp.data.model

import com.scoutapp.data.api.PlayerResponse
import com.scoutapp.data.api.RadarResponse
import com.scoutapp.domain.model.PlayerStats

data class PlayerFullData(
    val transfermarkt: com.scoutapp.data.api.PlayerResponse?,
    val fbref: PlayerStats?,
    val apiFootball: ApiFootballPlayerData?,
    val userRating: Float = 0f,
    val radar: com.scoutapp.data.api.RadarResponse? = null
)
