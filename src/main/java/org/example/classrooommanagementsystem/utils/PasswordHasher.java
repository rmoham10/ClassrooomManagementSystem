package org.example.classrooommanagementsystem.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin@123"; // Replace with your desired password
        String hashedPassword = encoder.encode(rawPassword);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}
