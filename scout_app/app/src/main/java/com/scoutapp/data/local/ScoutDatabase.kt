package com.scoutapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * FROM cached_players WHERE isWatchlisted = 1")
    fun getWatchlist(): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlayersRaw(players: List<PlayerEntity>): List<Long>

    @Update
    suspend fun updatePlayer(player: PlayerEntity)

    @Transaction
    suspend fun upsertPlayersPreservingLocalFields(players: List<PlayerEntity>) {
        val insertResults = insertPlayersRaw(players)
        for (i in insertResults.indices) {
            if (insertResults[i] == -1L) {
                // Already exists, update everything except local-only flags
                val newPlayer = players[i]
                val existingPlayer = getPlayerByTmId(newPlayer.tmId ?: "") 
                    ?: (if (newPlayer.id != 0L) getPlayerById(newPlayer.id) else null)
                
                if (existingPlayer != null) {
                    val merged = newPlayer.copy(
                        isWatchlisted = existingPlayer.isWatchlisted,
                        lastUpdated = System.currentTimeMillis()
                    )
                    updatePlayer(merged)
                }
            }
        }
    }

    @Query("SELECT * FROM cached_players WHERE id = :playerId")
    suspend fun getPlayerById(playerId: Long): PlayerEntity?

    @Query("SELECT * FROM cached_players WHERE tmId = :tmId")
    suspend fun getPlayerByTmId(tmId: String): PlayerEntity?

    @Query("SELECT * FROM cached_players")
    fun getAllPlayers(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM cached_players WHERE name LIKE :name")
    suspend fun getPlayerByName(name: String): PlayerEntity?

    @Query("UPDATE cached_players SET isWatchlisted = :status WHERE id = :playerId")
    suspend fun updateWatchlistStatus(playerId: Long, status: Boolean)

    @Query("UPDATE cached_players SET isWatchlisted = :status WHERE tmId = :tmId")
    suspend fun updateWatchlistStatusByTmId(tmId: String, status: Boolean)

    @Query("UPDATE cached_players SET goals = :goals, assists = :assists, minutes = :minutes, matchesPlayed = :matchesPlayed WHERE id = :playerId")
    suspend fun updateStatsCache(playerId: Long, goals: Int, assists: Int, minutes: Int, matchesPlayed: Int)

    // Enrichment Cache
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEnrichment(enrichment: PlayerEnrichmentEntity)

    @Query("SELECT * FROM player_enrichment_cache WHERE tmId = :tmId")
    suspend fun getEnrichmentByTmId(tmId: String): PlayerEnrichmentEntity?

    @Query("SELECT * FROM player_enrichment_cache WHERE backendId = :id")
    suspend fun getEnrichmentByBackendId(id: Long): PlayerEnrichmentEntity?

    @Query("UPDATE player_enrichment_cache SET rating = :rating WHERE tmId = :tmId")
    suspend fun updateRating(tmId: String, rating: Float)

    @Query("SELECT DISTINCT league FROM cached_players WHERE league IS NOT NULL")
    fun getAvailableLeagues(): Flow<List<String>>

    @Query("SELECT DISTINCT club FROM cached_players WHERE league = :leagueName")
    fun getTeamsInLeague(leagueName: String): Flow<List<String>>

    @Query("SELECT * FROM cached_players WHERE club = :clubName")
    fun getPlayersInClub(clubName: String): Flow<List<PlayerEntity>>
}

@Database(
    entities = [
        PlayerEntity::class,
        PlayerEnrichmentEntity::class,
        MatchEntity::class,
        MatchPerformanceEntity::class,
        LeagueEntity::class,
        TeamEntity::class
    ],
    version = 21,
    exportSchema = false
)
abstract class ScoutDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao
    abstract fun leagueDao(): LeagueDao
    abstract fun teamDao(): TeamDao
}
