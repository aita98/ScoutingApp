package com.scoutapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MatchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMatch(match: MatchEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerformance(performance: MatchPerformanceEntity)

    @Transaction
    suspend fun insertMatchWithPerformance(match: MatchEntity, performance: MatchPerformanceEntity) {
        insertMatch(match)
        insertPerformance(performance)
    }

    @Query("SELECT * FROM matches WHERE id = :matchId")
    suspend fun getMatchById(matchId: Int): MatchEntity?

    @Query("""
        SELECT * FROM player_match_performance 
        WHERE playerId = :playerId 
        ORDER BY matchId DESC
    """)
    fun getPerformancesForPlayer(playerId: Long): Flow<List<MatchPerformanceEntity>>

    @Query("""
        SELECT SUM(goals) as totalGoals, SUM(assists) as totalAssists, SUM(minutesPlayed) as totalMinutes 
        FROM player_match_performance 
        WHERE playerId = :playerId
    """)
    suspend fun getPlayerTotals(playerId: Long): PlayerTotals?
}

data class PlayerTotals(
    val totalGoals: Int,
    val totalAssists: Int,
    val totalMinutes: Int
)
