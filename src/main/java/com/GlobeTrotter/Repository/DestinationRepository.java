package com.GlobeTrotter.Repository;

import com.GlobeTrotter.Entity.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
    // Fetch a random set of destinations for multiple-choice options
    @Query(value = "SELECT * FROM destination ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Destination> findRandomDestinations(int limit);

    // Find destinations excluding a specific one (for generating multiple choice options)
    @Query(value = "SELECT * FROM destination WHERE id != :excludeId ORDER BY RAND()", nativeQuery = true)
    List<Destination> findRandomDestinationsExcluding(Long excludeId, int limit);
}

