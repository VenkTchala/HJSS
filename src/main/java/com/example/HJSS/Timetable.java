package com.example.HJSS;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Timetable {
    private List<Lesson> lessons = new ArrayList<>();

    private Map<DayOfWeek,List<Lesson>> dayLessonMap = new HashMap<>();
    private Map<Coach,List<Lesson>> coachLessonMap = new HashMap<>();
    private Map<GradeLevel, List<Lesson>> gradeLevelListMap = new HashMap<>();

    public List<Lesson> getLessonsByDay(DayOfWeek week) {
        return dayLessonMap.get(week);
    }

    public List<Lesson> getLessonsByCoach(Coach coach){
        return coachLessonMap.get(coach);
    }

    public List<Lesson> getLessonsByGrade(GradeLevel level){
        return gradeLevelListMap.get(level);
    }

    public void addLesson(Lesson lesson){
        coachLessonMap.putIfAbsent(lesson.getCoach(),new ArrayList<>());
        coachLessonMap.get(lesson.getCoach()).add(lesson);
        dayLessonMap.putIfAbsent(lesson.getDate().getDayOfWeek(), new ArrayList<>());
        dayLessonMap.get(lesson.getDate().getDayOfWeek()).add(lesson);
        gradeLevelListMap.putIfAbsent(lesson.getGradeLevel(),new ArrayList<>());
        gradeLevelListMap.get(lesson.getGradeLevel()).add(lesson);
        lessons.add(lesson);
    }

}
