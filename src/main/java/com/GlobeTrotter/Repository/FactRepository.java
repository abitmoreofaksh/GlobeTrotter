package com.GlobeTrotter.Repository;

import com.GlobeTrotter.Entity.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FactRepository extends JpaRepository<Fact, Long> {
    @Query(value = "SELECT * FROM fact WHERE destination_id = :destinationId ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Fact findRandomFactByDestinationId(Long destinationId);

    @Query(value = "SELECT * FROM fact WHERE destination_id = :destinationId AND is_trivia = :isTrivia ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Fact findRandomFactByDestinationIdAndType(Long destinationId, Boolean isTrivia);
}
