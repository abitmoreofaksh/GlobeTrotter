package com.GlobeTrotter.Service;


import com.GlobeTrotter.DTO.LeaderboardDTO;
import com.GlobeTrotter.Entity.User;
import com.GlobeTrotter.Repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getUserByUsername(String username) {
        User user = new User();
        try {
             user =  userRepository.findByUsername(username)
                    .orElseThrow();
        }catch (RuntimeException e)
        {
            System.out.println("No user Found");
        }
        return user;
    }
    public User getUserByEmail(String email) {
        return userRepository.findByUsername(email)
                .orElseThrow(() -> new RuntimeException("User not found by email"));
    }

    public void updateUserScore(String username, boolean correct) {
        User user = getUserByUsername(username);

        if (correct) {
            user.incrementCorrectAnswers();
        } else {
            user.incrementTotalAnswers();
        }

         userRepository.save(user);
    }
    public List<LeaderboardDTO> getLeaderboard() {
        List<Object[]> results = userRepository.getLeaderboard();
        return results.stream()
                .map(obj -> new LeaderboardDTO(
                        (String) obj[0],   // username
                        (Integer) obj[1], // correctAnswers
                        (Integer) obj[2]  // totalAnswers
                ))
                .collect(Collectors.toList());
    }

}
