package com.scoutapp.repository;

import com.scoutapp.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    @Query("SELECT p FROM Player p LEFT JOIN FETCH p.statistics WHERE p.apiFootballId = :apiFootballId")
    Optional<Player> findByApiFootballIdWithStats(Integer apiFootballId);

    Optional<Player> findByApiFootballId(Integer apiFootballId);
    List<Player> findTop10ByOrderByTalentScoreDesc();
    List<Player> findTop10ByOrderByHiddenGemScoreDesc();
    
    @Query("SELECT p FROM Player p " +
           "WHERE (p.age IS NULL OR p.age <= 24) " +
           "AND (p.marketValue IS NULL OR p.marketValue < 10000000) " +
           "AND (p.talentScore >= 80) " +
           "ORDER BY p.talentScore DESC")
    List<Player> findRecommendedProspects();

    @Query("SELECT p FROM Player p " +
           "WHERE (p.age IS NULL OR p.age <= 22) " +
           "AND (p.marketValue IS NULL OR p.marketValue < 5000000) " +
           "AND (p.hiddenGemScore >= 75) " +
           "AND (p.talentScore < 80 OR p.talentScore IS NULL) " +
           "ORDER BY p.hiddenGemScore DESC")
    List<Player> findHiddenGems();
}
