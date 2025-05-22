package com.GlobeTrotter.Service;

import com.GlobeTrotter.Entity.Clue;
import com.GlobeTrotter.Entity.Destination;
import com.GlobeTrotter.Entity.Fact;
import com.GlobeTrotter.Repository.ClueRepository;
import com.GlobeTrotter.Repository.DestinationRepository;
import com.GlobeTrotter.Repository.FactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;
    private final ClueRepository clueRepository;
    private final FactRepository factRepository;
    private final Random random = new Random();

    @Autowired
    public DestinationService(DestinationRepository destinationRepository,
                              ClueRepository clueRepository,
                              FactRepository factRepository) {
        this.destinationRepository = destinationRepository;
        this.clueRepository = clueRepository;
        this.factRepository = factRepository;
    }
    public List<Destination> getAllDestinations() {
        try {
            return destinationRepository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("No destination found");
        }
    }
    public Destination getDestinationById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Destination ID cannot be null");
        }

        return destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destination not found with id " + id));
    }

    public Destination getRandomDestination() {
        try {
            List<Destination> randomDestinations = destinationRepository.findRandomDestinations(1);
            if (randomDestinations.isEmpty()) {
                throw new RuntimeException("No destinations available in the database");
            }
            return randomDestinations.get(0);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving random destination", e);
        }
    }

    public List<Clue> getRandomCluesForDestination(Long destinationId, int count) {
        if (destinationId == null) {
            throw new IllegalArgumentException("Destination ID cannot be null");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be greater than zero");
        }

        try {
            List<Clue> clues = clueRepository.findRandomCluesByDestinationId(destinationId, count);
            if (clues.isEmpty()) {
                throw new RuntimeException("Clues destinationId "+ destinationId);
            }
            return clues;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving clues for destination " + destinationId, e);
        }
    }

    public Fact getRandomFactForDestination(Long destinationId) {
        if (destinationId == null) {
            throw new IllegalArgumentException("Destination ID cannot be null");
        }

        try {
            Fact fact = factRepository.findRandomFactByDestinationId(destinationId);
            if (fact == null) {
                throw new RuntimeException("Facts destinationId "+ destinationId);
            }
            return fact;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving facts for destination " + destinationId, e);
        }
    }

    public List<Destination> getMultipleChoiceOptions(Long correctDestinationId, int count) {
        if (correctDestinationId == null) {
            throw new IllegalArgumentException("Correct destination ID cannot be null");
        }
        if (count <= 1) {
            throw new IllegalArgumentException("Count must be greater than one");
        }

        try {
            // Get the correct destination first
            Destination correctDestination = getDestinationById(correctDestinationId);

            // Get random destinations excluding the correct one
            List<Destination> options = destinationRepository.findRandomDestinationsExcluding(
                    correctDestinationId, count - 1);

            // Add the correct destination
            options.add(correctDestination);

            // Shuffle the options
            Collections.shuffle(options);

            return options;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving multiple choice options", e);
        }
    }
}
