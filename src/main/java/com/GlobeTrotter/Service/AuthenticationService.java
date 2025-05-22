package com.GlobeTrotter.Service;
import com.GlobeTrotter.DTO.LoginUserDTO;
import com.GlobeTrotter.Entity.Role;
import com.GlobeTrotter.Entity.User;
import com.GlobeTrotter.Repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.GlobeTrotter.DTO.RegisterUserDTO;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User signup(RegisterUserDTO input) {
        User user = new User();
        user.setUsername(input.getUsername());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(Role.ROLE_USER);

        return userRepository.save(user);
    }
    public User authenticate(LoginUserDTO input) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            input.getUsername(),
                            input.getPassword()
                    )
            );
        } catch (Exception ex) {
            System.out.println("Authentication failed: " + ex.getMessage());
            throw ex;
        }
        return userRepository.findByUsername(input.getUsername())
                .orElseThrow();
    }

}
