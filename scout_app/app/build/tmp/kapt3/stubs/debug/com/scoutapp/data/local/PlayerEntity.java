package com.scoutapp.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b{\b\u0087\b\u0018\u00002\u00020\u0001B\u00d7\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u00a2\u0006\u0002\u00100J\t\u0010`\u001a\u00020\u0003H\u00c6\u0003J\t\u0010a\u001a\u00020\u000eH\u00c6\u0003J\t\u0010b\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010e\u001a\u00020\u0014H\u00c6\u0003J\t\u0010f\u001a\u00020\u0014H\u00c6\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010h\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010i\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010j\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010NJ\u000b\u0010k\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010l\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010m\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010n\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010o\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0010\u0010p\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u000b\u0010q\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u007f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005H\u00c6\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u00104J\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010NJ\u00ee\u0003\u0010\u0089\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\'\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010/\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0003\u0010\u008a\u0001J\u0015\u0010\u008b\u0001\u001a\u00020\u00142\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u008d\u0001\u001a\u00020\fH\u00d6\u0001J\n\u0010\u008e\u0001\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010&\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\b6\u00104R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\b7\u00104R\u0013\u0010#\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00102R\u0013\u0010!\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\b:\u00104R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0013\u0010.\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00102R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00102R\u0013\u0010%\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u00102R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00102R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0013\u0010-\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00102R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u00102R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\bC\u00104R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\bD\u00104R\u0011\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010)\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u00102R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010JR\u0011\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010JR\u0011\u0010/\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u0010HR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00102R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u0010O\u001a\u0004\bM\u0010NR\u0013\u0010\'\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u00102R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\bQ\u00104R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u00105\u001a\u0004\bR\u00104R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u00102R\u0013\u0010,\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u00102R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u00102R\u0013\u0010*\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u00102R\u0013\u0010+\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u00102R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u00102R\u0013\u0010$\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u00102R\u0013\u0010 \u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u00102R\u0011\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u0010FR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u00102R\u0013\u0010(\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b^\u00102R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u0010O\u001a\u0004\b_\u0010N\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/scoutapp/data/local/PlayerEntity;", "", "id", "", "tmId", "", "fbrefSlug", "fbrefId", "name", "club", "league", "age", "", "marketValue", "", "talentScore", "hiddenGemScore", "position", "photoUrl", "isRetired", "", "isWatchlisted", "season", "goals", "assists", "xG", "minutes", "matchesPlayed", "appearances", "goalsConceded", "cleanSheets", "foot", "shirtNumber", "citizenship", "contractExpires", "birthDate", "seasonalStats", "detailedStats", "achievements", "marketValueHistory", "transfers", "injuries", "radarData", "recentPerformanceJson", "performanceGameJson", "fbrefStatsJson", "competitionStatsJson", "lastUpdated", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;DDLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAchievements", "()Ljava/lang/String;", "getAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAppearances", "getAssists", "getBirthDate", "getCitizenship", "getCleanSheets", "getClub", "getCompetitionStatsJson", "getContractExpires", "getDetailedStats", "getFbrefId", "getFbrefSlug", "getFbrefStatsJson", "getFoot", "getGoals", "getGoalsConceded", "getHiddenGemScore", "()D", "getId", "()J", "getInjuries", "()Z", "getLastUpdated", "getLeague", "getMarketValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMarketValueHistory", "getMatchesPlayed", "getMinutes", "getName", "getPerformanceGameJson", "getPhotoUrl", "getPosition", "getRadarData", "getRecentPerformanceJson", "getSeason", "getSeasonalStats", "getShirtNumber", "getTalentScore", "getTmId", "getTransfers", "getXG", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;DDLjava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/scoutapp/data/local/PlayerEntity;", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "cached_players")
public final class PlayerEntity {
    @androidx.room.PrimaryKey()
    private final long id = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String tmId = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String fbrefSlug = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String fbrefId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String club = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String league = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer age = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double marketValue = null;
    private final double talentScore = 0.0;
    private final double hiddenGemScore = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String position = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String photoUrl = null;
    private final boolean isRetired = false;
    private final boolean isWatchlisted = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String season = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer goals = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer assists = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double xG = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer minutes = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer matchesPlayed = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer appearances = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer goalsConceded = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer cleanSheets = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String foot = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String shirtNumber = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String citizenship = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String contractExpires = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String birthDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String seasonalStats = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String detailedStats = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String achievements = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String marketValueHistory = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String transfers = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String injuries = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String radarData = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String recentPerformanceJson = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String performanceGameJson = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String fbrefStatsJson = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String competitionStatsJson = null;
    private final long lastUpdated = 0L;
    
    public PlayerEntity(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String tmId, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefSlug, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String club, @org.jetbrains.annotations.Nullable()
    java.lang.String league, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.Double marketValue, double talentScore, double hiddenGemScore, @org.jetbrains.annotations.Nullable()
    java.lang.String position, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, boolean isRetired, boolean isWatchlisted, @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Double xG, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer matchesPlayed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer appearances, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goalsConceded, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cleanSheets, @org.jetbrains.annotations.Nullable()
    java.lang.String foot, @org.jetbrains.annotations.Nullable()
    java.lang.String shirtNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String citizenship, @org.jetbrains.annotations.Nullable()
    java.lang.String contractExpires, @org.jetbrains.annotations.Nullable()
    java.lang.String birthDate, @org.jetbrains.annotations.Nullable()
    java.lang.String seasonalStats, @org.jetbrains.annotations.Nullable()
    java.lang.String detailedStats, @org.jetbrains.annotations.Nullable()
    java.lang.String achievements, @org.jetbrains.annotations.Nullable()
    java.lang.String marketValueHistory, @org.jetbrains.annotations.Nullable()
    java.lang.String transfers, @org.jetbrains.annotations.Nullable()
    java.lang.String injuries, @org.jetbrains.annotations.Nullable()
    java.lang.String radarData, @org.jetbrains.annotations.Nullable()
    java.lang.String recentPerformanceJson, @org.jetbrains.annotations.Nullable()
    java.lang.String performanceGameJson, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefStatsJson, @org.jetbrains.annotations.Nullable()
    java.lang.String competitionStatsJson, long lastUpdated) {
        super();
    }
    
    public final long getId() {
        return 0L;
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
    public final java.lang.String getFbrefId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
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
    
    public final double getTalentScore() {
        return 0.0;
    }
    
    public final double getHiddenGemScore() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPhotoUrl() {
        return null;
    }
    
    public final boolean isRetired() {
        return false;
    }
    
    public final boolean isWatchlisted() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSeason() {
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
    public final java.lang.Integer getMinutes() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getMatchesPlayed() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAppearances() {
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
    public final java.lang.String getFoot() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getShirtNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCitizenship() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContractExpires() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBirthDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSeasonalStats() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDetailedStats() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAchievements() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMarketValueHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTransfers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInjuries() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRadarData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getRecentPerformanceJson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPerformanceGameJson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFbrefStatsJson() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCompetitionStatsJson() {
        return null;
    }
    
    public final long getLastUpdated() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
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
    public final java.lang.String component25() {
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
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component31() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component33() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component34() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component35() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component37() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component38() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component39() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component40() {
        return null;
    }
    
    public final long component41() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
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
    public final com.scoutapp.data.local.PlayerEntity copy(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String tmId, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefSlug, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String club, @org.jetbrains.annotations.Nullable()
    java.lang.String league, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.Double marketValue, double talentScore, double hiddenGemScore, @org.jetbrains.annotations.Nullable()
    java.lang.String position, @org.jetbrains.annotations.Nullable()
    java.lang.String photoUrl, boolean isRetired, boolean isWatchlisted, @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goals, @org.jetbrains.annotations.Nullable()
    java.lang.Integer assists, @org.jetbrains.annotations.Nullable()
    java.lang.Double xG, @org.jetbrains.annotations.Nullable()
    java.lang.Integer minutes, @org.jetbrains.annotations.Nullable()
    java.lang.Integer matchesPlayed, @org.jetbrains.annotations.Nullable()
    java.lang.Integer appearances, @org.jetbrains.annotations.Nullable()
    java.lang.Integer goalsConceded, @org.jetbrains.annotations.Nullable()
    java.lang.Integer cleanSheets, @org.jetbrains.annotations.Nullable()
    java.lang.String foot, @org.jetbrains.annotations.Nullable()
    java.lang.String shirtNumber, @org.jetbrains.annotations.Nullable()
    java.lang.String citizenship, @org.jetbrains.annotations.Nullable()
    java.lang.String contractExpires, @org.jetbrains.annotations.Nullable()
    java.lang.String birthDate, @org.jetbrains.annotations.Nullable()
    java.lang.String seasonalStats, @org.jetbrains.annotations.Nullable()
    java.lang.String detailedStats, @org.jetbrains.annotations.Nullable()
    java.lang.String achievements, @org.jetbrains.annotations.Nullable()
    java.lang.String marketValueHistory, @org.jetbrains.annotations.Nullable()
    java.lang.String transfers, @org.jetbrains.annotations.Nullable()
    java.lang.String injuries, @org.jetbrains.annotations.Nullable()
    java.lang.String radarData, @org.jetbrains.annotations.Nullable()
    java.lang.String recentPerformanceJson, @org.jetbrains.annotations.Nullable()
    java.lang.String performanceGameJson, @org.jetbrains.annotations.Nullable()
    java.lang.String fbrefStatsJson, @org.jetbrains.annotations.Nullable()
    java.lang.String competitionStatsJson, long lastUpdated) {
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