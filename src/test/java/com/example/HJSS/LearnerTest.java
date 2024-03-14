package com.example.HJSS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearnerTest {

    @Test
    void constructorShouldInstiateProperly(){
        String name = "john doe";
        String phoneNumber = "44523852694";
        String emergencyContact = "44546567294";
        Learner johnDoe = new Learner(name , Gender.MALE,9,phoneNumber,emergencyContact);
        assertEquals(name,johnDoe.getName());
        assertEquals(Gender.MALE,johnDoe.getGender());
        assertEquals(9,johnDoe.getAge());
        assertEquals(phoneNumber,johnDoe.getPhoneNumber());
        assertEquals(emergencyContact,johnDoe.getEmergencyContact());
    }

    @Test()
     void shouldThrowIllegalArgumentExceptionForDisApprovedAge(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Learner("John doe",Gender.MALE,16,"44523852694","44546567294"));

        assertEquals("\nA learner’s age needs to be between 4 and 11\n",exception.getLocalizedMessage());
    }

    @Test
    void shouldIncrementId(){
        Learner learner = new Learner("john",Gender.MALE,10,"44444555444","4444554444");
        int start = learner.getId();
        for(int i = 1 ; i < 10 ; i++){
            Learner learner1 = new Learner("john",Gender.MALE,10,"44444555444","4444554444");
            assertEquals( start + i  ,learner1.getId());
        }

    }



}