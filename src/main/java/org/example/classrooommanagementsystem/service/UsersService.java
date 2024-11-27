package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Users;
import org.example.classrooommanagementsystem.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);
    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersService(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Users authenticateUserWithRole(Users loginRequest, String role) {
        Optional<Users> userOptional = userRepository.findByEmail(loginRequest.getEmail().trim());
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            logger.info("Found user with email: " + loginRequest.getEmail());
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                logger.info("Password matched for user: " + loginRequest.getEmail());
                if (user.getRole().getRoleName().equalsIgnoreCase(role.trim())) {
                    logger.info("Role matched: " + role);
                   // return generateToken(user);
                    return user;
                } else {
                    logger.warn("Role mismatch. Expected: " + role + ", Actual: " + user.getRole().getRoleName());
                }
            } else {
                logger.warn("Password mismatch for user: " + loginRequest.getEmail());
            }
        } else {
            logger.warn("No user found with email: " + loginRequest.getEmail());
        }
        return null;
    }

    public Users createUser(Users userRequest) {
        // Encode the password before saving
        userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        if (userRequest.getFirstName() == null || userRequest.getLastName() == null || userRequest.getRole() == null) {
            throw new IllegalArgumentException("First name, last name, and role are required fields.");
        }
        Users savedUser = userRepository.save(userRequest);
        logger.info("Created new user with email: " + savedUser.getEmail() + ", first name: " + savedUser.getFirstName() + ", last name: " + savedUser.getLastName() + ", role ID: " + savedUser.getRole().getRoleID());
        return savedUser;
    }
    private String generateToken(Users user) {
        // Placeholder for token generation logic (e.g., JWT)
        return "generated-token-for-" + user.getEmail();
    }
}
