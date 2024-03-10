package com.example.HJSS;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;


class LessonTest {
    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void constructoruShouldInstantiateProperly(){
        LocalDate date = LocalDate.of(2024,3,10);
        TimeSlot timeSlot = TimeSlot.FIVETOSIXPM;
        Coach coach = new Coach("john doe",Gender.MALE);
        int gradeLevel = 2;
        Lesson lesson = new Lesson(date,timeSlot,coach,gradeLevel);

        assertEquals(date,lesson.getDate());
        assertEquals(timeSlot,lesson.getTimeSlot());
        assertEquals(coach,lesson.getCoach());
        assertEquals(gradeLevel,lesson.getGradeLevel());
        assertEquals(4,lesson.getVacancy());
    }

}