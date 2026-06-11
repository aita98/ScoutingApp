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

    @Query("UPDATE cached_players SET isWatchlisted = :status WHERE id = :playerId")
    suspend fun updateWatchlistStatus(playerId: Long, status: Boolean)
}

@Database(entities = [PlayerEntity::class], version = 2)
abstract class ScoutDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
}
