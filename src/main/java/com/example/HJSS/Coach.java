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
    }
}
