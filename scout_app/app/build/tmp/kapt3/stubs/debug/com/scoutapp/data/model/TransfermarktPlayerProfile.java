package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B\u00b9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r\u00a2\u0006\u0002\u0010\u001aJ\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0015H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00c6\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u00c6\u0003J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\rH\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rH\u00c6\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003\u00a2\u0006\u0002\u0010+J\u00dc\u0001\u0010H\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\rH\u00c6\u0001\u00a2\u0006\u0002\u0010IJ\u0013\u0010J\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020\u000bH\u00d6\u0001J\t\u0010M\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b\'\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\n\n\u0002\u0010,\u001a\u0004\b\u000e\u0010+R\u0013\u0010-\u001a\u0004\u0018\u00010\u00038F\u00a2\u0006\u0006\u001a\u0004\b.\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0019\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010!\u00a8\u0006N"}, d2 = {"Lcom/scoutapp/data/model/TransfermarktPlayerProfile;", "", "id", "", "name", "nameInHomeCountry", "description", "imageUrl", "placeOfBirth", "Lcom/scoutapp/data/model/TransfermarktPlaceOfBirth;", "height", "", "citizenship", "", "isRetired", "", "position", "Lcom/scoutapp/data/model/TransfermarktPosition;", "foot", "shirtNumber", "club", "Lcom/scoutapp/data/model/TransfermarktClubDetails;", "_marketValue", "socialMedia", "stats", "Lcom/scoutapp/data/model/TransfermarktStat;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktPlaceOfBirth;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Lcom/scoutapp/data/model/TransfermarktPosition;Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktClubDetails;Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)V", "get_marketValue", "()Ljava/lang/Object;", "age", "getAge", "()Ljava/lang/Integer;", "getCitizenship", "()Ljava/util/List;", "getClub", "()Lcom/scoutapp/data/model/TransfermarktClubDetails;", "getDescription", "()Ljava/lang/String;", "getFoot", "getHeight", "Ljava/lang/Integer;", "getId", "getImageUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "marketValue", "getMarketValue", "getName", "getNameInHomeCountry", "getPlaceOfBirth", "()Lcom/scoutapp/data/model/TransfermarktPlaceOfBirth;", "getPosition", "()Lcom/scoutapp/data/model/TransfermarktPosition;", "getShirtNumber", "getSocialMedia", "getStats", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktPlaceOfBirth;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;Lcom/scoutapp/data/model/TransfermarktPosition;Ljava/lang/String;Ljava/lang/String;Lcom/scoutapp/data/model/TransfermarktClubDetails;Ljava/lang/Object;Ljava/util/List;Ljava/util/List;)Lcom/scoutapp/data/model/TransfermarktPlayerProfile;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class TransfermarktPlayerProfile {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String nameInHomeCountry = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imageUrl = null;
    @com.google.gson.annotations.SerializedName(value = "placeOfBirth")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktPlaceOfBirth placeOfBirth = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer height = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> citizenship = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isRetired = null;
    @com.google.gson.annotations.SerializedName(value = "position")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktPosition position = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String foot = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String shirtNumber = null;
    @com.google.gson.annotations.SerializedName(value = "club")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktClubDetails club = null;
    @com.google.gson.annotations.SerializedName(value = "marketValue")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Object _marketValue = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> socialMedia = null;
    @com.google.gson.annotations.SerializedName(value = "stats")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.scoutapp.data.model.TransfermarktStat> stats = null;
    
    public TransfermarktPlayerProfile(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String nameInHomeCountry, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktPlaceOfBirth placeOfBirth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer height, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> citizenship, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRetired, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktPosition position, @org.jetbrains.annotations.Nullable()
    java.lang.String foot, @org.jetbrains.annotations.Nullable()
    java.lang.String shirtNumber, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClubDetails club, @org.jetbrains.annotations.Nullable()
    java.lang.Object _marketValue, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> socialMedia, @org.jetbrains.annotations.Nullable()
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
    public final java.lang.String getNameInHomeCountry() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktPlaceOfBirth getPlaceOfBirth() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getHeight() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getCitizenship() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isRetired() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktPosition getPosition() {
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
    public final com.scoutapp.data.model.TransfermarktClubDetails getClub() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object get_marketValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getSocialMedia() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.model.TransfermarktStat> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMarketValue() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getAge() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktPosition component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktClubDetails component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object component14() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component15() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.model.TransfermarktStat> component16() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktPlaceOfBirth component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.TransfermarktPlayerProfile copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String nameInHomeCountry, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktPlaceOfBirth placeOfBirth, @org.jetbrains.annotations.Nullable()
    java.lang.Integer height, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> citizenship, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRetired, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktPosition position, @org.jetbrains.annotations.Nullable()
    java.lang.String foot, @org.jetbrains.annotations.Nullable()
    java.lang.String shirtNumber, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktClubDetails club, @org.jetbrains.annotations.Nullable()
    java.lang.Object _marketValue, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> socialMedia, @org.jetbrains.annotations.Nullable()
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