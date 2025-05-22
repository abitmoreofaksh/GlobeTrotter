package com.GlobeTrotter.Repository;


import com.GlobeTrotter.Entity.Clue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClueRepository extends JpaRepository<Clue, Long> {
    List<Clue> findByDestinationId(Long destinationId);

    @Query(value = "SELECT * FROM clue WHERE destination_id = :destinationId ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Clue> findRandomCluesByDestinationId(Long destinationId, int limit);
}

