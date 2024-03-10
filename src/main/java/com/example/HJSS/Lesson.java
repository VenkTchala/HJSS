package com.example.HJSS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lesson {
    private final LocalDate date;
    private final TimeSlot timeSlot;
    private final Coach coach;
    private final int gradeLevel;
    private final List<Learner> bookedLearners;

    private boolean hasVacancy;

    public Lesson(LocalDate date,TimeSlot timeSlot,Coach coach,int gradeLevel){
        this.date = date;
        this.timeSlot = timeSlot;
        this.coach = coach;
        this.gradeLevel = gradeLevel;
        this.bookedLearners = new ArrayList<>();
        this.hasVacancy = true;
    }

    public LocalDate getDate() {
        return date;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public Coach getCoach() {
        return coach;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public int getVacancy(){
        if(!hasVacancy) return 0;

        return 4 - bookedLearners.size();
    }

    public boolean bookLesson(Learner learner){
        if(!hasVacancy) throw new IllegalArgumentException("This lesson is Already booked");
        int learnerGrade = learner.getGradeLevel();

        if(learnerGrade == this.gradeLevel || learnerGrade + 1 == this.gradeLevel )
            throw new IllegalArgumentException("Grade " + learnerGrade + "learners cannot attend grade " + this.gradeLevel + " lesson" );
        this.bookedLearners.add(learner);

        if(this.bookedLearners.size() == 4)
            this.hasVacancy = false;

        return true;
    }




}
