package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String extractRole(String token) {
        if (token == null) {
            return null;
        }
        return "";
    }

    public String extractEmail(String token) {
        if (token == null) {
            return "";
        }
        return "";
    }

    public Long extractUserId(String token) {
        if (token == null) {
            return null;
        }
        return null;
    }

    public boolean validateToken(String token, String email) {
        if (token == null || email == null) {
            return false;
        }
        return false;
    }
}
