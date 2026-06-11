package com.scoutapp.repository;

import com.scoutapp.entity.ScoutEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoutEventRepository extends JpaRepository<ScoutEvent, Long> {
    List<ScoutEvent> findAllByOrderByCreatedAtDesc();
}
