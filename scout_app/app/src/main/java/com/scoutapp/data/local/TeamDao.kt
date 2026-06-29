package com.scoutapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM teams WHERE leagueId = :leagueId ORDER BY name ASC")
    fun getTeamsByLeague(leagueId: String): Flow<List<TeamEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeams(teams: List<TeamEntity>)

    @Query("SELECT * FROM teams WHERE id = :id")
    suspend fun getTeamById(id: String): TeamEntity?

    @Query("DELETE FROM teams WHERE leagueId = :leagueId")
    suspend fun deleteTeamsByLeague(leagueId: String)
}
