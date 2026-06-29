package com.scoutapp.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\bb\b\u0086\b\u0018\u00002\u00020\u0001B\u00dd\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010$J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010I\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010K\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010L\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010M\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010N\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010O\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010P\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010T\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010U\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010V\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010W\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010X\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010[\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010\\\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0010\u0010]\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u00106J\u0010\u0010`\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010a\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010b\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010c\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u0010\u0010d\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010&J\u00f6\u0002\u0010e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010fJ\u0013\u0010g\u001a\u00020\t2\b\u0010h\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010i\u001a\u00020\u0007H\u00d6\u0001J\t\u0010j\u001a\u00020\u0003H\u00d6\u0001R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b%\u0010&R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b(\u0010&R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b)\u0010&R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b*\u0010&R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b+\u0010&R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b,\u0010&R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b-\u0010&R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b2\u0010&R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b3\u0010&R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b4\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b5\u0010&R\u0015\u0010\"\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b\"\u00106R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b\b\u00106R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b8\u0010&R\u0015\u0010 \u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b9\u0010&R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b:\u0010&R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b;\u0010&R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00101R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b=\u0010&R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b>\u0010&R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b?\u0010&R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\b@\u0010&R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\bA\u0010&R\u0015\u0010!\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\bB\u0010&R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\bC\u0010&R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\bD\u0010&R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\bE\u0010&R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\'\u001a\u0004\bF\u0010&\u00a8\u0006k"}, d2 = {"Lcom/scoutapp/data/api/GameStats;", "", "gameId", "", "date", "Lcom/scoutapp/data/api/GameDate;", "minutes", "", "isStarting", "", "goals", "assists", "yellow", "secondYellow", "red", "tackles", "tacklesWon", "tacklesLost", "groundDuels", "groundDuelsWon", "groundDuelsLost", "aerialDuels", "aerialDuelsWon", "aerialDuelsLost", "passes", "passesReached", "passesFailed", "crosses", "crossesReached", "crossesFailed", "longBalls", "longBallsReached", "longBallsFailed", "shirtNumber", "isCaptain", "participationState", "(Ljava/lang/String;Lcom/scoutapp/data/api/GameDate;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getAerialDuels", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAerialDuelsLost", "getAerialDuelsWon", "getAssists", "getCrosses", "getCrossesFailed", "getCrossesReached", "getDate", "()Lcom/scoutapp/data/api/GameDate;", "getGameId", "()Ljava/lang/String;", "getGoals", "getGroundDuels", "getGroundDuelsLost", "getGroundDuelsWon", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLongBalls", "getLongBallsFailed", "getLongBallsReached", "getMinutes", "getParticipationState", "getPasses", "getPassesFailed", "getPassesReached", "getRed", "getSecondYellow", "getShirtNumber", "getTackles", "getTacklesLost", "getTacklesWon", "getYellow", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/scoutapp/data/api/GameDate;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/scoutapp/data/api/GameStats;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class GameStats {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String gameId = null;
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.api.GameDate date = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer minutes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isStarting = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer goals = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer assists = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer yellow = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer secondYellow = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer red = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer tackles = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer tacklesWon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer tacklesLost = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer groundDuels = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer groundDuelsWon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer groundDuelsLost = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer aerialDuels = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer aerialDuelsWon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer aerialDuelsLost = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer passes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer passesReached = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer passesFailed = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer crosses = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer crossesReached = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer crossesFailed = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer longBalls = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer longBallsReached = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer longBallsFailed = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer shirtNumber = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isCaptain = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String participationState = null;
    
    public GameStats(@org.jetbrains.annotations.Nullable()
    java.lang.String gameId, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.GameDate date, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isStarting, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Integer yellow, @org.jetbrains.annotations.Nullable()
    java.lang.Integer secondYellow, @org.jetbrains.annotations.Nullable()
    java.lang.Integer red, @org.jetbrains.annotations.Nullable()
    java.lang.Integer tackles, @org.jetbrains.annotations.Nullable()
    java.lang.Integer tacklesWon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer tacklesLost, @org.jetbrains.annotations.Nullable()
    java.lang.Integer groundDuels, @org.jetbrains.annotations.Nullable()
    java.lang.Integer groundDuelsWon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer groundDuelsLost, @org.jetbrains.annotations.Nullable()
    java.lang.Integer aerialDuels, @org.jetbrains.annotations.Nullable()
    java.lang.Integer aerialDuelsWon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer aerialDuelsLost, @org.jetbrains.annotations.Nullable()
    java.lang.Integer passes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer passesReached, @org.jetbrains.annotations.Nullable()
    java.lang.Integer passesFailed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crosses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crossesReached, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crossesFailed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer longBalls, @org.jetbrains.annotations.Nullable()
    java.lang.Integer longBallsReached, @org.jetbrains.annotations.Nullable()
    java.lang.Integer longBallsFailed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer shirtNumber, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isCaptain, @org.jetbrains.annotations.Nullable()
    java.lang.String participationState) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGameId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.GameDate getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMinutes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isStarting() {
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
    public final java.lang.Integer getYellow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSecondYellow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTackles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTacklesWon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getTacklesLost() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGroundDuels() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGroundDuelsWon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGroundDuelsLost() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAerialDuels() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAerialDuelsWon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAerialDuelsLost() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPasses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPassesReached() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getPassesFailed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCrosses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCrossesReached() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getCrossesFailed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLongBalls() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLongBallsReached() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLongBallsFailed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getShirtNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isCaptain() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getParticipationState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component16() {
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
    public final java.lang.Integer component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.api.GameDate component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component20() {
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
    public final java.lang.Integer component26() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component27() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.api.GameStats copy(@org.jetbrains.annotations.Nullable()
    java.lang.String gameId, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.api.GameDate date, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isStarting, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Integer yellow, @org.jetbrains.annotations.Nullable()
    java.lang.Integer secondYellow, @org.jetbrains.annotations.Nullable()
    java.lang.Integer red, @org.jetbrains.annotations.Nullable()
    java.lang.Integer tackles, @org.jetbrains.annotations.Nullable()
    java.lang.Integer tacklesWon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer tacklesLost, @org.jetbrains.annotations.Nullable()
    java.lang.Integer groundDuels, @org.jetbrains.annotations.Nullable()
    java.lang.Integer groundDuelsWon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer groundDuelsLost, @org.jetbrains.annotations.Nullable()
    java.lang.Integer aerialDuels, @org.jetbrains.annotations.Nullable()
    java.lang.Integer aerialDuelsWon, @org.jetbrains.annotations.Nullable()
    java.lang.Integer aerialDuelsLost, @org.jetbrains.annotations.Nullable()
    java.lang.Integer passes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer passesReached, @org.jetbrains.annotations.Nullable()
    java.lang.Integer passesFailed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crosses, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crossesReached, @org.jetbrains.annotations.Nullable()
    java.lang.Integer crossesFailed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer longBalls, @org.jetbrains.annotations.Nullable()
    java.lang.Integer longBallsReached, @org.jetbrains.annotations.Nullable()
    java.lang.Integer longBallsFailed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer shirtNumber, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isCaptain, @org.jetbrains.annotations.Nullable()
    java.lang.String participationState) {
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