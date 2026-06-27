package com.scoutapp.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bP\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\'\u0018\u00010$\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u00a2\u0006\u0002\u0010*J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010V\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0010\u0010W\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003\u00a2\u0006\u0002\u0010:J\u0010\u0010[\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003\u00a2\u0006\u0002\u0010:J\u0010\u0010\\\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010]\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010^\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u000b\u0010_\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0010\u0010a\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010b\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010c\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010d\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010e\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u000b\u0010f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003\u00a2\u0006\u0002\u0010:J\u0011\u0010i\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u00c6\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010k\u001a\n\u0012\u0004\u0012\u00020\'\u0018\u00010$H\u00c6\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010)H\u00c6\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010q\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010,J\u0010\u0010r\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u008c\u0003\u0010s\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\'\u0018\u00010$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)H\u00c6\u0001\u00a2\u0006\u0002\u0010tJ\u0013\u0010u\u001a\u00020\u00152\b\u0010v\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010w\u001a\u00020\fH\u00d6\u0001J\t\u0010x\u001a\u00020\u0005H\u00d6\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b.\u0010,R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b/\u0010,R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b3\u0010,R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b4\u0010,R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\n\n\u0002\u0010;\u001a\u0004\b\u0014\u0010:R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\n\n\u0002\u0010;\u001a\u0004\b\u0016\u0010:R\u0015\u0010\"\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\n\n\u0002\u0010;\u001a\u0004\b\"\u0010:R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b<\u0010,R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00101R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b>\u00106R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\b@\u0010,R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0013\u0010!\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00101R\u0013\u0010 \u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00101R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\bD\u0010,R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010-\u001a\u0004\bE\u0010,R\u0018\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020\'\u0018\u00010$8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00101R\u0013\u0010K\u001a\u0004\u0018\u00010%8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010IR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\bO\u00106R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u00101R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u00101R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\bR\u00106R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\bS\u00106\u00a8\u0006y"}, d2 = {"Lcom/scoutapp/data/api/PlayerResponse;", "", "id", "", "transfermarktId", "", "tmId", "fbrefSlug", "name", "club", "league", "age", "", "marketValue", "", "marketValueDisplay", "talentScore", "hiddenGemScore", "season", "minutes", "isConsigliato", "", "isHiddenGem", "goals", "assists", "xG", "xA", "keyPasses", "progressivePasses", "progressiveCarries", "goalsConceded", "cleanSheets", "position", "photoUrl", "isRetired", "statistics", "", "Lcom/scoutapp/data/api/SeasonStats;", "recentMatches", "Lcom/scoutapp/data/api/RecentMatch;", "radar", "Lcom/scoutapp/data/api/RadarResponse;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/scoutapp/data/api/RadarResponse;)V", "getAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAssists", "getCleanSheets", "getClub", "()Ljava/lang/String;", "getFbrefSlug", "getGoals", "getGoalsConceded", "getHiddenGemScore", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getId", "()J", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getKeyPasses", "getLeague", "getMarketValue", "getMarketValueDisplay", "getMinutes", "getName", "getPhotoUrl", "getPosition", "getProgressiveCarries", "getProgressivePasses", "getRadar", "()Lcom/scoutapp/data/api/RadarResponse;", "getRecentMatches", "()Ljava/util/List;", "getSeason", "seasonStats", "getSeasonStats", "()Lcom/scoutapp/data/api/SeasonStats;", "getStatistics", "getTalentScore", "getTmId", "getTransfermarktId", "getXA", "getXG", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/scoutapp/data/api/RadarResponse;)Lcom/scoutapp/data/api/PlayerResponse;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class PlayerResponse {
    private final long id = 0L;
    @com.google.gson.annotations.SerializedName(value = "transfermarktId")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String transfermarktId = null;
    @com.google.gson.annotations.SerializedName(value = "tmId")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String tmId = null;
    @com.google.gson.annotations.SerializedName(value = "fbrefSlug")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String fbrefSlug = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String club = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String league = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer age = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double marketValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String marketValueDisplay = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double talentScore = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double hiddenGemScore = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String season = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer minutes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isConsigliato = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isHiddenGem = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer goals = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer assists = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double xG = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double xA = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer keyPasses = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer progressivePasses = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer progressiveCarries = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer goalsConceded = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer cleanSheets = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String position = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String photoUrl = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isRetired = null;
    @com.google.gson.annotations.SerializedName(value = "statistics")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.scoutapp.data.api.SeasonStats> statistics = null;
    @com.google.gson.annotations.SerializedName(value = "recentMatches")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.scoutapp.data.api.RecentMatch> recentMatches = null;
    @com.google.gson.annotations.SerializedName(value = "radar")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.api.RadarResponse radar = null;
    
    public PlayerResponse(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String transfermarktId, @org.jetbrains.annotations.Nullable()
    java.lang.String tmId, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefSlug, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String club, @org.jetbrains.annotations.Nullable()
    java.lang.String league, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.Double marketValue, @org.jetbrains.annotations.Nullable()
    java.lang.String marketValueDisplay, @org.jetbrains.annotations.Nullable()
    java.lang.Double talentScore, @org.jetbrains.annotations.Nullable()
    java.lang.Double hiddenGemScore, @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isConsigliato, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isHiddenGem, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Double xG, @org.jetbrains.annotations.Nullable()
    java.lang.Double xA, @org.jetbrains.annotations.Nullable()
    java.lang.Integer keyPasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressivePasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressiveCarries, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goalsConceded, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cleanSheets, @org.jetbrains.annotations.Nullable()
    java.lang.String position, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRetired, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.api.SeasonStats> statistics, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.api.RecentMatch> recentMatches, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.RadarResponse radar) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransfermarktId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTmId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFbrefSlug() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getClub() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLeague() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAge() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getMarketValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMarketValueDisplay() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getTalentScore() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getHiddenGemScore() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSeason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMinutes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isConsigliato() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isHiddenGem() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGoals() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAssists() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getXG() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getXA() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getKeyPasses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getProgressivePasses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getProgressiveCarries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGoalsConceded() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCleanSheets() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhotoUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isRetired() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.api.SeasonStats> getStatistics() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.api.RecentMatch> getRecentMatches() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.RadarResponse getRadar() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.SeasonStats getSeasonStats() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component20() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component23() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component24() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component25() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.api.SeasonStats> component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.api.RecentMatch> component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.RadarResponse component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.PlayerResponse copy(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String transfermarktId, @org.jetbrains.annotations.Nullable()
    java.lang.String tmId, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefSlug, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String club, @org.jetbrains.annotations.Nullable()
    java.lang.String league, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.Double marketValue, @org.jetbrains.annotations.Nullable()
    java.lang.String marketValueDisplay, @org.jetbrains.annotations.Nullable()
    java.lang.Double talentScore, @org.jetbrains.annotations.Nullable()
    java.lang.Double hiddenGemScore, @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isConsigliato, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isHiddenGem, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Double xG, @org.jetbrains.annotations.Nullable()
    java.lang.Double xA, @org.jetbrains.annotations.Nullable()
    java.lang.Integer keyPasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressivePasses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progressiveCarries, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goalsConceded, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cleanSheets, @org.jetbrains.annotations.Nullable()
    java.lang.String position, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRetired, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.api.SeasonStats> statistics, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.api.RecentMatch> recentMatches, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.RadarResponse radar) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}