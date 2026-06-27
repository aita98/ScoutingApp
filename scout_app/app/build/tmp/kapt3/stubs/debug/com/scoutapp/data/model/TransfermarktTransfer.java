package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003JQ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006!"}, d2 = {"Lcom/scoutapp/data/model/TransfermarktTransfer;", "", "date", "", "season", "from", "Lcom/scoutapp/data/model/TransfermarktClubShort;", "to", "fee", "marketValue", "(Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktClubShort;Lcom/scoutapp/data/model/TransfermarktClubShort;Ljava/lang/Object;Ljava/lang/Object;)V", "getDate", "()Ljava/lang/String;", "getFee", "()Ljava/lang/Object;", "getFrom", "()Lcom/scoutapp/data/model/TransfermarktClubShort;", "getMarketValue", "getSeason", "getTo", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class TransfermarktTransfer {
    @com.google.gson.annotations.SerializedName(value = "date")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String date = null;
    @com.google.gson.annotations.SerializedName(value = "season")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String season = null;
    @com.google.gson.annotations.SerializedName(value = "clubFrom")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktClubShort from = null;
    @com.google.gson.annotations.SerializedName(value = "clubTo")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktClubShort to = null;
    @com.google.gson.annotations.SerializedName(value = "fee")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object fee = null;
    @com.google.gson.annotations.SerializedName(value = "marketValue")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object marketValue = null;
    
    public TransfermarktTransfer(@org.jetbrains.annotations.Nullable()
    java.lang.String date, @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClubShort from, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClubShort to, @org.jetbrains.annotations.Nullable()
    java.lang.Object fee, @org.jetbrains.annotations.Nullable()
    java.lang.Object marketValue) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSeason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClubShort getFrom() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClubShort getTo() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFee() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMarketValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClubShort component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClubShort component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.TransfermarktTransfer copy(@org.jetbrains.annotations.Nullable()
    java.lang.String date, @org.jetbrains.annotations.Nullable()
    java.lang.String season, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClubShort from, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClubShort to, @org.jetbrains.annotations.Nullable()
    java.lang.Object fee, @org.jetbrains.annotations.Nullable()
    java.lang.Object marketValue) {
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