package com.example.HJSS;

import java.time.DayOfWeek;
import java.util.List;

public class Timetable {
    private List<Lesson> lessons;

    public List<Lesson> getLessonsByDay(DayOfWeek week) {
        return lessons.stream()
                .filter(i -> i.getDate().getDayOfWeek().equals(week))
                .toList();
    }

    public List<Lesson> getLessonsByCoach(Coach coach){
        return lessons.stream()
                .filter(i -> i.getCoach().equals(coach))
                .toList();
    }

    public List<Lesson> getLessonsByGrade(GradeLevel level){
        return lessons.stream()
                .filter(i -> i.getGradeLevel().equals(level))
                .toList();
    }


}
