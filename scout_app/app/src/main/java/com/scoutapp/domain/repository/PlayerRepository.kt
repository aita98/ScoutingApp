package com.scoutapp.domain.repository

import com.scoutapp.domain.model.Player
import com.scoutapp.domain.model.PlayerStats

interface PlayerRepository {
    suspend fun searchPlayers(query: String): List<Player>
    suspend fun getPlayerStats(fbrefId: String, slug: String): PlayerStats
    suspend fun getHybridPlayerStats(tmId: String, fbrefId: String, slug: String): PlayerStats
    suspend fun resolvePlayer(name: String): Pair<String, String>?
    suspend fun getDirectTransfermarktStats(tmId: String): PlayerStats?
    suspend fun syncPlayerMatchLog(playerId: Long, tmId: String): Result<Unit>
    fun getPlayerMatchLog(playerId: Long): kotlinx.coroutines.flow.Flow<List<com.scoutapp.domain.model.PlayerMatchPerformance>>
}
