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

  private final SharedSQLiteStatement __preparedStmtOfUpdateWatchlistStatus;

  public PlayerDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPlayerEntity = new EntityInsertionAdapter<PlayerEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `cached_players` (`id`,`name`,`club`,`age`,`marketValue`,`talentScore`,`hiddenGemScore`,`position`,`isWatchlisted`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final PlayerEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getClub() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getClub());
        }
        if (entity.getAge() == null) {
          statement.bindNull(4);
        } else {
          statement.bindLong(4, entity.getAge());
        }
        if (entity.getMarketValue() == null) {
          statement.bindNull(5);
        } else {
          statement.bindDouble(5, entity.getMarketValue());
        }
        statement.bindDouble(6, entity.getTalentScore());
        statement.bindDouble(7, entity.getHiddenGemScore());
        if (entity.getPosition() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getPosition());
        }
        final int _tmp = entity.isWatchlisted() ? 1 : 0;
        statement.bindLong(9, _tmp);
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
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClub = CursorUtil.getColumnIndexOrThrow(_cursor, "club");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfMarketValue = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValue");
          final int _cursorIndexOfTalentScore = CursorUtil.getColumnIndexOrThrow(_cursor, "talentScore");
          final int _cursorIndexOfHiddenGemScore = CursorUtil.getColumnIndexOrThrow(_cursor, "hiddenGemScore");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfIsWatchlisted = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatchlisted");
          final List<PlayerEntity> _result = new ArrayList<PlayerEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PlayerEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
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
            final boolean _tmpIsWatchlisted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsWatchlisted);
            _tmpIsWatchlisted = _tmp != 0;
            _item = new PlayerEntity(_tmpId,_tmpName,_tmpClub,_tmpAge,_tmpMarketValue,_tmpTalentScore,_tmpHiddenGemScore,_tmpPosition,_tmpIsWatchlisted);
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
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfClub = CursorUtil.getColumnIndexOrThrow(_cursor, "club");
          final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
          final int _cursorIndexOfMarketValue = CursorUtil.getColumnIndexOrThrow(_cursor, "marketValue");
          final int _cursorIndexOfTalentScore = CursorUtil.getColumnIndexOrThrow(_cursor, "talentScore");
          final int _cursorIndexOfHiddenGemScore = CursorUtil.getColumnIndexOrThrow(_cursor, "hiddenGemScore");
          final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "position");
          final int _cursorIndexOfIsWatchlisted = CursorUtil.getColumnIndexOrThrow(_cursor, "isWatchlisted");
          final PlayerEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
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
            final boolean _tmpIsWatchlisted;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsWatchlisted);
            _tmpIsWatchlisted = _tmp != 0;
            _result = new PlayerEntity(_tmpId,_tmpName,_tmpClub,_tmpAge,_tmpMarketValue,_tmpTalentScore,_tmpHiddenGemScore,_tmpPosition,_tmpIsWatchlisted);
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
