package com.example.demo.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderTest {

    @Test
    void encryptPassword() {
        String password = "test1234";

        String encodedPassword =PasswordEncoder.encode(password);

        assertNotEquals(password, encodedPassword);

        assertTrue(encodedPassword.startsWith("$2a$"));
    }

    @Test
    void machinePassword() {
        String password = "test1234";

        String encodedPassword =PasswordEncoder.encode(password);

        assertTrue(PasswordEncoder.matches(password, encodedPassword));
    }

    @Test
    void wrongPassword() {
        String password = "test1234";
        String wrongPassword = "sparta1234";

        String encodedPassword =PasswordEncoder.encode(password);
        String encodedWrongPassword = PasswordEncoder.encode(wrongPassword);
        assertFalse(PasswordEncoder.matches(encodedPassword, encodedWrongPassword));
    }
}