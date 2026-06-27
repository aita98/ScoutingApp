package com.scoutapp.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u00c6\u0003JQ\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001e"}, d2 = {"Lcom/scoutapp/data/model/TransfermarktSearchResponse;", "", "players", "Lcom/scoutapp/data/model/TransfermarktSearchData;", "Lcom/scoutapp/data/model/TransfermarktSearchResult;", "clubs", "Lcom/scoutapp/data/model/TransfermarktClub;", "competitions", "Lcom/scoutapp/data/model/TransfermarktCompetition;", "results", "", "(Lcom/scoutapp/data/model/TransfermarktSearchData;Lcom/scoutapp/data/model/TransfermarktSearchData;Lcom/scoutapp/data/model/TransfermarktSearchData;Ljava/util/List;)V", "getClubs", "()Lcom/scoutapp/data/model/TransfermarktSearchData;", "getCompetitions", "getPlayers", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class TransfermarktSearchResponse {
    @com.google.gson.annotations.SerializedName(value = "players")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktSearchResult> players = null;
    @com.google.gson.annotations.SerializedName(value = "clubs")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktClub> clubs = null;
    @com.google.gson.annotations.SerializedName(value = "competitions")
    @org.jetbrains.annotations.Nullable()
    private final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktCompetition> competitions = null;
    @com.google.gson.annotations.SerializedName(value = "results")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.scoutapp.data.model.TransfermarktSearchResult> results = null;
    
    public TransfermarktSearchResponse(@org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktSearchResult> players, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktClub> clubs, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktCompetition> competitions, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.model.TransfermarktSearchResult> results) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktSearchResult> getPlayers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktClub> getClubs() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktCompetition> getCompetitions() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.model.TransfermarktSearchResult> getResults() {
        return null;
    }
    
    public TransfermarktSearchResponse() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktSearchResult> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktClub> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktCompetition> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.scoutapp.data.model.TransfermarktSearchResult> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.scoutapp.data.model.TransfermarktSearchResponse copy(@org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktSearchResult> players, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktClub> clubs, @org.jetbrains.annotations.Nullable()
    com.scoutapp.data.model.TransfermarktSearchData<com.scoutapp.data.model.TransfermarktCompetition> competitions, @org.jetbrains.annotations.Nullable()
    java.util.List<com.scoutapp.data.model.TransfermarktSearchResult> results) {
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