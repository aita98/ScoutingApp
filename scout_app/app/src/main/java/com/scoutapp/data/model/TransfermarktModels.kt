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
    val competitions: TransfermarktSearchData<TransfermarktCompetition>? = null
)

data class TransfermarktSearchResult(
    val id: String,
    val name: String,
    @SerializedName("club")
    val club: Any?, // Can be a string or a club object in search results
    val position: String?,
    val age: Int?,
    val nationality: List<String>?,
    val imageUrl: String?,
    @SerializedName("marketValue")
    private val _marketValue: Any? = null
) {
    val clubName: String?
        get() = when (club) {
            is String -> club
            is Map<*, *> -> club["name"] as? String
            else -> null
        }

    val marketValue: String?
        get() = when (_marketValue) {
            is String -> _marketValue
            is Map<*, *> -> _marketValue["display"] as? String ?: _marketValue["value"]?.toString()
            is Number -> _marketValue.toString()
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
    val fullName: String?,
    val dateOfBirth: String?,
    @SerializedName("placeOfBirth")
    private val _placeOfBirth: Any?, 
    val age: Int?,
    val height: String?,
    val citizenship: List<String>?,
    val position: String?,
    val foot: String?,
    @SerializedName("club")
    val club: TransfermarktClub?,
    @SerializedName("marketValue")
    private val _marketValue: Any?,
    val joined: String?,
    val contractExpires: String?,
    val socialMedia: List<String>?,
    val imageUrl: String?,
    @SerializedName("stats")
    val stats: List<TransfermarktStat>? = null
) {
    val placeOfBirth: String?
        get() = when (_placeOfBirth) {
            is String -> _placeOfBirth
            is Map<*, *> -> _placeOfBirth["city"] as? String
            else -> null
        }

    val marketValue: String?
        get() = when (_marketValue) {
            is String -> _marketValue
            is Map<*, *> -> _marketValue["display"] as? String ?: _marketValue["value"]?.toString()
            is Number -> _marketValue.toString()
            else -> null
        }
}

data class TransfermarktStat(
    @SerializedName("competition")
    private val _competition: Any?,
    val appearances: Int?,
    val goals: Int?,
    val assists: Int?,
    val yellowCards: Int?,
    val redCards: Int?,
    val minutesPlayed: Int?
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
            is Number -> _marketValue.toString()
            else -> null
        }
}
