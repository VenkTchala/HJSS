package com.example.HJSS;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private static int index;
    private final int id;
    private final LocalDate date;

    public int getId() {
        return id;
    }
    private final TimeSlot timeSlot;
    private final Coach coach;
    private final GradeLevel gradeLevel;
    private final List<Learner> bookedLearners;
    private final List<Review> reviews;
    private final List<Learner> attendedLearners;
    private boolean hasVacancy;

    public Lesson(LocalDate date,TimeSlot timeSlot,Coach coach,GradeLevel gradeLevel){
        this.id = Lesson.index;

        Lesson.index++;

        this.date = date;

        this.timeSlot = timeSlot;

        this.coach = coach;
        this.gradeLevel = gradeLevel;
        this.bookedLearners = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.attendedLearners = new ArrayList<>();
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

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public int getVacancy(){
        if(!hasVacancy) return 0;

        return 4 - bookedLearners.size();
    }

    public void bookLesson(Learner learner){
        if(!hasVacancy) throw new IllegalArgumentException("This lesson is Already booked");
        GradeLevel learnerGrade = learner.getGradeLevel();
        int learnerGradeInt = learnerGrade.ordinal();
        int lessonGradeInt = gradeLevel.ordinal();

        if(bookedLearners.contains(learner))
            throw new IllegalArgumentException("\nYou have already booked this lesson\n");

        if( learnerGradeInt + 1 != lessonGradeInt && learnerGradeInt != lessonGradeInt )
            throw new IllegalArgumentException("\nGrade " + learnerGrade + " learners cannot attend grade " + this.gradeLevel + " lesson\n" );
        this.bookedLearners.add(learner);

        if(this.bookedLearners.size() == 4)
            this.hasVacancy = false;

    }

    public void cancelBooking(Learner learner){
        if(this.bookedLearners.contains(learner))
            this.bookedLearners
                    .removeIf(i -> i.getId() == learner.getId());
    }

    public void reviewLesson(Review review){
        if(this.attendedLearners.contains(review.getLearner()))
            this.reviews.add(review);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", date=" + date +
                ", timeSlot=" + timeSlot +
                ", coach=" + coach +
                ", gradeLevel=" + gradeLevel +
                ", bookedLearners=" + bookedLearners +
                ", hasVacancy=" + hasVacancy +
                '}';
    }
}
