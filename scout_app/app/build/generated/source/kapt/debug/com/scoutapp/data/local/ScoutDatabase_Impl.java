package com.scoutapp.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ScoutDatabase_Impl extends ScoutDatabase {
  private volatile PlayerDao _playerDao;

  private volatile MatchDao _matchDao;

  private volatile LeagueDao _leagueDao;

  private volatile TeamDao _teamDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(21) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `cached_players` (`id` INTEGER NOT NULL, `tmId` TEXT, `fbrefSlug` TEXT, `fbrefId` TEXT, `name` TEXT NOT NULL, `club` TEXT, `league` TEXT, `age` INTEGER, `marketValue` REAL, `talentScore` REAL NOT NULL, `hiddenGemScore` REAL NOT NULL, `position` TEXT, `photoUrl` TEXT, `isRetired` INTEGER NOT NULL, `isWatchlisted` INTEGER NOT NULL, `season` TEXT, `goals` INTEGER, `assists` INTEGER, `xG` REAL, `minutes` INTEGER, `matchesPlayed` INTEGER, `appearances` INTEGER, `goalsConceded` INTEGER, `cleanSheets` INTEGER, `foot` TEXT, `shirtNumber` TEXT, `citizenship` TEXT, `contractExpires` TEXT, `birthDate` TEXT, `seasonalStats` TEXT, `detailedStats` TEXT, `achievements` TEXT, `marketValueHistory` TEXT, `transfers` TEXT, `injuries` TEXT, `radarData` TEXT, `recentPerformanceJson` TEXT, `performanceGameJson` TEXT, `fbrefStatsJson` TEXT, `competitionStatsJson` TEXT, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `player_enrichment_cache` (`tmId` TEXT NOT NULL, `backendId` INTEGER NOT NULL, `jsonData` TEXT NOT NULL, `rating` REAL NOT NULL, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`tmId`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `matches` (`id` INTEGER NOT NULL, `competitionCode` TEXT NOT NULL, `season` TEXT NOT NULL, `matchDate` INTEGER NOT NULL, `homeClubId` INTEGER NOT NULL, `awayClubId` INTEGER NOT NULL, `homeScore` INTEGER NOT NULL, `awayScore` INTEGER NOT NULL, `venue` TEXT, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `player_match_performance` (`playerId` INTEGER NOT NULL, `matchId` INTEGER NOT NULL, `participationState` TEXT NOT NULL, `minutesPlayed` INTEGER NOT NULL, `goals` INTEGER NOT NULL, `assists` INTEGER NOT NULL, `yellowCard` INTEGER NOT NULL, `shots` INTEGER NOT NULL, `passesCompleted` INTEGER NOT NULL, `passesTotal` INTEGER NOT NULL, `isStarting` INTEGER NOT NULL, PRIMARY KEY(`playerId`, `matchId`), FOREIGN KEY(`matchId`) REFERENCES `matches`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_player_match_performance_matchId` ON `player_match_performance` (`matchId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `leagues` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `country` TEXT, `logoUrl` TEXT, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `teams` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `leagueId` TEXT NOT NULL, `logoUrl` TEXT, `lastUpdated` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '965a5f2b9f4d6b4b8a247225a7f4bc24')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `cached_players`");
        db.execSQL("DROP TABLE IF EXISTS `player_enrichment_cache`");
        db.execSQL("DROP TABLE IF EXISTS `matches`");
        db.execSQL("DROP TABLE IF EXISTS `player_match_performance`");
        db.execSQL("DROP TABLE IF EXISTS `leagues`");
        db.execSQL("DROP TABLE IF EXISTS `teams`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsCachedPlayers = new HashMap<String, TableInfo.Column>(41);
        _columnsCachedPlayers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("tmId", new TableInfo.Column("tmId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("fbrefSlug", new TableInfo.Column("fbrefSlug", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("fbrefId", new TableInfo.Column("fbrefId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("club", new TableInfo.Column("club", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("league", new TableInfo.Column("league", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("age", new TableInfo.Column("age", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("marketValue", new TableInfo.Column("marketValue", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("talentScore", new TableInfo.Column("talentScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("hiddenGemScore", new TableInfo.Column("hiddenGemScore", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("position", new TableInfo.Column("position", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("isRetired", new TableInfo.Column("isRetired", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("isWatchlisted", new TableInfo.Column("isWatchlisted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("season", new TableInfo.Column("season", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("goals", new TableInfo.Column("goals", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("assists", new TableInfo.Column("assists", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("xG", new TableInfo.Column("xG", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("minutes", new TableInfo.Column("minutes", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("matchesPlayed", new TableInfo.Column("matchesPlayed", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("appearances", new TableInfo.Column("appearances", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("goalsConceded", new TableInfo.Column("goalsConceded", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("cleanSheets", new TableInfo.Column("cleanSheets", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("foot", new TableInfo.Column("foot", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("shirtNumber", new TableInfo.Column("shirtNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("citizenship", new TableInfo.Column("citizenship", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("contractExpires", new TableInfo.Column("contractExpires", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("birthDate", new TableInfo.Column("birthDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("seasonalStats", new TableInfo.Column("seasonalStats", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("detailedStats", new TableInfo.Column("detailedStats", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("achievements", new TableInfo.Column("achievements", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("marketValueHistory", new TableInfo.Column("marketValueHistory", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("transfers", new TableInfo.Column("transfers", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("injuries", new TableInfo.Column("injuries", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("radarData", new TableInfo.Column("radarData", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("recentPerformanceJson", new TableInfo.Column("recentPerformanceJson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("performanceGameJson", new TableInfo.Column("performanceGameJson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("fbrefStatsJson", new TableInfo.Column("fbrefStatsJson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("competitionStatsJson", new TableInfo.Column("competitionStatsJson", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCachedPlayers.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCachedPlayers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCachedPlayers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCachedPlayers = new TableInfo("cached_players", _columnsCachedPlayers, _foreignKeysCachedPlayers, _indicesCachedPlayers);
        final TableInfo _existingCachedPlayers = TableInfo.read(db, "cached_players");
        if (!_infoCachedPlayers.equals(_existingCachedPlayers)) {
          return new RoomOpenHelper.ValidationResult(false, "cached_players(com.scoutapp.data.local.PlayerEntity).\n"
                  + " Expected:\n" + _infoCachedPlayers + "\n"
                  + " Found:\n" + _existingCachedPlayers);
        }
        final HashMap<String, TableInfo.Column> _columnsPlayerEnrichmentCache = new HashMap<String, TableInfo.Column>(5);
        _columnsPlayerEnrichmentCache.put("tmId", new TableInfo.Column("tmId", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerEnrichmentCache.put("backendId", new TableInfo.Column("backendId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerEnrichmentCache.put("jsonData", new TableInfo.Column("jsonData", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerEnrichmentCache.put("rating", new TableInfo.Column("rating", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerEnrichmentCache.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlayerEnrichmentCache = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPlayerEnrichmentCache = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPlayerEnrichmentCache = new TableInfo("player_enrichment_cache", _columnsPlayerEnrichmentCache, _foreignKeysPlayerEnrichmentCache, _indicesPlayerEnrichmentCache);
        final TableInfo _existingPlayerEnrichmentCache = TableInfo.read(db, "player_enrichment_cache");
        if (!_infoPlayerEnrichmentCache.equals(_existingPlayerEnrichmentCache)) {
          return new RoomOpenHelper.ValidationResult(false, "player_enrichment_cache(com.scoutapp.data.local.PlayerEnrichmentEntity).\n"
                  + " Expected:\n" + _infoPlayerEnrichmentCache + "\n"
                  + " Found:\n" + _existingPlayerEnrichmentCache);
        }
        final HashMap<String, TableInfo.Column> _columnsMatches = new HashMap<String, TableInfo.Column>(9);
        _columnsMatches.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("competitionCode", new TableInfo.Column("competitionCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("season", new TableInfo.Column("season", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("matchDate", new TableInfo.Column("matchDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("homeClubId", new TableInfo.Column("homeClubId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("awayClubId", new TableInfo.Column("awayClubId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("homeScore", new TableInfo.Column("homeScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("awayScore", new TableInfo.Column("awayScore", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMatches.put("venue", new TableInfo.Column("venue", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMatches = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMatches = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMatches = new TableInfo("matches", _columnsMatches, _foreignKeysMatches, _indicesMatches);
        final TableInfo _existingMatches = TableInfo.read(db, "matches");
        if (!_infoMatches.equals(_existingMatches)) {
          return new RoomOpenHelper.ValidationResult(false, "matches(com.scoutapp.data.local.MatchEntity).\n"
                  + " Expected:\n" + _infoMatches + "\n"
                  + " Found:\n" + _existingMatches);
        }
        final HashMap<String, TableInfo.Column> _columnsPlayerMatchPerformance = new HashMap<String, TableInfo.Column>(11);
        _columnsPlayerMatchPerformance.put("playerId", new TableInfo.Column("playerId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("matchId", new TableInfo.Column("matchId", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("participationState", new TableInfo.Column("participationState", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("minutesPlayed", new TableInfo.Column("minutesPlayed", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("goals", new TableInfo.Column("goals", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("assists", new TableInfo.Column("assists", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("yellowCard", new TableInfo.Column("yellowCard", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("shots", new TableInfo.Column("shots", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("passesCompleted", new TableInfo.Column("passesCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("passesTotal", new TableInfo.Column("passesTotal", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPlayerMatchPerformance.put("isStarting", new TableInfo.Column("isStarting", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPlayerMatchPerformance = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPlayerMatchPerformance.add(new TableInfo.ForeignKey("matches", "CASCADE", "NO ACTION", Arrays.asList("matchId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPlayerMatchPerformance = new HashSet<TableInfo.Index>(1);
        _indicesPlayerMatchPerformance.add(new TableInfo.Index("index_player_match_performance_matchId", false, Arrays.asList("matchId"), Arrays.asList("ASC")));
        final TableInfo _infoPlayerMatchPerformance = new TableInfo("player_match_performance", _columnsPlayerMatchPerformance, _foreignKeysPlayerMatchPerformance, _indicesPlayerMatchPerformance);
        final TableInfo _existingPlayerMatchPerformance = TableInfo.read(db, "player_match_performance");
        if (!_infoPlayerMatchPerformance.equals(_existingPlayerMatchPerformance)) {
          return new RoomOpenHelper.ValidationResult(false, "player_match_performance(com.scoutapp.data.local.MatchPerformanceEntity).\n"
                  + " Expected:\n" + _infoPlayerMatchPerformance + "\n"
                  + " Found:\n" + _existingPlayerMatchPerformance);
        }
        final HashMap<String, TableInfo.Column> _columnsLeagues = new HashMap<String, TableInfo.Column>(5);
        _columnsLeagues.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeagues.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeagues.put("country", new TableInfo.Column("country", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeagues.put("logoUrl", new TableInfo.Column("logoUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeagues.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLeagues = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLeagues = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLeagues = new TableInfo("leagues", _columnsLeagues, _foreignKeysLeagues, _indicesLeagues);
        final TableInfo _existingLeagues = TableInfo.read(db, "leagues");
        if (!_infoLeagues.equals(_existingLeagues)) {
          return new RoomOpenHelper.ValidationResult(false, "leagues(com.scoutapp.data.local.LeagueEntity).\n"
                  + " Expected:\n" + _infoLeagues + "\n"
                  + " Found:\n" + _existingLeagues);
        }
        final HashMap<String, TableInfo.Column> _columnsTeams = new HashMap<String, TableInfo.Column>(5);
        _columnsTeams.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("leagueId", new TableInfo.Column("leagueId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("logoUrl", new TableInfo.Column("logoUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTeams.put("lastUpdated", new TableInfo.Column("lastUpdated", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTeams = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTeams = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTeams = new TableInfo("teams", _columnsTeams, _foreignKeysTeams, _indicesTeams);
        final TableInfo _existingTeams = TableInfo.read(db, "teams");
        if (!_infoTeams.equals(_existingTeams)) {
          return new RoomOpenHelper.ValidationResult(false, "teams(com.scoutapp.data.local.TeamEntity).\n"
                  + " Expected:\n" + _infoTeams + "\n"
                  + " Found:\n" + _existingTeams);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "965a5f2b9f4d6b4b8a247225a7f4bc24", "a694321018e8478302d28a898fb3c126");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "cached_players","player_enrichment_cache","matches","player_match_performance","leagues","teams");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `cached_players`");
      _db.execSQL("DELETE FROM `player_enrichment_cache`");
      _db.execSQL("DELETE FROM `matches`");
      _db.execSQL("DELETE FROM `player_match_performance`");
      _db.execSQL("DELETE FROM `leagues`");
      _db.execSQL("DELETE FROM `teams`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(PlayerDao.class, PlayerDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MatchDao.class, MatchDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LeagueDao.class, LeagueDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TeamDao.class, TeamDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public PlayerDao playerDao() {
    if (_playerDao != null) {
      return _playerDao;
    } else {
      synchronized(this) {
        if(_playerDao == null) {
          _playerDao = new PlayerDao_Impl(this);
        }
        return _playerDao;
      }
    }
  }

  @Override
  public MatchDao matchDao() {
    if (_matchDao != null) {
      return _matchDao;
    } else {
      synchronized(this) {
        if(_matchDao == null) {
          _matchDao = new MatchDao_Impl(this);
        }
        return _matchDao;
      }
    }
  }

  @Override
  public LeagueDao leagueDao() {
    if (_leagueDao != null) {
      return _leagueDao;
    } else {
      synchronized(this) {
        if(_leagueDao == null) {
          _leagueDao = new LeagueDao_Impl(this);
        }
        return _leagueDao;
      }
    }
  }

  @Override
  public TeamDao teamDao() {
    if (_teamDao != null) {
      return _teamDao;
    } else {
      synchronized(this) {
        if(_teamDao == null) {
          _teamDao = new TeamDao_Impl(this);
        }
        return _teamDao;
      }
    }
  }
}
