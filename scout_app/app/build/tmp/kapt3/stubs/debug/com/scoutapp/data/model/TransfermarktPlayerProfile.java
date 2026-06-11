package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00bf\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f\u00a2\u0006\u0002\u0010\u0018J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0001H\u00c2\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00109\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\fH\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00c2\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00e8\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0002\u0010CJ\u0013\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\tH\u00d6\u0001J\t\u0010H\u001a\u00020\u0003H\u00d6\u0001R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0013\u0010)\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b*\u0010!R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0013\u0010,\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b-\u0010!R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001d\u00a8\u0006I"}, d2 = {"Lcom/scoutapp/data/model/TransfermarktPlayerProfile;", "", "id", "", "name", "fullName", "dateOfBirth", "_placeOfBirth", "age", "", "height", "citizenship", "", "position", "foot", "club", "Lcom/scoutapp/data/model/TransfermarktClub;", "_marketValue", "joined", "contractExpires", "socialMedia", "imageUrl", "stats", "Lcom/scoutapp/data/model/TransfermarktStat;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktClub;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getAge", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCitizenship", "()Ljava/util/List;", "getClub", "()Lcom/scoutapp/data/model/TransfermarktClub;", "getContractExpires", "()Ljava/lang/String;", "getDateOfBirth", "getFoot", "getFullName", "getHeight", "getId", "getImageUrl", "getJoined", "marketValue", "getMarketValue", "getName", "placeOfBirth", "getPlaceOfBirth", "getPosition", "getSocialMedia", "getStats", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktClub;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lcom/scoutapp/data/model/TransfermarktPlayerProfile;", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class TransfermarktPlayerProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String fullName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String dateOfBirth = null;
    @com.google.gson.annotations.SerializedName(value = "placeOfBirth")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object _placeOfBirth = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer age = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String height = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> citizenship = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String position = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String foot = null;
    @com.google.gson.annotations.SerializedName(value = "club")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktClub club = null;
    @com.google.gson.annotations.SerializedName(value = "marketValue")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object _marketValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String joined = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String contractExpires = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> socialMedia = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imageUrl = null;
    @com.google.gson.annotations.SerializedName(value = "stats")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.scoutapp.data.model.TransfermarktStat> stats = null;
    
    public TransfermarktPlayerProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.Nullable()
    java.lang.String dateOfBirth, @org.jetbrains.annotations.Nullable()
    java.lang.Object _placeOfBirth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.String height, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> citizenship, @org.jetbrains.annotations.Nullable()
    java.lang.String position, @org.jetbrains.annotations.Nullable()
    java.lang.String foot, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClub club, @org.jetbrains.annotations.Nullable()
    java.lang.Object _marketValue, @org.jetbrains.annotations.Nullable()
    java.lang.String joined, @org.jetbrains.annotations.Nullable()
    java.lang.String contractExpires, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> socialMedia, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.model.TransfermarktStat> stats) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFullName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDateOfBirth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAge() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHeight() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCitizenship() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPosition() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFoot() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClub getClub() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getJoined() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContractExpires() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getSocialMedia() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.model.TransfermarktStat> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPlaceOfBirth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMarketValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClub component11() {
        return null;
    }
    
    private final java.lang.Object component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.model.TransfermarktStat> component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    private final java.lang.Object component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.TransfermarktPlayerProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String fullName, @org.jetbrains.annotations.Nullable()
    java.lang.String dateOfBirth, @org.jetbrains.annotations.Nullable()
    java.lang.Object _placeOfBirth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer age, @org.jetbrains.annotations.Nullable()
    java.lang.String height, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> citizenship, @org.jetbrains.annotations.Nullable()
    java.lang.String position, @org.jetbrains.annotations.Nullable()
    java.lang.String foot, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClub club, @org.jetbrains.annotations.Nullable()
    java.lang.Object _marketValue, @org.jetbrains.annotations.Nullable()
    java.lang.String joined, @org.jetbrains.annotations.Nullable()
    java.lang.String contractExpires, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> socialMedia, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.model.TransfermarktStat> stats) {
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