package com.scoutapp.data.api.fbref

import com.google.gson.annotations.SerializedName

data class FbrefStatsDto(
    @SerializedName("season") val season: String?,
    @SerializedName("minutes", alternate = ["minutes_played"]) val minutes: Int?,
    @SerializedName("matches", alternate = ["matches_played"]) val matches: Int?,
    @SerializedName("goals") val goals: Int?,
    @SerializedName("assists") val assists: Int?,
    @SerializedName("xG") val xG: Double?,
    @SerializedName("xA") val xA: Double?,
    @SerializedName("key_passes") val keyPasses: Int?,
    @SerializedName("progressive_passes") val progressivePasses: Int?,
    @SerializedName("progressive_carries") val progressiveCarries: Int?,
    @SerializedName("pressures") val pressures: Int?
)

data class FbrefStatsResponseDto(
    @SerializedName("stats") val stats: FbrefStatsDto?,
    @SerializedName("error") val error: String? = null
)

data class FbrefResolveResponseDto(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("error") val error: String? = null
)
