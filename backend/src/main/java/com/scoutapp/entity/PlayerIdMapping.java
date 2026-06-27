package com.scoutapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerIdMapping {
    @Id
    private String transfermarktId;
    private Long sofascoreId;
}
