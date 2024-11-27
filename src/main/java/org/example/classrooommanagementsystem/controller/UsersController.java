package org.example.classrooommanagementsystem.controller;

import lombok.Getter;
import org.example.classrooommanagementsystem.entity.Users;
import org.example.classrooommanagementsystem.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private final UsersService userService;

    @Autowired
    public UsersController(UsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody Users loginRequest, @RequestParam String role) {
        // Authenticate user and verify role
        Users user = userService.authenticateUserWithRole(loginRequest, role);
        String token = generateToken(user);
        if ( user != null) {
            return ResponseEntity.ok(new LoginResponse(token, role, user.getUserID()));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials or role mismatch");
        }
    }
    private String generateToken(Users user) {
        // Placeholder for token generation logic (e.g., JWT)
        return "generated-token-for-" + user.getEmail();
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users userRequest) {
        Users createdUser = userService.createUser(userRequest);
        return ResponseEntity.ok(createdUser);
    }
    @Getter
    static class LoginResponse {
        private final String token;
        private final String role;
        private final Long userID;

        public LoginResponse(String token, String role, Long userID) {
            this.token = token;
            this.role = role;
            this.userID = userID;
        }
    }
}
