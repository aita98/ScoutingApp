package com.scoutapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * FROM cached_players WHERE isWatchlisted = 1")
    fun getWatchlist(): Flow<List<PlayerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayers(players: List<PlayerEntity>)

    @Query("SELECT * FROM cached_players WHERE id = :playerId")
    suspend fun getPlayerById(playerId: Long): PlayerEntity?

    @Query("SELECT * FROM cached_players WHERE tmId = :tmId")
    suspend fun getPlayerByTmId(tmId: String): PlayerEntity?

    @Query("SELECT * FROM cached_players WHERE name LIKE :name")
    suspend fun getPlayerByName(name: String): PlayerEntity?

    @Query("UPDATE cached_players SET isWatchlisted = :status WHERE id = :playerId")
    suspend fun updateWatchlistStatus(playerId: Long, status: Boolean)

    @Query("UPDATE cached_players SET isWatchlisted = :status WHERE tmId = :tmId")
    suspend fun updateWatchlistStatusByTmId(tmId: String, status: Boolean)

    @Query("UPDATE cached_players SET goals = :goals, assists = :assists, minutes = :minutes WHERE id = :playerId")
    suspend fun updateStatsCache(playerId: Long, goals: Int, assists: Int, minutes: Int)

    // Enrichment Cache
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEnrichment(enrichment: PlayerEnrichmentEntity)

    @Query("SELECT * FROM player_enrichment_cache WHERE tmId = :tmId")
    suspend fun getEnrichmentByTmId(tmId: String): PlayerEnrichmentEntity?

    @Query("SELECT * FROM player_enrichment_cache WHERE backendId = :id")
    suspend fun getEnrichmentByBackendId(id: Long): PlayerEnrichmentEntity?

    @Query("UPDATE player_enrichment_cache SET rating = :rating WHERE tmId = :tmId")
    suspend fun updateRating(tmId: String, rating: Float)
}

@Database(
    entities = [
        PlayerEntity::class,
        PlayerEnrichmentEntity::class,
        MatchEntity::class,
        MatchPerformanceEntity::class
    ],
    version = 15,
    exportSchema = false
)
abstract class ScoutDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao
}
