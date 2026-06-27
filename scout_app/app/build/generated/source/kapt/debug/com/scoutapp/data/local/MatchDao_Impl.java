package com.scoutapp.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MatchDao_Impl implements MatchDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<MatchEntity> __insertionAdapterOfMatchEntity;

  private final EntityInsertionAdapter<MatchPerformanceEntity> __insertionAdapterOfMatchPerformanceEntity;

  public MatchDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMatchEntity = new EntityInsertionAdapter<MatchEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `matches` (`id`,`competitionCode`,`season`,`matchDate`,`homeClubId`,`awayClubId`,`homeScore`,`awayScore`,`venue`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MatchEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getCompetitionCode() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCompetitionCode());
        }
        if (entity.getSeason() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getSeason());
        }
        statement.bindLong(4, entity.getMatchDate());
        statement.bindLong(5, entity.getHomeClubId());
        statement.bindLong(6, entity.getAwayClubId());
        statement.bindLong(7, entity.getHomeScore());
        statement.bindLong(8, entity.getAwayScore());
        if (entity.getVenue() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getVenue());
        }
      }
    };
    this.__insertionAdapterOfMatchPerformanceEntity = new EntityInsertionAdapter<MatchPerformanceEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `player_match_performance` (`playerId`,`matchId`,`participationState`,`minutesPlayed`,`goals`,`assists`,`yellowCard`,`shots`,`passesCompleted`,`passesTotal`,`isStarting`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final MatchPerformanceEntity entity) {
        statement.bindLong(1, entity.getPlayerId());
        statement.bindLong(2, entity.getMatchId());
        if (entity.getParticipationState() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getParticipationState());
        }
        statement.bindLong(4, entity.getMinutesPlayed());
        statement.bindLong(5, entity.getGoals());
        statement.bindLong(6, entity.getAssists());
        final int _tmp = entity.getYellowCard() ? 1 : 0;
        statement.bindLong(7, _tmp);
        statement.bindLong(8, entity.getShots());
        statement.bindLong(9, entity.getPassesCompleted());
        statement.bindLong(10, entity.getPassesTotal());
        final int _tmp_1 = entity.isStarting() ? 1 : 0;
        statement.bindLong(11, _tmp_1);
      }
    };
  }

  @Override
  public Object insertMatch(final MatchEntity match, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMatchEntity.insert(match);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertPerformance(final MatchPerformanceEntity performance,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfMatchPerformanceEntity.insert(performance);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertMatchWithPerformance(final MatchEntity match,
      final MatchPerformanceEntity performance, final Continuation<? super Unit> arg2) {
    return RoomDatabaseKt.withTransaction(__db, (__cont) -> MatchDao.DefaultImpls.insertMatchWithPerformance(MatchDao_Impl.this, match, performance, __cont), arg2);
  }

  @Override
  public Object getMatchById(final int matchId, final Continuation<? super MatchEntity> arg1) {
    final String _sql = "SELECT * FROM matches WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, matchId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<MatchEntity>() {
      @Override
      @Nullable
      public MatchEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfCompetitionCode = CursorUtil.getColumnIndexOrThrow(_cursor, "competitionCode");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfMatchDate = CursorUtil.getColumnIndexOrThrow(_cursor, "matchDate");
          final int _cursorIndexOfHomeClubId = CursorUtil.getColumnIndexOrThrow(_cursor, "homeClubId");
          final int _cursorIndexOfAwayClubId = CursorUtil.getColumnIndexOrThrow(_cursor, "awayClubId");
          final int _cursorIndexOfHomeScore = CursorUtil.getColumnIndexOrThrow(_cursor, "homeScore");
          final int _cursorIndexOfAwayScore = CursorUtil.getColumnIndexOrThrow(_cursor, "awayScore");
          final int _cursorIndexOfVenue = CursorUtil.getColumnIndexOrThrow(_cursor, "venue");
          final MatchEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpCompetitionCode;
            if (_cursor.isNull(_cursorIndexOfCompetitionCode)) {
              _tmpCompetitionCode = null;
            } else {
              _tmpCompetitionCode = _cursor.getString(_cursorIndexOfCompetitionCode);
            }
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final long _tmpMatchDate;
            _tmpMatchDate = _cursor.getLong(_cursorIndexOfMatchDate);
            final int _tmpHomeClubId;
            _tmpHomeClubId = _cursor.getInt(_cursorIndexOfHomeClubId);
            final int _tmpAwayClubId;
            _tmpAwayClubId = _cursor.getInt(_cursorIndexOfAwayClubId);
            final int _tmpHomeScore;
            _tmpHomeScore = _cursor.getInt(_cursorIndexOfHomeScore);
            final int _tmpAwayScore;
            _tmpAwayScore = _cursor.getInt(_cursorIndexOfAwayScore);
            final String _tmpVenue;
            if (_cursor.isNull(_cursorIndexOfVenue)) {
              _tmpVenue = null;
            } else {
              _tmpVenue = _cursor.getString(_cursorIndexOfVenue);
            }
            _result = new MatchEntity(_tmpId,_tmpCompetitionCode,_tmpSeason,_tmpMatchDate,_tmpHomeClubId,_tmpAwayClubId,_tmpHomeScore,_tmpAwayScore,_tmpVenue);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<MatchPerformanceEntity>> getPerformancesForPlayer(final long playerId) {
    final String _sql = "\n"
            + "        SELECT * FROM player_match_performance \n"
            + "        WHERE playerId = ? \n"
            + "        ORDER BY matchId DESC\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, playerId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"player_match_performance"}, new Callable<List<MatchPerformanceEntity>>() {
      @Override
      @NonNull
      public List<MatchPerformanceEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPlayerId = CursorUtil.getColumnIndexOrThrow(_cursor, "playerId");
          final int _cursorIndexOfMatchId = CursorUtil.getColumnIndexOrThrow(_cursor, "matchId");
          final int _cursorIndexOfParticipationState = CursorUtil.getColumnIndexOrThrow(_cursor, "participationState");
          final int _cursorIndexOfMinutesPlayed = CursorUtil.getColumnIndexOrThrow(_cursor, "minutesPlayed");
          final int _cursorIndexOfGoals = CursorUtil.getColumnIndexOrThrow(_cursor, "goals");
          final int _cursorIndexOfAssists = CursorUtil.getColumnIndexOrThrow(_cursor, "assists");
          final int _cursorIndexOfYellowCard = CursorUtil.getColumnIndexOrThrow(_cursor, "yellowCard");
          final int _cursorIndexOfShots = CursorUtil.getColumnIndexOrThrow(_cursor, "shots");
          final int _cursorIndexOfPassesCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "passesCompleted");
          final int _cursorIndexOfPassesTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "passesTotal");
          final int _cursorIndexOfIsStarting = CursorUtil.getColumnIndexOrThrow(_cursor, "isStarting");
          final List<MatchPerformanceEntity> _result = new ArrayList<MatchPerformanceEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final MatchPerformanceEntity _item;
            final long _tmpPlayerId;
            _tmpPlayerId = _cursor.getLong(_cursorIndexOfPlayerId);
            final int _tmpMatchId;
            _tmpMatchId = _cursor.getInt(_cursorIndexOfMatchId);
            final String _tmpParticipationState;
            if (_cursor.isNull(_cursorIndexOfParticipationState)) {
              _tmpParticipationState = null;
            } else {
              _tmpParticipationState = _cursor.getString(_cursorIndexOfParticipationState);
            }
            final int _tmpMinutesPlayed;
            _tmpMinutesPlayed = _cursor.getInt(_cursorIndexOfMinutesPlayed);
            final int _tmpGoals;
            _tmpGoals = _cursor.getInt(_cursorIndexOfGoals);
            final int _tmpAssists;
            _tmpAssists = _cursor.getInt(_cursorIndexOfAssists);
            final boolean _tmpYellowCard;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfYellowCard);
            _tmpYellowCard = _tmp != 0;
            final int _tmpShots;
            _tmpShots = _cursor.getInt(_cursorIndexOfShots);
            final int _tmpPassesCompleted;
            _tmpPassesCompleted = _cursor.getInt(_cursorIndexOfPassesCompleted);
            final int _tmpPassesTotal;
            _tmpPassesTotal = _cursor.getInt(_cursorIndexOfPassesTotal);
            final boolean _tmpIsStarting;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsStarting);
            _tmpIsStarting = _tmp_1 != 0;
            _item = new MatchPerformanceEntity(_tmpPlayerId,_tmpMatchId,_tmpParticipationState,_tmpMinutesPlayed,_tmpGoals,_tmpAssists,_tmpYellowCard,_tmpShots,_tmpPassesCompleted,_tmpPassesTotal,_tmpIsStarting);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getPlayerTotals(final long playerId,
      final Continuation<? super PlayerTotals> arg1) {
    final String _sql = "\n"
            + "        SELECT SUM(goals) as totalGoals, SUM(assists) as totalAssists, SUM(minutesPlayed) as totalMinutes \n"
            + "        FROM player_match_performance \n"
            + "        WHERE playerId = ?\n"
            + "    ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, playerId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayerTotals>() {
      @Override
      @Nullable
      public PlayerTotals call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTotalGoals = 0;
          final int _cursorIndexOfTotalAssists = 1;
          final int _cursorIndexOfTotalMinutes = 2;
          final PlayerTotals _result;
          if (_cursor.moveToFirst()) {
            final int _tmpTotalGoals;
            _tmpTotalGoals = _cursor.getInt(_cursorIndexOfTotalGoals);
            final int _tmpTotalAssists;
            _tmpTotalAssists = _cursor.getInt(_cursorIndexOfTotalAssists);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            _result = new PlayerTotals(_tmpTotalGoals,_tmpTotalAssists,_tmpTotalMinutes);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg1);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
