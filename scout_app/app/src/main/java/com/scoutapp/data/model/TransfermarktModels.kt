package com.scoutapp.data.model

import com.google.gson.annotations.SerializedName

data class TransfermarktSearchData<T>(
    @SerializedName("results")
    val results: List<T> = emptyList()
)

data class TransfermarktSearchResponse(
    @SerializedName("players")
    val players: TransfermarktSearchData<TransfermarktSearchResult>? = null,
    @SerializedName("clubs")
    val clubs: TransfermarktSearchData<TransfermarktClub>? = null,
    @SerializedName("competitions")
    val competitions: TransfermarktSearchData<TransfermarktCompetition>? = null,
    @SerializedName("results")
    val results: List<TransfermarktSearchResult>? = null
)

data class TransfermarktSearchResult(
    val id: String,
    val name: String,
    @SerializedName("club")
    val club: Any?, 
    val position: String?,
    val age: Int?,
    val nationality: List<String>?,
    val imageUrl: String?,
    @SerializedName("marketValue")
    val marketValueRaw: Any? = null
) {
    val clubName: String?
        get() = when (club) {
            is String -> club
            is Map<*, *> -> club["name"] as? String
            else -> null
        }

    val marketValue: String?
        get() = when (marketValueRaw) {
            is String -> marketValueRaw
            is Map<*, *> -> marketValueRaw["display"] as? String ?: marketValueRaw["value"]?.toString()
            is Number -> {
                val value = marketValueRaw.toDouble()
                if (value >= 1_000_000) String.format(java.util.Locale.US, "%.1fM€", value / 1_000_000.0)
                else if (value >= 1_000) String.format(java.util.Locale.US, "%.0fK€", value / 1_000.0)
                else String.format(java.util.Locale.US, "%.0f€", value)
            }
            else -> null
        }
}

data class TransfermarktCompetition(
    val id: String,
    val name: String,
    @SerializedName("country")
    val country: String?,
    val imageUrl: String?
)

data class TransfermarktCompetitionClubs(
    @SerializedName("clubs")
    val clubs: List<TransfermarktClub>
)

data class TransfermarktPlayerProfile(
    val id: String,
    val name: String,
    val nameInHomeCountry: String?,
    val description: String?,
    val imageUrl: String?,
    @SerializedName("placeOfBirth")
    val placeOfBirth: TransfermarktPlaceOfBirth?,
    val height: Int?,
    val citizenship: List<String>?,
    val isRetired: Boolean? = false,
    @SerializedName("position")
    val position: TransfermarktPosition?,
    val foot: String?,
    val shirtNumber: String?,
    @SerializedName("club")
    val club: TransfermarktClubDetails?,
    @SerializedName("marketValue")
    val _marketValue: Any? = null,
    val socialMedia: List<String>?,
    @SerializedName("stats")
    val stats: List<TransfermarktStat>? = null
) {
    val marketValue: String?
        get() = when (_marketValue) {
            is String -> _marketValue
            is Map<*, *> -> _marketValue["display"] as? String ?: _marketValue["value"]?.toString()
            is Number -> {
                val value = _marketValue.toDouble()
                if (value >= 1_000_000) String.format("%.2fm€", value / 1_000_000.0)
                else String.format("%.0fk€", value / 1_000.0)
            }
            else -> null
        }

    val age: Int?
        get() {
            val desc = description ?: return null
            val regex = Regex(", (\\d{1,2}), from")
            val match = regex.find(desc)
            return match?.groupValues?.get(1)?.toIntOrNull()
        }
}

data class TransfermarktClubDetails(
    val id: String?,
    val name: String?,
    val joined: String?,
    val contractExpires: String?
)

data class TransfermarktPlaceOfBirth(
    val city: String?,
    val country: String?
)

data class TransfermarktPosition(
    val main: String?,
    val other: List<String>?
)

data class TransfermarktMarketValue(
    val current: String?,
    val max: String?
)

data class TransfermarktStat(
    @SerializedName("competition")
    private val _competition: Any?,
    val appearances: Any?,
    val goals: Any?,
    val assists: Any?,
    val yellowCards: Any?,
    val redCards: Any?,
    @SerializedName("minutesPlayed", alternate = ["minutes", "minutes_played"])
    val minutesPlayed: Any?
) {
    val competition: String?
        get() = when (_competition) {
            is String -> _competition
            is Map<*, *> -> _competition["name"] as? String
            else -> null
        }
}

