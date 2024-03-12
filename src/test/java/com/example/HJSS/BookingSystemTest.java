package com.example.HJSS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

public class BookingSystemTest {
    @ParameterizedTest
    @ValueSource(strings = {"john\nM\n10\n4464642626\n44325454769"})
    void shouldAddUser(String input){
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BookingSystem bookingSystem = new BookingSystem();

        assertDoesNotThrow(() -> {
            bookingSystem.addLearner(System.in);
        });

        assertNotEquals(0,bookingSystem.getLearnersCount());
    }

    @ParameterizedTest()
    @ValueSource(strings = {"john\nN\n10\n44488485\n44554564"})
    void shouldThrowExceptionOnWrongCreds (String input){

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BookingSystem bookingSystem = new BookingSystem();

        assertThrows(IllegalArgumentException.class ,() -> {
            bookingSystem.parseLearnerFromInput(System.in);
        });
    }


}
