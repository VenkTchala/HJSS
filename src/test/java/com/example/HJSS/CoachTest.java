package com.example.HJSS;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoachTest {
    @ParameterizedTest
    @MethodSource("coachProvider")
    void constructorShouldInstiateProperly(String name,Gender gender){
        Coach coach = new Coach(name,gender);
        assertEquals(name,coach.getName());
        assertEquals(gender,coach.getGender());
    }

    @Test
    void shouldUpdateRatingProperly(){
        Coach coach = new Coach("John",Gender.MALE);
        double intialRating = coach.getAverageRating();
        coach.updateRating(4);
        assertEquals(4,coach.getAverageRating());
    }

    static Stream<Object[]> coachProvider(){
        return Stream.of(
          new Object[]{"john",Gender.MALE},
          new Object[]{"rose", Gender.FEMALE},
        new Object[]{"Paul", Gender.MALE},
        new Object[]{"Lilly", Gender.FEMALE},
        new Object[]{"Kane", Gender.MALE}
        );
    }


}