data class TransfermarktClub(
    val id: String,
    val name: String,
    val imageUrl: String?
)

data class TransfermarktClubPlayers(
    val id: String?,
    val name: String?,
    @SerializedName("players")
    val players: List<TransfermarktPlayer>
)

data class TransfermarktPlayer(
    val id: String,
    val name: String,
    val position: String?,
    val age: Int?,
    @SerializedName("marketValue")
    private val _marketValue: Any?,
    val nationality: List<String>?,
    val imageUrl: String?
) {
    val marketValue: String?
        get() = when (_marketValue) {
            is String -> _marketValue
            is Map<*, *> -> _marketValue["display"] as? String ?: _marketValue["value"]?.toString()
            is Number -> {
                val value = _marketValue.toDouble()
                if (value >= 1_000_000) String.format(java.util.Locale.US, "%.1fM€", value / 1_000_000.0)
                else if (value >= 1_000) String.format(java.util.Locale.US, "%.0fK€", value / 1_000.0)
                else String.format(java.util.Locale.US, "%.0f€", value)
            }
            else -> null
        }
}

// New models for comprehensive player data
data class TransfermarktTransfersResponse(
    @SerializedName("transfers")
    val transfers: List<TransfermarktTransfer>? = null
)

data class TransfermarktTransfer(
    @SerializedName("date")
    val date: String?,
    @SerializedName("season")
    val season: String?,
    @SerializedName("clubFrom")
    val from: TransfermarktClubShort?,
    @SerializedName("clubTo")
    val to: TransfermarktClubShort?,
    @SerializedName("fee")
    val fee: Any?,
    @SerializedName("marketValue")
    val marketValue: Any?
)

data class TransfermarktClubShort(
    val id: String?,
    val name: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?
)

data class TransfermarktDetailedStatsResponse(
    @SerializedName("stats")
    val stats: List<TransfermarktDetailedStat>? = null
)

data class TransfermarktDetailedStat(
    @SerializedName("seasonId")
    val seasonId: Any?,
    @SerializedName("competitionId")
    val competitionId: Any?,
    @SerializedName("competitionName")
    val competitionName: Any?,
    @SerializedName("clubId")
    val clubId: Any?,
    @SerializedName("appearances")
    val appearances: Any?,
    @SerializedName("goals")
    val goals: Any?,
    @SerializedName("assists")
    val assists: Any?,
    @SerializedName("yellowCards")
    val yellowCards: Any?,
    @SerializedName("redCards")
    val redCards: Any?,
    @SerializedName("minutesPlayed")
    val minutesPlayed: Any?
)

data class TransfermarktInjuriesResponse(
    @SerializedName("injuries")
    val injuries: List<TransfermarktInjury>? = null
)

data class TransfermarktInjury(
    @SerializedName("season")
    val season: String?,
    @SerializedName("injury")
    val injury: String?,
    @SerializedName("from")
    val from: String?,
    @SerializedName("until")
    val until: String?,
    @SerializedName("days")
    val days: String?,
    @SerializedName("gamesMissed")
    val gamesMissed: String?
)

data class TransfermarktAchievementsResponse(
    @SerializedName("achievements")
    val achievements: List<TransfermarktAchievement>? = null
)

data class TransfermarktAchievement(
    @SerializedName("title")
    val title: String?,
    @SerializedName("count")
    val count: Int?,
    @SerializedName("details")
    val details: List<TransfermarktAchievementDetail>?
)

data class TransfermarktAchievementDetail(
    @SerializedName("season")
    val season: Any?,
    @SerializedName("club")
    val club: Any?,
    @SerializedName("competition")
    val competition: Any?
)

data class TransfermarktJerseyNumbersResponse(
    @SerializedName("jerseyNumbers")
    val jerseyNumbers: List<TransfermarktJerseyNumber>? = null
)

data class TransfermarktJerseyNumber(
    @SerializedName("number")
    val number: String?,
    @SerializedName("season")
    val season: String?,
    @SerializedName("clubName")
    val clubName: String?
)

data class TransfermarktMarketValueHistoryResponse(
    @SerializedName("marketValueHistory")
    val history: List<TransfermarktMarketValuePoint>? = null
)

data class TransfermarktMarketValuePoint(
    @SerializedName("date")
    val date: String?,
    @SerializedName("marketValue")
    val marketValue: String?,
    @SerializedName("clubName")
    val clubName: String?
)
