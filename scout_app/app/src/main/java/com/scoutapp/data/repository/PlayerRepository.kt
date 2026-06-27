package com.scoutapp.data.repository

import com.scoutapp.data.api.TransfermarktApiService
import com.scoutapp.data.api.ScoutApiService
import com.scoutapp.data.api.fbref.FbrefApi
import com.scoutapp.data.api.fbref.FbrefStatsDto
import com.scoutapp.data.local.MatchDao
import com.scoutapp.data.local.MatchPerformanceEntity
import com.scoutapp.domain.model.Player
import com.scoutapp.domain.model.PlayerMatchPerformance
import com.scoutapp.domain.model.PlayerStats
import com.scoutapp.domain.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlayerRepositoryImpl @Inject constructor(
    private val tmApi: TransfermarktApiService,
    private val fbrefApi: FbrefApi,
    private val apiService: ScoutApiService,
    private val matchDao: MatchDao
) : PlayerRepository {

    override suspend fun searchPlayers(query: String): List<Player> {
        return try { 
            tmApi.searchAll(query).players?.results?.map { it.toDomain() } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getPlayerStats(fbrefId: String, slug: String): PlayerStats {
        return try {
            val response = fbrefApi.getStats(fbrefId, slug)
            response.stats?.toFbrefDomain() ?: throw Exception("No stats found in response")
        } catch (e: Exception) {
            android.util.Log.e("PLAYER_REPO", "Error getting stats for $fbrefId: ${e.message}")
            throw e
        }
    }

    override suspend fun getHybridPlayerStats(tmId: String, fbrefId: String, slug: String): PlayerStats {
        return try {
            val response = apiService.getHybridStats(tmId, fbrefId, slug)
            response.stats?.toFbrefDomain() ?: throw Exception("No combined stats found")
        } catch (e: Exception) {
            android.util.Log.e("PLAYER_REPO", "Error getting hybrid stats for TM ID $tmId: ${e.message}")
            throw e
        }
    }

    override suspend fun resolvePlayer(name: String): Pair<String, String>? {
        return try {
            val response = fbrefApi.resolvePlayer(name)
            if (response.id != null && response.name != null) {
                Pair(response.id, response.name)
            } else {
                null
            }
        } catch (e: Exception) {
            android.util.Log.e("PLAYER_REPO", "Error resolving player $name: ${e.message}")
            null
        }
    }

    override suspend fun getDirectTransfermarktStats(tmId: String): PlayerStats? {
        // Logica rimossa: ora il backend gestisce la sincronizzazione e l'aggregazione.
        // L'app si affida ai dati consolidati restituiti dalle API del backend.
        return null
    }

    override suspend fun syncPlayerMatchLog(playerId: Long, tmId: String): Result<Unit> {
        // Logica rimossa: il Match Log viene ora elaborato e aggregato lato server.
        // Questo riduce il consumo di batteria e dati sul dispositivo utente.
        return Result.success(Unit)
    }

    override fun getPlayerMatchLog(playerId: Long): Flow<List<PlayerMatchPerformance>> {
        // Manteniamo la lettura dal DB locale per mostrare i dati precedentemente salvati (offline)
        return matchDao.getPerformancesForPlayer(playerId).map { entities ->
            entities.map { it.toDomain() }
        }
    }
}

fun com.scoutapp.data.model.TransfermarktSearchResult.toDomain(): Player {
    return Player(
        id = id.toIntOrNull() ?: 0,
        name = name,
        slug = id, // TM ID as slug for now
        nationality = "",
        position = position ?: "",
        team = clubName ?: "",
        age = age ?: 0
    )
}

fun FbrefStatsDto.toFbrefDomain(): PlayerStats {
    return PlayerStats(
        season = season.orEmpty(),
        minutes = minutes ?: 0,
        matches = matches ?: 0,
        goals = goals ?: 0,
        assists = assists ?: 0,
        xG = xG ?: 0.0,
        xA = xA ?: 0.0,
        keyPasses = keyPasses ?: 0,
        progressivePasses = progressivePasses ?: 0,
        progressiveCarries = progressiveCarries ?: 0,
        pressures = pressures ?: 0,
        goalsConceded = 0, // Should be filled by hybrid if needed
        cleanSheets = 0
    )
}

fun MatchPerformanceEntity.toDomain(): PlayerMatchPerformance {
    return PlayerMatchPerformance(
        playerId = playerId.toString(),
        matchId = matchId,
        participationState = participationState,
        minutesPlayed = minutesPlayed,
        goals = goals,
        assists = assists,
        yellowCard = yellowCard,
        shots = shots,
        passesCompleted = passesCompleted,
        passesTotal = passesTotal,
        isStarting = isStarting
    )
}
