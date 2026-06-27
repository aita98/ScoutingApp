package com.scoutapp.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a \u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u001a\u0010\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a \u0010\u0017\u001a\u00020\u00012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u001a\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0012H\u0007\u001a\u0018\u0010 \u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u001a\u001a\u0010!\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007\u001a\u0018\u0010\"\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u001a\u0010\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020%H\u0007\u001a\u0010\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\rH\u0002\u001a\u0010\u0010)\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010*\u001a\u0015\u0010+\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010,\u00a2\u0006\u0002\u0010-\u00a8\u0006."}, d2 = {"AchievementItem", "", "achievement", "Lcom/scoutapp/data/model/TransfermarktAchievement;", "DetailedStatItem", "stat", "Lcom/scoutapp/data/model/TransfermarktDetailedStat;", "FbrefStatsCard", "stats", "Lcom/scoutapp/domain/model/PlayerStats;", "FormChart", "matches", "", "Lcom/scoutapp/data/api/RecentMatch;", "modifier", "Landroidx/compose/ui/Modifier;", "InfoColumn", "label", "", "value", "InjuryItem", "injury", "Lcom/scoutapp/data/model/TransfermarktInjury;", "MarketValueChart", "history", "Lcom/scoutapp/data/model/TransfermarktMarketValuePoint;", "PlayerDetailScreen", "playerId", "viewModel", "Lcom/scoutapp/viewmodel/PlayerDetailViewModel;", "SectionTitle", "title", "StatItem", "StatMiniItem", "StatTextItem", "TransferItem", "transfer", "Lcom/scoutapp/data/model/TransfermarktTransfer;", "calculateMatchScore", "", "match", "formatAnyMarketValue", "", "formatMarketValue", "", "(Ljava/lang/Double;)Ljava/lang/String;", "app_debug"})
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
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatMarketValue(@org.jetbrains.annotations.Nullable()
    java.lang.Double value) {
        return null;
    }
    
    /**
     * Universal formatter for any market value type (String, Number, etc.)
     * Handles scientific notation, suffixes, and raw large numbers.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatAnyMarketValue(@org.jetbrains.annotations.Nullable()
    java.lang.Object value) {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FormChart(@org.jetbrains.annotations.NotNull()
    java.util.List<com.scoutapp.data.api.RecentMatch> matches, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final float calculateMatchScore(com.scoutapp.data.api.RecentMatch match) {
        return 0.0F;
    }
}