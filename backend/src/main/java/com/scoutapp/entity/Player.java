package com.scoutapp.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String name;
    private Integer age;
    private String nationality;
    private String position;
    private String club;
    private String photoUrl;
    private Double marketValue;
    
    private Double talentScore;
    private Double hiddenGemScore;
    
    private LocalDateTime lastUpdated;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<PlayerStats> statistics;
}
