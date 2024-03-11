package com.example.HJSS;

import java.util.List;

public class Coach {
    private String name;
    private Gender gender;
    private List<Lesson> lessonsTaught;
    private double averageRating;

    public Coach(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.averageRating = 0;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public List<Lesson> getLessonsTaught() {
        return lessonsTaught;
    }

    protected void updateRating(double rating){
        this.averageRating = rating;
    }

}
