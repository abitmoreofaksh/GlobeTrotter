package com.GlobeTrotter.Controller;

import com.GlobeTrotter.DTO.AnswerRequestDTO;
import com.GlobeTrotter.DTO.AnswerResponseDTO;
import com.GlobeTrotter.DTO.DestinationOption;
import com.GlobeTrotter.DTO.QuestionDTO;
import com.GlobeTrotter.Entity.Clue;
import com.GlobeTrotter.Entity.Destination;
import com.GlobeTrotter.Entity.Fact;
import com.GlobeTrotter.Entity.User;
import com.GlobeTrotter.Exception.InvalidInputException;
import com.GlobeTrotter.Service.DestinationService;
import com.GlobeTrotter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/game")
@CrossOrigin(origins = "*")
public class GameController {
    private final DestinationService destinationService;
    private final UserService userService;

    @Autowired
    public GameController(DestinationService destinationService, UserService userService) {
        this.destinationService = destinationService;
        this.userService = userService;
    }
    @GetMapping("/question")
    public ResponseEntity<QuestionDTO> getRandomQuestion() {
        // Get a random destination
        Destination destination = destinationService.getRandomDestination();

        // Get random clues for this destination
        List<Clue> clues = destinationService.getRandomCluesForDestination(destination.getId(), 2);

        // Get multiple choice options
        List<Destination> options = destinationService.getMultipleChoiceOptions(destination.getId(), 4);

        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestionURL(destination.getImageUrl());
        questionDTO.setQuestionId(destination.getId());
        questionDTO.setClues(clues.stream().map(Clue::getText).collect(Collectors.toList()));
        questionDTO.setOptions(options.stream().map(d -> new DestinationOption(d.getId(), d.getName(), d.getCountry())).collect(Collectors.toList()));

        return ResponseEntity.ok(questionDTO);
    }

    @PostMapping("/answer")
    public ResponseEntity<AnswerResponseDTO> checkAnswer(@RequestBody AnswerRequestDTO request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Validate input
        if (request == null) {
            throw new InvalidInputException("Answer request cannot be null");
        }

        if (request.getQuestionId() == null) {
            throw new InvalidInputException("Question ID is required");
        }

        if (request.getSelectedOptionId() == null) {
            throw new InvalidInputException("Selected option ID is required");
        }
        User currentUser = (User) authentication.getPrincipal();

        if (currentUser == null ) {
            throw new InvalidInputException("Username is required");
        }

        User user = userService.getUserByUsername(currentUser.getUsername());

        Destination correctDestination = destinationService.getDestinationById(request.getQuestionId());
        boolean isCorrect = correctDestination.getId().equals(request.getSelectedOptionId());

        // Get a random fact for feedback
        Fact fact = destinationService.getRandomFactForDestination(correctDestination.getId());

        // Update user score if userId is provided
        if (user.getUsername() != null) {
            System.out.println("Username not null inside /Answer api");
            userService.updateUserScore(user.getUsername(), isCorrect);
        }

        AnswerResponseDTO response = new AnswerResponseDTO();
        response.setCorrect(isCorrect);
        response.setCorrectDestinationId(correctDestination.getId());
        response.setCorrectDestinationName(correctDestination.getName());
        response.setFact(fact.getText());

        return ResponseEntity.ok(response);
    }

}
