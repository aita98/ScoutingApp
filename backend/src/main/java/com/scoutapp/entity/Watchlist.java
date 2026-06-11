package com.scoutapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "watchlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId; // For future multi-user support

    @ManyToOne
    @JoinColumn(name = "player_id")
    @JsonIgnoreProperties({"statistics", "lastUpdated", "apiFootballId"})
    private Player player;

    private LocalDateTime dateAdded;
    private Double talentScoreAtAdd;
    private Double hiddenGemScoreAtAdd;
}
