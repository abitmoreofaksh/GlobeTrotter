package com.GlobeTrotter.Controller;

import com.GlobeTrotter.DTO.LeaderboardDTO;
import com.GlobeTrotter.DTO.UserDTO;
import com.GlobeTrotter.Entity.User;
import com.GlobeTrotter.Exception.InvalidInputException;
import com.GlobeTrotter.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUserByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        // Validate input
        if (currentUser == null ) {
            throw new InvalidInputException("Username is required");
        }

        User user = userService.getUserByUsername(currentUser.getUsername());
        UserDTO userDTO = new UserDTO();
        userDTO .setEmail(user.getEmail());
        userDTO.setCorrectAnswers(user.getCorrectAnswers());
        userDTO.setTotalAnswers(user.getTotalAnswers());
        userDTO.setScorePercentage(user.getScorePercentage());

        return ResponseEntity.ok(userDTO);

    }

    @GetMapping("/leaderboard")
    public List<LeaderboardDTO> getLeaderboard() {
        return userService.getLeaderboard();
    }

}
