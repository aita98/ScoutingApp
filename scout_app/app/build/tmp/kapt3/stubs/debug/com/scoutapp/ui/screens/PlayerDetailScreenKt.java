package com.scoutapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0003\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a \u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0018\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u001a\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0007\u001a\u0010\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bH\u0007\u001a \u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0016\u0010\u001f\u001a\u00020\u00012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000fH\u0007\u001a\u001a\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020%H\u0007\u001a\u0010\u0010&\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\u0015H\u0007\u001a\u0018\u0010(\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0007\u001a\u001a\u0010)\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0007\u001a\u0018\u0010*\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0007\u001a\u0010\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0007\u001a\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0010\u00a8\u00061"}, d2 = {"AchievementItem", "", "achievement", "Lcom/scoutapp/data/model/TransfermarktAchievement;", "CompetitionStatsTable", "compStats", "Lcom/scoutapp/data/api/CompetitionStatsResponse;", "DetailedStatItem", "stat", "Lcom/scoutapp/data/model/TransfermarktDetailedStat;", "FbrefStatsCard", "stats", "Lcom/scoutapp/domain/model/PlayerStats;", "FormChart", "matches", "", "Lcom/scoutapp/data/api/RecentMatch;", "modifier", "Landroidx/compose/ui/Modifier;", "IconHeaderItem", "iconText", "", "InfoColumn", "label", "value", "InjuryItem", "injury", "Lcom/scoutapp/data/model/TransfermarktInjury;", "MarketValueChart", "history", "Lcom/scoutapp/data/model/TransfermarktMarketValuePoint;", "PerformanceRendimentoTable", "performance", "Lcom/scoutapp/data/model/CompetitionPerformance;", "PlayerDetailScreen", "playerId", "viewModel", "Lcom/scoutapp/viewmodel/PlayerDetailViewModel;", "SectionTitle", "title", "StatItem", "StatMiniItem", "StatTextItem", "TransferItem", "transfer", "Lcom/scoutapp/data/model/TransfermarktTransfer;", "calculateMatchScore", "", "match", "app_debug"})
public final class PlayerDetailScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void PlayerDetailScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String playerId, @org.jetbrains.annotations.NotNull()
    com.scoutapp.viewmodel.PlayerDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SectionTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AchievementItem(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.model.TransfermarktAchievement achievement) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void TransferItem(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.model.TransfermarktTransfer transfer) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InjuryItem(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.model.TransfermarktInjury injury) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatItem(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InfoColumn(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MarketValueChart(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.model.TransfermarktMarketValuePoint> history, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FbrefStatsCard(@org.jetbrains.annotations.NotNull()
    com.scoutapp.domain.model.PlayerStats stats) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DetailedStatItem(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.model.TransfermarktDetailedStat stat) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatMiniItem(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void StatTextItem(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void PerformanceRendimentoTable(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.model.CompetitionPerformance> performance) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void IconHeaderItem(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    java.lang.String iconText) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FormChart(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.api.RecentMatch> matches, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void CompetitionStatsTable(com.scoutapp.data.api.CompetitionStatsResponse compStats) {
    }
    
    public static final float calculateMatchScore(@org.jetbrains.annotations.NotNull()
    com.scoutapp.data.api.RecentMatch match) {
        return 0.0F;
    }
}