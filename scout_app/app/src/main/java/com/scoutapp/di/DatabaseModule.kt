package com.scoutapp.di

import android.content.Context
import androidx.room.Room
import com.scoutapp.data.local.PlayerDao
import com.scoutapp.data.local.ScoutDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ScoutDatabase {
        return Room.databaseBuilder(
            context,
            ScoutDatabase::class.java,
            "scout_db"
        )
        .fallbackToDestructiveMigration()
        .build()
    }

    @Provides
    fun providePlayerDao(database: ScoutDatabase): PlayerDao {
        return database.playerDao()
    }

    @Provides
    fun provideMatchDao(database: ScoutDatabase): com.scoutapp.data.local.MatchDao {
        return database.matchDao()
    }
}
