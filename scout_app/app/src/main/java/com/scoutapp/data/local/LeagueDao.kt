package com.scoutapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LeagueDao {
    @Query("SELECT * FROM leagues ORDER BY name ASC")
    fun getAllLeagues(): Flow<List<LeagueEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeagues(leagues: List<LeagueEntity>)

    @Query("SELECT * FROM leagues WHERE id = :id")
    suspend fun getLeagueById(id: String): LeagueEntity?

    @Query("DELETE FROM leagues")
    suspend fun deleteAllLeagues()
}
