package com.example.HJSS;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;


class LessonTest {

    @BeforeEach
    public  void init(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void constructoruShouldInstantiateProperly(){
        LocalDate date = LocalDate.of(2024,3,10);
        TimeSlot timeSlot = TimeSlot.FIVETOSIXPM;
        Coach coach = new Coach("john doe",Gender.MALE);
        GradeLevel gradeLevel = GradeLevel.TWO;
        Lesson lesson = new Lesson(date,timeSlot,coach,gradeLevel);

        assertEquals(date,lesson.getDate());
        assertEquals(timeSlot,lesson.getTimeSlot());
        assertEquals(coach,lesson.getCoach());
        assertEquals(gradeLevel,lesson.getGradeLevel());
        assertEquals(4,lesson.getVacancy());
    }


    @ParameterizedTest()
    @MethodSource("gradelevelProvider")
    void bookingLessonShouldThrowExceptionForLearnerNotEligible(GradeLevel gradeLevel){
        Coach coach = mock(Coach.class);

        Learner learner = mock(Learner.class);
        when(learner.getGradeLevel()).thenReturn(gradeLevel);

        Lesson lesson = new Lesson(LocalDate.now(),TimeSlot.FIVETOSIXPM,coach,GradeLevel.FOUR);

        assertThrows(IllegalArgumentException.class,()-> lesson.bookLesson(learner));
    }

    static List<GradeLevel> gradelevelProvider(){
        return List.of(GradeLevel.ONE,GradeLevel.TWO,GradeLevel.ZERO);
    }

}