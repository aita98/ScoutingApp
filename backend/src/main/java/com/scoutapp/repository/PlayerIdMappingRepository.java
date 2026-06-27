package com.scoutapp.repository;

import com.scoutapp.entity.PlayerIdMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlayerIdMappingRepository extends JpaRepository<PlayerIdMapping, String> {
    Optional<PlayerIdMapping> findBySofascoreId(Long sofascoreId);
}
