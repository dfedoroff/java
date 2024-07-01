package ru.gb.myspringdemo.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomPasswordEncoderTest {

    private final CustomPasswordEncoder encoder = new CustomPasswordEncoder();

    @Test
    void testEncode() {
        String rawPassword = "password123";
        String encodedPassword = encoder.encode(rawPassword);
        assertEquals(rawPassword, encodedPassword);
    }

    @Test
    void testMatches() {
        String rawPassword = "password123";
        String encodedPassword = "password123";
        assertTrue(encoder.matches(rawPassword, encodedPassword));
    }

    @Test
    void testMatchesFail() {
        String rawPassword = "password123";
        String encodedPassword = "wrongpassword";
        assertFalse(encoder.matches(rawPassword, encodedPassword));
    }
}