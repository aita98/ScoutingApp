package com.scoutapp.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
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
public final class PlayerDao_Impl implements PlayerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PlayerEntity> __insertionAdapterOfPlayerEntity;

  private final EntityInsertionAdapter<PlayerEnrichmentEntity> __insertionAdapterOfPlayerEnrichmentEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWatchlistStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWatchlistStatusByTmId;

  private final SharedSQLiteStatement __preparedStmtOfUpdateStatsCache;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRating;

  public PlayerDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlayerEntity = new EntityInsertionAdapter<PlayerEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `cached_players` (`id`,`tmId`,`fbrefSlug`,`fbrefId`,`name`,`club`,`age`,`marketValue`,`talentScore`,`hiddenGemScore`,`position`,`photoUrl`,`isRetired`,`isWatchlisted`,`season`,`goals`,`assists`,`xG`,`minutes`,`goalsConceded`,`cleanSheets`,`foot`,`shirtNumber`,`citizenship`,`contractExpires`,`birthDate`,`seasonalStats`,`detailedStats`,`achievements`,`marketValueHistory`,`transfers`,`injuries`,`radarData`,`recentPerformanceJson`,`fbrefStatsJson`,`lastUpdated`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PlayerEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTmId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTmId());
        }
        if (entity.getFbrefSlug() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getFbrefSlug());
        }
        if (entity.getFbrefId() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFbrefId());
        }
        if (entity.getName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getName());
        }
        if (entity.getClub() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getClub());
        }
        if (entity.getAge() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getAge());
        }
        if (entity.getMarketValue() == null) {
          statement.bindNull(8);
        } else {
          statement.bindDouble(8, entity.getMarketValue());
        }
        statement.bindDouble(9, entity.getTalentScore());
        statement.bindDouble(10, entity.getHiddenGemScore());
        if (entity.getPosition() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getPosition());
        }
        if (entity.getPhotoUrl() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getPhotoUrl());
        }
        final int _tmp = entity.isRetired() ? 1 : 0;
        statement.bindLong(13, _tmp);
        final int _tmp_1 = entity.isWatchlisted() ? 1 : 0;
        statement.bindLong(14, _tmp_1);
        if (entity.getSeason() == null) {
          statement.bindNull(15);
        } else {
          statement.bindString(15, entity.getSeason());
        }
        if (entity.getGoals() == null) {
          statement.bindNull(16);
        } else {
          statement.bindLong(16, entity.getGoals());
        }
        if (entity.getAssists() == null) {
          statement.bindNull(17);
        } else {
          statement.bindLong(17, entity.getAssists());
        }
        if (entity.getXG() == null) {
          statement.bindNull(18);
        } else {
          statement.bindDouble(18, entity.getXG());
        }
        if (entity.getMinutes() == null) {
          statement.bindNull(19);
        } else {
          statement.bindLong(19, entity.getMinutes());
        }
        if (entity.getGoalsConceded() == null) {
          statement.bindNull(20);
        } else {
          statement.bindLong(20, entity.getGoalsConceded());
        }
        if (entity.getCleanSheets() == null) {
          statement.bindNull(21);
        } else {
          statement.bindLong(21, entity.getCleanSheets());
        }
        if (entity.getFoot() == null) {
          statement.bindNull(22);
        } else {
          statement.bindString(22, entity.getFoot());
        }
        if (entity.getShirtNumber() == null) {
          statement.bindNull(23);
        } else {
          statement.bindString(23, entity.getShirtNumber());
        }
        if (entity.getCitizenship() == null) {
          statement.bindNull(24);
        } else {
          statement.bindString(24, entity.getCitizenship());
        }
        if (entity.getContractExpires() == null) {
          statement.bindNull(25);
        } else {
          statement.bindString(25, entity.getContractExpires());
        }
        if (entity.getBirthDate() == null) {
          statement.bindNull(26);
        } else {
          statement.bindString(26, entity.getBirthDate());
        }
        if (entity.getSeasonalStats() == null) {
          statement.bindNull(27);
        } else {
          statement.bindString(27, entity.getSeasonalStats());
        }
        if (entity.getDetailedStats() == null) {
          statement.bindNull(28);
        } else {
          statement.bindString(28, entity.getDetailedStats());
        }
        if (entity.getAchievements() == null) {
          statement.bindNull(29);
        } else {
          statement.bindString(29, entity.getAchievements());
        }
        if (entity.getMarketValueHistory() == null) {
          statement.bindNull(30);
        } else {
          statement.bindString(30, entity.getMarketValueHistory());
        }
        if (entity.getTransfers() == null) {
          statement.bindNull(31);
        } else {
          statement.bindString(31, entity.getTransfers());
        }
        if (entity.getInjuries() == null) {
          statement.bindNull(32);
        } else {
          statement.bindString(32, entity.getInjuries());
        }
        if (entity.getRadarData() == null) {
          statement.bindNull(33);
        } else {
          statement.bindString(33, entity.getRadarData());
        }
        if (entity.getRecentPerformanceJson() == null) {
          statement.bindNull(34);
        } else {
          statement.bindString(34, entity.getRecentPerformanceJson());
        }
        if (entity.getFbrefStatsJson() == null) {
          statement.bindNull(35);
        } else {
          statement.bindString(35, entity.getFbrefStatsJson());
        }
        statement.bindLong(36, entity.getLastUpdated());
      }
    };
    this.__insertionAdapterOfPlayerEnrichmentEntity = new EntityInsertionAdapter<PlayerEnrichmentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `player_enrichment_cache` (`tmId`,`backendId`,`jsonData`,`rating`,`lastUpdated`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PlayerEnrichmentEntity entity) {
        if (entity.getTmId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getTmId());
        }
        statement.bindLong(2, entity.getBackendId());
        if (entity.getJsonData() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getJsonData());
        }
        statement.bindDouble(4, entity.getRating());
        statement.bindLong(5, entity.getLastUpdated());
      }
    };
    this.__preparedStmtOfUpdateWatchlistStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE cached_players SET isWatchlisted = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateWatchlistStatusByTmId = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE cached_players SET isWatchlisted = ? WHERE tmId = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateStatsCache = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE cached_players SET goals = ?, assists = ?, minutes = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRating = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE player_enrichment_cache SET rating = ? WHERE tmId = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertPlayers(final List<PlayerEntity> players,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPlayerEntity.insert(players);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insertEnrichment(final PlayerEnrichmentEntity enrichment,
      final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPlayerEnrichmentEntity.insert(enrichment);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateWatchlistStatus(final long playerId, final boolean status,
      final Continuation<? super Unit> arg2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWatchlistStatus.acquire();
        int _argIndex = 1;
        final int _tmp = status ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, playerId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateWatchlistStatus.release(_stmt);
        }
      }
    }, arg2);
  }

  @Override
  public Object updateWatchlistStatusByTmId(final String tmId, final boolean status,
      final Continuation<? super Unit> arg2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWatchlistStatusByTmId.acquire();
        int _argIndex = 1;
        final int _tmp = status ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        if (tmId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, tmId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateWatchlistStatusByTmId.release(_stmt);
        }
      }
    }, arg2);
  }

  @Override
  public Object updateStatsCache(final long playerId, final int goals, final int assists,
      final int minutes, final Continuation<? super Unit> arg4) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateStatsCache.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, goals);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, assists);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, minutes);
        _argIndex = 4;
        _stmt.bindLong(_argIndex, playerId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateStatsCache.release(_stmt);
        }
      }
    }, arg4);
  }

  @Override
  public Object updateRating(final String tmId, final float rating,
      final Continuation<? super Unit> arg2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRating.acquire();
        int _argIndex = 1;
        _stmt.bindDouble(_argIndex, rating);
        _argIndex = 2;
        if (tmId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, tmId);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateRating.release(_stmt);
        }
      }
    }, arg2);
  }

  @Override
  public Flow<List<PlayerEntity>> getWatchlist() {
    final String _sql = "SELECT * FROM cached_players WHERE isWatchlisted = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"cached_players"}, new Callable<List<PlayerEntity>>() {
      @Override
      @NonNull
      public List<PlayerEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTmId = CursorUtil.getColumnIndexOrThrow(_cursor, "tmId");
          final int _cursorIndexOfFbrefSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefSlug");
          final int _cursorIndexOfFbrefId = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClub = CursorUtil.getColumnIndexOrThrow(_cursor, "club");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfMarketValue = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValue");
          final int _cursorIndexOfTalentScore = CursorUtil.getColumnIndexOrThrow(_cursor, "talentScore");
          final int _cursorIndexOfHiddenGemScore = CursorUtil.getColumnIndexOrThrow(_cursor, "hiddenGemScore");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfIsRetired = CursorUtil.getColumnIndexOrThrow(_cursor, "isRetired");
          final int _cursorIndexOfIsWatchlisted = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatchlisted");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfGoals = CursorUtil.getColumnIndexOrThrow(_cursor, "goals");
          final int _cursorIndexOfAssists = CursorUtil.getColumnIndexOrThrow(_cursor, "assists");
          final int _cursorIndexOfXG = CursorUtil.getColumnIndexOrThrow(_cursor, "xG");
          final int _cursorIndexOfMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "minutes");
          final int _cursorIndexOfGoalsConceded = CursorUtil.getColumnIndexOrThrow(_cursor, "goalsConceded");
          final int _cursorIndexOfCleanSheets = CursorUtil.getColumnIndexOrThrow(_cursor, "cleanSheets");
          final int _cursorIndexOfFoot = CursorUtil.getColumnIndexOrThrow(_cursor, "foot");
          final int _cursorIndexOfShirtNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "shirtNumber");
          final int _cursorIndexOfCitizenship = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenship");
          final int _cursorIndexOfContractExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "contractExpires");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfSeasonalStats = CursorUtil.getColumnIndexOrThrow(_cursor, "seasonalStats");
          final int _cursorIndexOfDetailedStats = CursorUtil.getColumnIndexOrThrow(_cursor, "detailedStats");
          final int _cursorIndexOfAchievements = CursorUtil.getColumnIndexOrThrow(_cursor, "achievements");
          final int _cursorIndexOfMarketValueHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValueHistory");
          final int _cursorIndexOfTransfers = CursorUtil.getColumnIndexOrThrow(_cursor, "transfers");
          final int _cursorIndexOfInjuries = CursorUtil.getColumnIndexOrThrow(_cursor, "injuries");
          final int _cursorIndexOfRadarData = CursorUtil.getColumnIndexOrThrow(_cursor, "radarData");
          final int _cursorIndexOfRecentPerformanceJson = CursorUtil.getColumnIndexOrThrow(_cursor, "recentPerformanceJson");
          final int _cursorIndexOfFbrefStatsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefStatsJson");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final List<PlayerEntity> _result = new ArrayList<PlayerEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayerEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTmId;
            if (_cursor.isNull(_cursorIndexOfTmId)) {
              _tmpTmId = null;
            } else {
              _tmpTmId = _cursor.getString(_cursorIndexOfTmId);
            }
            final String _tmpFbrefSlug;
            if (_cursor.isNull(_cursorIndexOfFbrefSlug)) {
              _tmpFbrefSlug = null;
            } else {
              _tmpFbrefSlug = _cursor.getString(_cursorIndexOfFbrefSlug);
            }
            final String _tmpFbrefId;
            if (_cursor.isNull(_cursorIndexOfFbrefId)) {
              _tmpFbrefId = null;
            } else {
              _tmpFbrefId = _cursor.getString(_cursorIndexOfFbrefId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClub;
            if (_cursor.isNull(_cursorIndexOfClub)) {
              _tmpClub = null;
            } else {
              _tmpClub = _cursor.getString(_cursorIndexOfClub);
            }
            final Integer _tmpAge;
            if (_cursor.isNull(_cursorIndexOfAge)) {
              _tmpAge = null;
            } else {
              _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            }
            final Double _tmpMarketValue;
            if (_cursor.isNull(_cursorIndexOfMarketValue)) {
              _tmpMarketValue = null;
            } else {
              _tmpMarketValue = _cursor.getDouble(_cursorIndexOfMarketValue);
            }
            final double _tmpTalentScore;
            _tmpTalentScore = _cursor.getDouble(_cursorIndexOfTalentScore);
            final double _tmpHiddenGemScore;
            _tmpHiddenGemScore = _cursor.getDouble(_cursorIndexOfHiddenGemScore);
            final String _tmpPosition;
            if (_cursor.isNull(_cursorIndexOfPosition)) {
              _tmpPosition = null;
            } else {
              _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final boolean _tmpIsRetired;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRetired);
            _tmpIsRetired = _tmp != 0;
            final boolean _tmpIsWatchlisted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsWatchlisted);
            _tmpIsWatchlisted = _tmp_1 != 0;
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final Integer _tmpGoals;
            if (_cursor.isNull(_cursorIndexOfGoals)) {
              _tmpGoals = null;
            } else {
              _tmpGoals = _cursor.getInt(_cursorIndexOfGoals);
            }
            final Integer _tmpAssists;
            if (_cursor.isNull(_cursorIndexOfAssists)) {
              _tmpAssists = null;
            } else {
              _tmpAssists = _cursor.getInt(_cursorIndexOfAssists);
            }
            final Double _tmpXG;
            if (_cursor.isNull(_cursorIndexOfXG)) {
              _tmpXG = null;
            } else {
              _tmpXG = _cursor.getDouble(_cursorIndexOfXG);
            }
            final Integer _tmpMinutes;
            if (_cursor.isNull(_cursorIndexOfMinutes)) {
              _tmpMinutes = null;
            } else {
              _tmpMinutes = _cursor.getInt(_cursorIndexOfMinutes);
            }
            final Integer _tmpGoalsConceded;
            if (_cursor.isNull(_cursorIndexOfGoalsConceded)) {
              _tmpGoalsConceded = null;
            } else {
              _tmpGoalsConceded = _cursor.getInt(_cursorIndexOfGoalsConceded);
            }
            final Integer _tmpCleanSheets;
            if (_cursor.isNull(_cursorIndexOfCleanSheets)) {
              _tmpCleanSheets = null;
            } else {
              _tmpCleanSheets = _cursor.getInt(_cursorIndexOfCleanSheets);
            }
            final String _tmpFoot;
            if (_cursor.isNull(_cursorIndexOfFoot)) {
              _tmpFoot = null;
            } else {
              _tmpFoot = _cursor.getString(_cursorIndexOfFoot);
            }
            final String _tmpShirtNumber;
            if (_cursor.isNull(_cursorIndexOfShirtNumber)) {
              _tmpShirtNumber = null;
            } else {
              _tmpShirtNumber = _cursor.getString(_cursorIndexOfShirtNumber);
            }
            final String _tmpCitizenship;
            if (_cursor.isNull(_cursorIndexOfCitizenship)) {
              _tmpCitizenship = null;
            } else {
              _tmpCitizenship = _cursor.getString(_cursorIndexOfCitizenship);
            }
            final String _tmpContractExpires;
            if (_cursor.isNull(_cursorIndexOfContractExpires)) {
              _tmpContractExpires = null;
            } else {
              _tmpContractExpires = _cursor.getString(_cursorIndexOfContractExpires);
            }
            final String _tmpBirthDate;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmpBirthDate = null;
            } else {
              _tmpBirthDate = _cursor.getString(_cursorIndexOfBirthDate);
            }
            final String _tmpSeasonalStats;
            if (_cursor.isNull(_cursorIndexOfSeasonalStats)) {
              _tmpSeasonalStats = null;
            } else {
              _tmpSeasonalStats = _cursor.getString(_cursorIndexOfSeasonalStats);
            }
            final String _tmpDetailedStats;
            if (_cursor.isNull(_cursorIndexOfDetailedStats)) {
              _tmpDetailedStats = null;
            } else {
              _tmpDetailedStats = _cursor.getString(_cursorIndexOfDetailedStats);
            }
            final String _tmpAchievements;
            if (_cursor.isNull(_cursorIndexOfAchievements)) {
              _tmpAchievements = null;
            } else {
              _tmpAchievements = _cursor.getString(_cursorIndexOfAchievements);
            }
            final String _tmpMarketValueHistory;
            if (_cursor.isNull(_cursorIndexOfMarketValueHistory)) {
              _tmpMarketValueHistory = null;
            } else {
              _tmpMarketValueHistory = _cursor.getString(_cursorIndexOfMarketValueHistory);
            }
            final String _tmpTransfers;
            if (_cursor.isNull(_cursorIndexOfTransfers)) {
              _tmpTransfers = null;
            } else {
              _tmpTransfers = _cursor.getString(_cursorIndexOfTransfers);
            }
            final String _tmpInjuries;
            if (_cursor.isNull(_cursorIndexOfInjuries)) {
              _tmpInjuries = null;
            } else {
              _tmpInjuries = _cursor.getString(_cursorIndexOfInjuries);
            }
            final String _tmpRadarData;
            if (_cursor.isNull(_cursorIndexOfRadarData)) {
              _tmpRadarData = null;
            } else {
              _tmpRadarData = _cursor.getString(_cursorIndexOfRadarData);
            }
            final String _tmpRecentPerformanceJson;
            if (_cursor.isNull(_cursorIndexOfRecentPerformanceJson)) {
              _tmpRecentPerformanceJson = null;
            } else {
              _tmpRecentPerformanceJson = _cursor.getString(_cursorIndexOfRecentPerformanceJson);
            }
            final String _tmpFbrefStatsJson;
            if (_cursor.isNull(_cursorIndexOfFbrefStatsJson)) {
              _tmpFbrefStatsJson = null;
            } else {
              _tmpFbrefStatsJson = _cursor.getString(_cursorIndexOfFbrefStatsJson);
            }
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _item = new PlayerEntity(_tmpId,_tmpTmId,_tmpFbrefSlug,_tmpFbrefId,_tmpName,_tmpClub,_tmpAge,_tmpMarketValue,_tmpTalentScore,_tmpHiddenGemScore,_tmpPosition,_tmpPhotoUrl,_tmpIsRetired,_tmpIsWatchlisted,_tmpSeason,_tmpGoals,_tmpAssists,_tmpXG,_tmpMinutes,_tmpGoalsConceded,_tmpCleanSheets,_tmpFoot,_tmpShirtNumber,_tmpCitizenship,_tmpContractExpires,_tmpBirthDate,_tmpSeasonalStats,_tmpDetailedStats,_tmpAchievements,_tmpMarketValueHistory,_tmpTransfers,_tmpInjuries,_tmpRadarData,_tmpRecentPerformanceJson,_tmpFbrefStatsJson,_tmpLastUpdated);
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
  public Object getPlayerById(final long playerId, final Continuation<? super PlayerEntity> arg1) {
    final String _sql = "SELECT * FROM cached_players WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, playerId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayerEntity>() {
      @Override
      @Nullable
      public PlayerEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTmId = CursorUtil.getColumnIndexOrThrow(_cursor, "tmId");
          final int _cursorIndexOfFbrefSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefSlug");
          final int _cursorIndexOfFbrefId = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClub = CursorUtil.getColumnIndexOrThrow(_cursor, "club");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfMarketValue = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValue");
          final int _cursorIndexOfTalentScore = CursorUtil.getColumnIndexOrThrow(_cursor, "talentScore");
          final int _cursorIndexOfHiddenGemScore = CursorUtil.getColumnIndexOrThrow(_cursor, "hiddenGemScore");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfIsRetired = CursorUtil.getColumnIndexOrThrow(_cursor, "isRetired");
          final int _cursorIndexOfIsWatchlisted = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatchlisted");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfGoals = CursorUtil.getColumnIndexOrThrow(_cursor, "goals");
          final int _cursorIndexOfAssists = CursorUtil.getColumnIndexOrThrow(_cursor, "assists");
          final int _cursorIndexOfXG = CursorUtil.getColumnIndexOrThrow(_cursor, "xG");
          final int _cursorIndexOfMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "minutes");
          final int _cursorIndexOfGoalsConceded = CursorUtil.getColumnIndexOrThrow(_cursor, "goalsConceded");
          final int _cursorIndexOfCleanSheets = CursorUtil.getColumnIndexOrThrow(_cursor, "cleanSheets");
          final int _cursorIndexOfFoot = CursorUtil.getColumnIndexOrThrow(_cursor, "foot");
          final int _cursorIndexOfShirtNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "shirtNumber");
          final int _cursorIndexOfCitizenship = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenship");
          final int _cursorIndexOfContractExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "contractExpires");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfSeasonalStats = CursorUtil.getColumnIndexOrThrow(_cursor, "seasonalStats");
          final int _cursorIndexOfDetailedStats = CursorUtil.getColumnIndexOrThrow(_cursor, "detailedStats");
          final int _cursorIndexOfAchievements = CursorUtil.getColumnIndexOrThrow(_cursor, "achievements");
          final int _cursorIndexOfMarketValueHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValueHistory");
          final int _cursorIndexOfTransfers = CursorUtil.getColumnIndexOrThrow(_cursor, "transfers");
          final int _cursorIndexOfInjuries = CursorUtil.getColumnIndexOrThrow(_cursor, "injuries");
          final int _cursorIndexOfRadarData = CursorUtil.getColumnIndexOrThrow(_cursor, "radarData");
          final int _cursorIndexOfRecentPerformanceJson = CursorUtil.getColumnIndexOrThrow(_cursor, "recentPerformanceJson");
          final int _cursorIndexOfFbrefStatsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefStatsJson");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final PlayerEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTmId;
            if (_cursor.isNull(_cursorIndexOfTmId)) {
              _tmpTmId = null;
            } else {
              _tmpTmId = _cursor.getString(_cursorIndexOfTmId);
            }
            final String _tmpFbrefSlug;
            if (_cursor.isNull(_cursorIndexOfFbrefSlug)) {
              _tmpFbrefSlug = null;
            } else {
              _tmpFbrefSlug = _cursor.getString(_cursorIndexOfFbrefSlug);
            }
            final String _tmpFbrefId;
            if (_cursor.isNull(_cursorIndexOfFbrefId)) {
              _tmpFbrefId = null;
            } else {
              _tmpFbrefId = _cursor.getString(_cursorIndexOfFbrefId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClub;
            if (_cursor.isNull(_cursorIndexOfClub)) {
              _tmpClub = null;
            } else {
              _tmpClub = _cursor.getString(_cursorIndexOfClub);
            }
            final Integer _tmpAge;
            if (_cursor.isNull(_cursorIndexOfAge)) {
              _tmpAge = null;
            } else {
              _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            }
            final Double _tmpMarketValue;
            if (_cursor.isNull(_cursorIndexOfMarketValue)) {
              _tmpMarketValue = null;
            } else {
              _tmpMarketValue = _cursor.getDouble(_cursorIndexOfMarketValue);
            }
            final double _tmpTalentScore;
            _tmpTalentScore = _cursor.getDouble(_cursorIndexOfTalentScore);
            final double _tmpHiddenGemScore;
            _tmpHiddenGemScore = _cursor.getDouble(_cursorIndexOfHiddenGemScore);
            final String _tmpPosition;
            if (_cursor.isNull(_cursorIndexOfPosition)) {
              _tmpPosition = null;
            } else {
              _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final boolean _tmpIsRetired;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRetired);
            _tmpIsRetired = _tmp != 0;
            final boolean _tmpIsWatchlisted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsWatchlisted);
            _tmpIsWatchlisted = _tmp_1 != 0;
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final Integer _tmpGoals;
            if (_cursor.isNull(_cursorIndexOfGoals)) {
              _tmpGoals = null;
            } else {
              _tmpGoals = _cursor.getInt(_cursorIndexOfGoals);
            }
            final Integer _tmpAssists;
            if (_cursor.isNull(_cursorIndexOfAssists)) {
              _tmpAssists = null;
            } else {
              _tmpAssists = _cursor.getInt(_cursorIndexOfAssists);
            }
            final Double _tmpXG;
            if (_cursor.isNull(_cursorIndexOfXG)) {
              _tmpXG = null;
            } else {
              _tmpXG = _cursor.getDouble(_cursorIndexOfXG);
            }
            final Integer _tmpMinutes;
            if (_cursor.isNull(_cursorIndexOfMinutes)) {
              _tmpMinutes = null;
            } else {
              _tmpMinutes = _cursor.getInt(_cursorIndexOfMinutes);
            }
            final Integer _tmpGoalsConceded;
            if (_cursor.isNull(_cursorIndexOfGoalsConceded)) {
              _tmpGoalsConceded = null;
            } else {
              _tmpGoalsConceded = _cursor.getInt(_cursorIndexOfGoalsConceded);
            }
            final Integer _tmpCleanSheets;
            if (_cursor.isNull(_cursorIndexOfCleanSheets)) {
              _tmpCleanSheets = null;
            } else {
              _tmpCleanSheets = _cursor.getInt(_cursorIndexOfCleanSheets);
            }
            final String _tmpFoot;
            if (_cursor.isNull(_cursorIndexOfFoot)) {
              _tmpFoot = null;
            } else {
              _tmpFoot = _cursor.getString(_cursorIndexOfFoot);
            }
            final String _tmpShirtNumber;
            if (_cursor.isNull(_cursorIndexOfShirtNumber)) {
              _tmpShirtNumber = null;
            } else {
              _tmpShirtNumber = _cursor.getString(_cursorIndexOfShirtNumber);
            }
            final String _tmpCitizenship;
            if (_cursor.isNull(_cursorIndexOfCitizenship)) {
              _tmpCitizenship = null;
            } else {
              _tmpCitizenship = _cursor.getString(_cursorIndexOfCitizenship);
            }
            final String _tmpContractExpires;
            if (_cursor.isNull(_cursorIndexOfContractExpires)) {
              _tmpContractExpires = null;
            } else {
              _tmpContractExpires = _cursor.getString(_cursorIndexOfContractExpires);
            }
            final String _tmpBirthDate;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmpBirthDate = null;
            } else {
              _tmpBirthDate = _cursor.getString(_cursorIndexOfBirthDate);
            }
            final String _tmpSeasonalStats;
            if (_cursor.isNull(_cursorIndexOfSeasonalStats)) {
              _tmpSeasonalStats = null;
            } else {
              _tmpSeasonalStats = _cursor.getString(_cursorIndexOfSeasonalStats);
            }
            final String _tmpDetailedStats;
            if (_cursor.isNull(_cursorIndexOfDetailedStats)) {
              _tmpDetailedStats = null;
            } else {
              _tmpDetailedStats = _cursor.getString(_cursorIndexOfDetailedStats);
            }
            final String _tmpAchievements;
            if (_cursor.isNull(_cursorIndexOfAchievements)) {
              _tmpAchievements = null;
            } else {
              _tmpAchievements = _cursor.getString(_cursorIndexOfAchievements);
            }
            final String _tmpMarketValueHistory;
            if (_cursor.isNull(_cursorIndexOfMarketValueHistory)) {
              _tmpMarketValueHistory = null;
            } else {
              _tmpMarketValueHistory = _cursor.getString(_cursorIndexOfMarketValueHistory);
            }
            final String _tmpTransfers;
            if (_cursor.isNull(_cursorIndexOfTransfers)) {
              _tmpTransfers = null;
            } else {
              _tmpTransfers = _cursor.getString(_cursorIndexOfTransfers);
            }
            final String _tmpInjuries;
            if (_cursor.isNull(_cursorIndexOfInjuries)) {
              _tmpInjuries = null;
            } else {
              _tmpInjuries = _cursor.getString(_cursorIndexOfInjuries);
            }
            final String _tmpRadarData;
            if (_cursor.isNull(_cursorIndexOfRadarData)) {
              _tmpRadarData = null;
            } else {
              _tmpRadarData = _cursor.getString(_cursorIndexOfRadarData);
            }
            final String _tmpRecentPerformanceJson;
            if (_cursor.isNull(_cursorIndexOfRecentPerformanceJson)) {
              _tmpRecentPerformanceJson = null;
            } else {
              _tmpRecentPerformanceJson = _cursor.getString(_cursorIndexOfRecentPerformanceJson);
            }
            final String _tmpFbrefStatsJson;
            if (_cursor.isNull(_cursorIndexOfFbrefStatsJson)) {
              _tmpFbrefStatsJson = null;
            } else {
              _tmpFbrefStatsJson = _cursor.getString(_cursorIndexOfFbrefStatsJson);
            }
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new PlayerEntity(_tmpId,_tmpTmId,_tmpFbrefSlug,_tmpFbrefId,_tmpName,_tmpClub,_tmpAge,_tmpMarketValue,_tmpTalentScore,_tmpHiddenGemScore,_tmpPosition,_tmpPhotoUrl,_tmpIsRetired,_tmpIsWatchlisted,_tmpSeason,_tmpGoals,_tmpAssists,_tmpXG,_tmpMinutes,_tmpGoalsConceded,_tmpCleanSheets,_tmpFoot,_tmpShirtNumber,_tmpCitizenship,_tmpContractExpires,_tmpBirthDate,_tmpSeasonalStats,_tmpDetailedStats,_tmpAchievements,_tmpMarketValueHistory,_tmpTransfers,_tmpInjuries,_tmpRadarData,_tmpRecentPerformanceJson,_tmpFbrefStatsJson,_tmpLastUpdated);
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
  public Object getPlayerByTmId(final String tmId, final Continuation<? super PlayerEntity> arg1) {
    final String _sql = "SELECT * FROM cached_players WHERE tmId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tmId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tmId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayerEntity>() {
      @Override
      @Nullable
      public PlayerEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTmId = CursorUtil.getColumnIndexOrThrow(_cursor, "tmId");
          final int _cursorIndexOfFbrefSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefSlug");
          final int _cursorIndexOfFbrefId = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClub = CursorUtil.getColumnIndexOrThrow(_cursor, "club");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfMarketValue = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValue");
          final int _cursorIndexOfTalentScore = CursorUtil.getColumnIndexOrThrow(_cursor, "talentScore");
          final int _cursorIndexOfHiddenGemScore = CursorUtil.getColumnIndexOrThrow(_cursor, "hiddenGemScore");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfIsRetired = CursorUtil.getColumnIndexOrThrow(_cursor, "isRetired");
          final int _cursorIndexOfIsWatchlisted = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatchlisted");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfGoals = CursorUtil.getColumnIndexOrThrow(_cursor, "goals");
          final int _cursorIndexOfAssists = CursorUtil.getColumnIndexOrThrow(_cursor, "assists");
          final int _cursorIndexOfXG = CursorUtil.getColumnIndexOrThrow(_cursor, "xG");
          final int _cursorIndexOfMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "minutes");
          final int _cursorIndexOfGoalsConceded = CursorUtil.getColumnIndexOrThrow(_cursor, "goalsConceded");
          final int _cursorIndexOfCleanSheets = CursorUtil.getColumnIndexOrThrow(_cursor, "cleanSheets");
          final int _cursorIndexOfFoot = CursorUtil.getColumnIndexOrThrow(_cursor, "foot");
          final int _cursorIndexOfShirtNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "shirtNumber");
          final int _cursorIndexOfCitizenship = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenship");
          final int _cursorIndexOfContractExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "contractExpires");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfSeasonalStats = CursorUtil.getColumnIndexOrThrow(_cursor, "seasonalStats");
          final int _cursorIndexOfDetailedStats = CursorUtil.getColumnIndexOrThrow(_cursor, "detailedStats");
          final int _cursorIndexOfAchievements = CursorUtil.getColumnIndexOrThrow(_cursor, "achievements");
          final int _cursorIndexOfMarketValueHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValueHistory");
          final int _cursorIndexOfTransfers = CursorUtil.getColumnIndexOrThrow(_cursor, "transfers");
          final int _cursorIndexOfInjuries = CursorUtil.getColumnIndexOrThrow(_cursor, "injuries");
          final int _cursorIndexOfRadarData = CursorUtil.getColumnIndexOrThrow(_cursor, "radarData");
          final int _cursorIndexOfRecentPerformanceJson = CursorUtil.getColumnIndexOrThrow(_cursor, "recentPerformanceJson");
          final int _cursorIndexOfFbrefStatsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefStatsJson");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final PlayerEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTmId;
            if (_cursor.isNull(_cursorIndexOfTmId)) {
              _tmpTmId = null;
            } else {
              _tmpTmId = _cursor.getString(_cursorIndexOfTmId);
            }
            final String _tmpFbrefSlug;
            if (_cursor.isNull(_cursorIndexOfFbrefSlug)) {
              _tmpFbrefSlug = null;
            } else {
              _tmpFbrefSlug = _cursor.getString(_cursorIndexOfFbrefSlug);
            }
            final String _tmpFbrefId;
            if (_cursor.isNull(_cursorIndexOfFbrefId)) {
              _tmpFbrefId = null;
            } else {
              _tmpFbrefId = _cursor.getString(_cursorIndexOfFbrefId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClub;
            if (_cursor.isNull(_cursorIndexOfClub)) {
              _tmpClub = null;
            } else {
              _tmpClub = _cursor.getString(_cursorIndexOfClub);
            }
            final Integer _tmpAge;
            if (_cursor.isNull(_cursorIndexOfAge)) {
              _tmpAge = null;
            } else {
              _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            }
            final Double _tmpMarketValue;
            if (_cursor.isNull(_cursorIndexOfMarketValue)) {
              _tmpMarketValue = null;
            } else {
              _tmpMarketValue = _cursor.getDouble(_cursorIndexOfMarketValue);
            }
            final double _tmpTalentScore;
            _tmpTalentScore = _cursor.getDouble(_cursorIndexOfTalentScore);
            final double _tmpHiddenGemScore;
            _tmpHiddenGemScore = _cursor.getDouble(_cursorIndexOfHiddenGemScore);
            final String _tmpPosition;
            if (_cursor.isNull(_cursorIndexOfPosition)) {
              _tmpPosition = null;
            } else {
              _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final boolean _tmpIsRetired;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRetired);
            _tmpIsRetired = _tmp != 0;
            final boolean _tmpIsWatchlisted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsWatchlisted);
            _tmpIsWatchlisted = _tmp_1 != 0;
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final Integer _tmpGoals;
            if (_cursor.isNull(_cursorIndexOfGoals)) {
              _tmpGoals = null;
            } else {
              _tmpGoals = _cursor.getInt(_cursorIndexOfGoals);
            }
            final Integer _tmpAssists;
            if (_cursor.isNull(_cursorIndexOfAssists)) {
              _tmpAssists = null;
            } else {
              _tmpAssists = _cursor.getInt(_cursorIndexOfAssists);
            }
            final Double _tmpXG;
            if (_cursor.isNull(_cursorIndexOfXG)) {
              _tmpXG = null;
            } else {
              _tmpXG = _cursor.getDouble(_cursorIndexOfXG);
            }
            final Integer _tmpMinutes;
            if (_cursor.isNull(_cursorIndexOfMinutes)) {
              _tmpMinutes = null;
            } else {
              _tmpMinutes = _cursor.getInt(_cursorIndexOfMinutes);
            }
            final Integer _tmpGoalsConceded;
            if (_cursor.isNull(_cursorIndexOfGoalsConceded)) {
              _tmpGoalsConceded = null;
            } else {
              _tmpGoalsConceded = _cursor.getInt(_cursorIndexOfGoalsConceded);
            }
            final Integer _tmpCleanSheets;
            if (_cursor.isNull(_cursorIndexOfCleanSheets)) {
              _tmpCleanSheets = null;
            } else {
              _tmpCleanSheets = _cursor.getInt(_cursorIndexOfCleanSheets);
            }
            final String _tmpFoot;
            if (_cursor.isNull(_cursorIndexOfFoot)) {
              _tmpFoot = null;
            } else {
              _tmpFoot = _cursor.getString(_cursorIndexOfFoot);
            }
            final String _tmpShirtNumber;
            if (_cursor.isNull(_cursorIndexOfShirtNumber)) {
              _tmpShirtNumber = null;
            } else {
              _tmpShirtNumber = _cursor.getString(_cursorIndexOfShirtNumber);
            }
            final String _tmpCitizenship;
            if (_cursor.isNull(_cursorIndexOfCitizenship)) {
              _tmpCitizenship = null;
            } else {
              _tmpCitizenship = _cursor.getString(_cursorIndexOfCitizenship);
            }
            final String _tmpContractExpires;
            if (_cursor.isNull(_cursorIndexOfContractExpires)) {
              _tmpContractExpires = null;
            } else {
              _tmpContractExpires = _cursor.getString(_cursorIndexOfContractExpires);
            }
            final String _tmpBirthDate;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmpBirthDate = null;
            } else {
              _tmpBirthDate = _cursor.getString(_cursorIndexOfBirthDate);
            }
            final String _tmpSeasonalStats;
            if (_cursor.isNull(_cursorIndexOfSeasonalStats)) {
              _tmpSeasonalStats = null;
            } else {
              _tmpSeasonalStats = _cursor.getString(_cursorIndexOfSeasonalStats);
            }
            final String _tmpDetailedStats;
            if (_cursor.isNull(_cursorIndexOfDetailedStats)) {
              _tmpDetailedStats = null;
            } else {
              _tmpDetailedStats = _cursor.getString(_cursorIndexOfDetailedStats);
            }
            final String _tmpAchievements;
            if (_cursor.isNull(_cursorIndexOfAchievements)) {
              _tmpAchievements = null;
            } else {
              _tmpAchievements = _cursor.getString(_cursorIndexOfAchievements);
            }
            final String _tmpMarketValueHistory;
            if (_cursor.isNull(_cursorIndexOfMarketValueHistory)) {
              _tmpMarketValueHistory = null;
            } else {
              _tmpMarketValueHistory = _cursor.getString(_cursorIndexOfMarketValueHistory);
            }
            final String _tmpTransfers;
            if (_cursor.isNull(_cursorIndexOfTransfers)) {
              _tmpTransfers = null;
            } else {
              _tmpTransfers = _cursor.getString(_cursorIndexOfTransfers);
            }
            final String _tmpInjuries;
            if (_cursor.isNull(_cursorIndexOfInjuries)) {
              _tmpInjuries = null;
            } else {
              _tmpInjuries = _cursor.getString(_cursorIndexOfInjuries);
            }
            final String _tmpRadarData;
            if (_cursor.isNull(_cursorIndexOfRadarData)) {
              _tmpRadarData = null;
            } else {
              _tmpRadarData = _cursor.getString(_cursorIndexOfRadarData);
            }
            final String _tmpRecentPerformanceJson;
            if (_cursor.isNull(_cursorIndexOfRecentPerformanceJson)) {
              _tmpRecentPerformanceJson = null;
            } else {
              _tmpRecentPerformanceJson = _cursor.getString(_cursorIndexOfRecentPerformanceJson);
            }
            final String _tmpFbrefStatsJson;
            if (_cursor.isNull(_cursorIndexOfFbrefStatsJson)) {
              _tmpFbrefStatsJson = null;
            } else {
              _tmpFbrefStatsJson = _cursor.getString(_cursorIndexOfFbrefStatsJson);
            }
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new PlayerEntity(_tmpId,_tmpTmId,_tmpFbrefSlug,_tmpFbrefId,_tmpName,_tmpClub,_tmpAge,_tmpMarketValue,_tmpTalentScore,_tmpHiddenGemScore,_tmpPosition,_tmpPhotoUrl,_tmpIsRetired,_tmpIsWatchlisted,_tmpSeason,_tmpGoals,_tmpAssists,_tmpXG,_tmpMinutes,_tmpGoalsConceded,_tmpCleanSheets,_tmpFoot,_tmpShirtNumber,_tmpCitizenship,_tmpContractExpires,_tmpBirthDate,_tmpSeasonalStats,_tmpDetailedStats,_tmpAchievements,_tmpMarketValueHistory,_tmpTransfers,_tmpInjuries,_tmpRadarData,_tmpRecentPerformanceJson,_tmpFbrefStatsJson,_tmpLastUpdated);
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
  public Object getPlayerByName(final String name, final Continuation<? super PlayerEntity> arg1) {
    final String _sql = "SELECT * FROM cached_players WHERE name LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayerEntity>() {
      @Override
      @Nullable
      public PlayerEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTmId = CursorUtil.getColumnIndexOrThrow(_cursor, "tmId");
          final int _cursorIndexOfFbrefSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefSlug");
          final int _cursorIndexOfFbrefId = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefId");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClub = CursorUtil.getColumnIndexOrThrow(_cursor, "club");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfMarketValue = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValue");
          final int _cursorIndexOfTalentScore = CursorUtil.getColumnIndexOrThrow(_cursor, "talentScore");
          final int _cursorIndexOfHiddenGemScore = CursorUtil.getColumnIndexOrThrow(_cursor, "hiddenGemScore");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final int _cursorIndexOfIsRetired = CursorUtil.getColumnIndexOrThrow(_cursor, "isRetired");
          final int _cursorIndexOfIsWatchlisted = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatchlisted");
          final int _cursorIndexOfSeason = CursorUtil.getColumnIndexOrThrow(_cursor, "season");
          final int _cursorIndexOfGoals = CursorUtil.getColumnIndexOrThrow(_cursor, "goals");
          final int _cursorIndexOfAssists = CursorUtil.getColumnIndexOrThrow(_cursor, "assists");
          final int _cursorIndexOfXG = CursorUtil.getColumnIndexOrThrow(_cursor, "xG");
          final int _cursorIndexOfMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "minutes");
          final int _cursorIndexOfGoalsConceded = CursorUtil.getColumnIndexOrThrow(_cursor, "goalsConceded");
          final int _cursorIndexOfCleanSheets = CursorUtil.getColumnIndexOrThrow(_cursor, "cleanSheets");
          final int _cursorIndexOfFoot = CursorUtil.getColumnIndexOrThrow(_cursor, "foot");
          final int _cursorIndexOfShirtNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "shirtNumber");
          final int _cursorIndexOfCitizenship = CursorUtil.getColumnIndexOrThrow(_cursor, "citizenship");
          final int _cursorIndexOfContractExpires = CursorUtil.getColumnIndexOrThrow(_cursor, "contractExpires");
          final int _cursorIndexOfBirthDate = CursorUtil.getColumnIndexOrThrow(_cursor, "birthDate");
          final int _cursorIndexOfSeasonalStats = CursorUtil.getColumnIndexOrThrow(_cursor, "seasonalStats");
          final int _cursorIndexOfDetailedStats = CursorUtil.getColumnIndexOrThrow(_cursor, "detailedStats");
          final int _cursorIndexOfAchievements = CursorUtil.getColumnIndexOrThrow(_cursor, "achievements");
          final int _cursorIndexOfMarketValueHistory = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValueHistory");
          final int _cursorIndexOfTransfers = CursorUtil.getColumnIndexOrThrow(_cursor, "transfers");
          final int _cursorIndexOfInjuries = CursorUtil.getColumnIndexOrThrow(_cursor, "injuries");
          final int _cursorIndexOfRadarData = CursorUtil.getColumnIndexOrThrow(_cursor, "radarData");
          final int _cursorIndexOfRecentPerformanceJson = CursorUtil.getColumnIndexOrThrow(_cursor, "recentPerformanceJson");
          final int _cursorIndexOfFbrefStatsJson = CursorUtil.getColumnIndexOrThrow(_cursor, "fbrefStatsJson");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final PlayerEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTmId;
            if (_cursor.isNull(_cursorIndexOfTmId)) {
              _tmpTmId = null;
            } else {
              _tmpTmId = _cursor.getString(_cursorIndexOfTmId);
            }
            final String _tmpFbrefSlug;
            if (_cursor.isNull(_cursorIndexOfFbrefSlug)) {
              _tmpFbrefSlug = null;
            } else {
              _tmpFbrefSlug = _cursor.getString(_cursorIndexOfFbrefSlug);
            }
            final String _tmpFbrefId;
            if (_cursor.isNull(_cursorIndexOfFbrefId)) {
              _tmpFbrefId = null;
            } else {
              _tmpFbrefId = _cursor.getString(_cursorIndexOfFbrefId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpClub;
            if (_cursor.isNull(_cursorIndexOfClub)) {
              _tmpClub = null;
            } else {
              _tmpClub = _cursor.getString(_cursorIndexOfClub);
            }
            final Integer _tmpAge;
            if (_cursor.isNull(_cursorIndexOfAge)) {
              _tmpAge = null;
            } else {
              _tmpAge = _cursor.getInt(_cursorIndexOfAge);
            }
            final Double _tmpMarketValue;
            if (_cursor.isNull(_cursorIndexOfMarketValue)) {
              _tmpMarketValue = null;
            } else {
              _tmpMarketValue = _cursor.getDouble(_cursorIndexOfMarketValue);
            }
            final double _tmpTalentScore;
            _tmpTalentScore = _cursor.getDouble(_cursorIndexOfTalentScore);
            final double _tmpHiddenGemScore;
            _tmpHiddenGemScore = _cursor.getDouble(_cursorIndexOfHiddenGemScore);
            final String _tmpPosition;
            if (_cursor.isNull(_cursorIndexOfPosition)) {
              _tmpPosition = null;
            } else {
              _tmpPosition = _cursor.getString(_cursorIndexOfPosition);
            }
            final String _tmpPhotoUrl;
            if (_cursor.isNull(_cursorIndexOfPhotoUrl)) {
              _tmpPhotoUrl = null;
            } else {
              _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            }
            final boolean _tmpIsRetired;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsRetired);
            _tmpIsRetired = _tmp != 0;
            final boolean _tmpIsWatchlisted;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsWatchlisted);
            _tmpIsWatchlisted = _tmp_1 != 0;
            final String _tmpSeason;
            if (_cursor.isNull(_cursorIndexOfSeason)) {
              _tmpSeason = null;
            } else {
              _tmpSeason = _cursor.getString(_cursorIndexOfSeason);
            }
            final Integer _tmpGoals;
            if (_cursor.isNull(_cursorIndexOfGoals)) {
              _tmpGoals = null;
            } else {
              _tmpGoals = _cursor.getInt(_cursorIndexOfGoals);
            }
            final Integer _tmpAssists;
            if (_cursor.isNull(_cursorIndexOfAssists)) {
              _tmpAssists = null;
            } else {
              _tmpAssists = _cursor.getInt(_cursorIndexOfAssists);
            }
            final Double _tmpXG;
            if (_cursor.isNull(_cursorIndexOfXG)) {
              _tmpXG = null;
            } else {
              _tmpXG = _cursor.getDouble(_cursorIndexOfXG);
            }
            final Integer _tmpMinutes;
            if (_cursor.isNull(_cursorIndexOfMinutes)) {
              _tmpMinutes = null;
            } else {
              _tmpMinutes = _cursor.getInt(_cursorIndexOfMinutes);
            }
            final Integer _tmpGoalsConceded;
            if (_cursor.isNull(_cursorIndexOfGoalsConceded)) {
              _tmpGoalsConceded = null;
            } else {
              _tmpGoalsConceded = _cursor.getInt(_cursorIndexOfGoalsConceded);
            }
            final Integer _tmpCleanSheets;
            if (_cursor.isNull(_cursorIndexOfCleanSheets)) {
              _tmpCleanSheets = null;
            } else {
              _tmpCleanSheets = _cursor.getInt(_cursorIndexOfCleanSheets);
            }
            final String _tmpFoot;
            if (_cursor.isNull(_cursorIndexOfFoot)) {
              _tmpFoot = null;
            } else {
              _tmpFoot = _cursor.getString(_cursorIndexOfFoot);
            }
            final String _tmpShirtNumber;
            if (_cursor.isNull(_cursorIndexOfShirtNumber)) {
              _tmpShirtNumber = null;
            } else {
              _tmpShirtNumber = _cursor.getString(_cursorIndexOfShirtNumber);
            }
            final String _tmpCitizenship;
            if (_cursor.isNull(_cursorIndexOfCitizenship)) {
              _tmpCitizenship = null;
            } else {
              _tmpCitizenship = _cursor.getString(_cursorIndexOfCitizenship);
            }
            final String _tmpContractExpires;
            if (_cursor.isNull(_cursorIndexOfContractExpires)) {
              _tmpContractExpires = null;
            } else {
              _tmpContractExpires = _cursor.getString(_cursorIndexOfContractExpires);
            }
            final String _tmpBirthDate;
            if (_cursor.isNull(_cursorIndexOfBirthDate)) {
              _tmpBirthDate = null;
            } else {
              _tmpBirthDate = _cursor.getString(_cursorIndexOfBirthDate);
            }
            final String _tmpSeasonalStats;
            if (_cursor.isNull(_cursorIndexOfSeasonalStats)) {
              _tmpSeasonalStats = null;
            } else {
              _tmpSeasonalStats = _cursor.getString(_cursorIndexOfSeasonalStats);
            }
            final String _tmpDetailedStats;
            if (_cursor.isNull(_cursorIndexOfDetailedStats)) {
              _tmpDetailedStats = null;
            } else {
              _tmpDetailedStats = _cursor.getString(_cursorIndexOfDetailedStats);
            }
            final String _tmpAchievements;
            if (_cursor.isNull(_cursorIndexOfAchievements)) {
              _tmpAchievements = null;
            } else {
              _tmpAchievements = _cursor.getString(_cursorIndexOfAchievements);
            }
            final String _tmpMarketValueHistory;
            if (_cursor.isNull(_cursorIndexOfMarketValueHistory)) {
              _tmpMarketValueHistory = null;
            } else {
              _tmpMarketValueHistory = _cursor.getString(_cursorIndexOfMarketValueHistory);
            }
            final String _tmpTransfers;
            if (_cursor.isNull(_cursorIndexOfTransfers)) {
              _tmpTransfers = null;
            } else {
              _tmpTransfers = _cursor.getString(_cursorIndexOfTransfers);
            }
            final String _tmpInjuries;
            if (_cursor.isNull(_cursorIndexOfInjuries)) {
              _tmpInjuries = null;
            } else {
              _tmpInjuries = _cursor.getString(_cursorIndexOfInjuries);
            }
            final String _tmpRadarData;
            if (_cursor.isNull(_cursorIndexOfRadarData)) {
              _tmpRadarData = null;
            } else {
              _tmpRadarData = _cursor.getString(_cursorIndexOfRadarData);
            }
            final String _tmpRecentPerformanceJson;
            if (_cursor.isNull(_cursorIndexOfRecentPerformanceJson)) {
              _tmpRecentPerformanceJson = null;
            } else {
              _tmpRecentPerformanceJson = _cursor.getString(_cursorIndexOfRecentPerformanceJson);
            }
            final String _tmpFbrefStatsJson;
            if (_cursor.isNull(_cursorIndexOfFbrefStatsJson)) {
              _tmpFbrefStatsJson = null;
            } else {
              _tmpFbrefStatsJson = _cursor.getString(_cursorIndexOfFbrefStatsJson);
            }
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new PlayerEntity(_tmpId,_tmpTmId,_tmpFbrefSlug,_tmpFbrefId,_tmpName,_tmpClub,_tmpAge,_tmpMarketValue,_tmpTalentScore,_tmpHiddenGemScore,_tmpPosition,_tmpPhotoUrl,_tmpIsRetired,_tmpIsWatchlisted,_tmpSeason,_tmpGoals,_tmpAssists,_tmpXG,_tmpMinutes,_tmpGoalsConceded,_tmpCleanSheets,_tmpFoot,_tmpShirtNumber,_tmpCitizenship,_tmpContractExpires,_tmpBirthDate,_tmpSeasonalStats,_tmpDetailedStats,_tmpAchievements,_tmpMarketValueHistory,_tmpTransfers,_tmpInjuries,_tmpRadarData,_tmpRecentPerformanceJson,_tmpFbrefStatsJson,_tmpLastUpdated);
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
  public Object getEnrichmentByTmId(final String tmId,
      final Continuation<? super PlayerEnrichmentEntity> arg1) {
    final String _sql = "SELECT * FROM player_enrichment_cache WHERE tmId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tmId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tmId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayerEnrichmentEntity>() {
      @Override
      @Nullable
      public PlayerEnrichmentEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTmId = CursorUtil.getColumnIndexOrThrow(_cursor, "tmId");
          final int _cursorIndexOfBackendId = CursorUtil.getColumnIndexOrThrow(_cursor, "backendId");
          final int _cursorIndexOfJsonData = CursorUtil.getColumnIndexOrThrow(_cursor, "jsonData");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final PlayerEnrichmentEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpTmId;
            if (_cursor.isNull(_cursorIndexOfTmId)) {
              _tmpTmId = null;
            } else {
              _tmpTmId = _cursor.getString(_cursorIndexOfTmId);
            }
            final long _tmpBackendId;
            _tmpBackendId = _cursor.getLong(_cursorIndexOfBackendId);
            final String _tmpJsonData;
            if (_cursor.isNull(_cursorIndexOfJsonData)) {
              _tmpJsonData = null;
            } else {
              _tmpJsonData = _cursor.getString(_cursorIndexOfJsonData);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new PlayerEnrichmentEntity(_tmpTmId,_tmpBackendId,_tmpJsonData,_tmpRating,_tmpLastUpdated);
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
  public Object getEnrichmentByBackendId(final long id,
      final Continuation<? super PlayerEnrichmentEntity> arg1) {
    final String _sql = "SELECT * FROM player_enrichment_cache WHERE backendId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<PlayerEnrichmentEntity>() {
      @Override
      @Nullable
      public PlayerEnrichmentEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTmId = CursorUtil.getColumnIndexOrThrow(_cursor, "tmId");
          final int _cursorIndexOfBackendId = CursorUtil.getColumnIndexOrThrow(_cursor, "backendId");
          final int _cursorIndexOfJsonData = CursorUtil.getColumnIndexOrThrow(_cursor, "jsonData");
          final int _cursorIndexOfRating = CursorUtil.getColumnIndexOrThrow(_cursor, "rating");
          final int _cursorIndexOfLastUpdated = CursorUtil.getColumnIndexOrThrow(_cursor, "lastUpdated");
          final PlayerEnrichmentEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpTmId;
            if (_cursor.isNull(_cursorIndexOfTmId)) {
              _tmpTmId = null;
            } else {
              _tmpTmId = _cursor.getString(_cursorIndexOfTmId);
            }
            final long _tmpBackendId;
            _tmpBackendId = _cursor.getLong(_cursorIndexOfBackendId);
            final String _tmpJsonData;
            if (_cursor.isNull(_cursorIndexOfJsonData)) {
              _tmpJsonData = null;
            } else {
              _tmpJsonData = _cursor.getString(_cursorIndexOfJsonData);
            }
            final float _tmpRating;
            _tmpRating = _cursor.getFloat(_cursorIndexOfRating);
            final long _tmpLastUpdated;
            _tmpLastUpdated = _cursor.getLong(_cursorIndexOfLastUpdated);
            _result = new PlayerEnrichmentEntity(_tmpTmId,_tmpBackendId,_tmpJsonData,_tmpRating,_tmpLastUpdated);
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
