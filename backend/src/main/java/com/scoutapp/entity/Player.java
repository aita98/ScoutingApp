package com.scoutapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Integer apiFootballId;

    @Column(unique = true)
    private String transfermarktId;

    private String name;
    private Integer age;
    private String nationality;
    private String position;
    private String club;
    private String league;
    private String photoUrl;
    private Double marketValue;
    
    private Double talentScore;
    private Double hiddenGemScore;
    
    private Double appearancePercentage;
    private Double starterPercentage;
    
    // Algorithm & List flags
    private Integer minutesPlayed;
    private Integer teamTotalMatches;
    private Boolean isConsigliato;
    private Boolean isHiddenGem;

    // Advanced Stats for Radar/Scouting
    private Integer goals;
    private Integer assists;
    private Double xg;
    private Double xa;
    private Integer keyPasses;
    private Integer progressivePasses;
    private Integer progressiveCarries;
    
    @Column(columnDefinition = "TEXT")
    private String recentPerformanceJson;
    
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PlayerStats> statistics;
}
