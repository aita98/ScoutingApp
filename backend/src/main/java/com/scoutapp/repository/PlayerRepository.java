package com.scoutapp.repository;

import com.scoutapp.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
    @Query("SELECT p FROM Player p LEFT JOIN FETCH p.statistics WHERE p.apiFootballId = :apiFootballId")
    Optional<Player> findByApiFootballIdWithStats(Integer apiFootballId);

    Optional<Player> findByApiFootballId(Integer apiFootballId);

    Optional<Player> findByTransfermarktId(String transfermarktId);

    @Query("SELECT p FROM Player p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(p.club) LIKE LOWER(CONCAT('%', :query, '%')) " +
           "OR LOWER(p.nationality) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Player> searchPlayers(@Param("query") String query);

    List<Player> findTop10ByOrderByTalentScoreDesc();
    List<Player> findTop10ByOrderByHiddenGemScoreDesc();
    
    @Query("SELECT p FROM Player p " +
           "WHERE (p.age IS NULL OR p.age <= 24) " +
           "AND (p.marketValue IS NULL OR p.marketValue < 15000000) " +
           "AND (p.talentScore >= 75) " +
           "ORDER BY p.talentScore DESC")
    List<Player> findOneToWatch();

    @Query("SELECT p FROM Player p " +
           "WHERE (p.age IS NULL OR p.age <= 23) " +
           "AND (p.marketValue IS NULL OR p.marketValue < 7000000) " +
           "AND (p.hiddenGemScore >= 70) " +
           "ORDER BY p.hiddenGemScore DESC")
    List<Player> findHiddenGems();
}
