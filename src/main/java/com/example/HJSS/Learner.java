package com.example.HJSS;


import java.util.List;

public class Learner {
    private static int index = 0;
    private int id;
    private String name;
    private Gender gender;
    private int age;
    private String phoneNumber;
    private String emergencyContact;
    private int gradeLevel;
    private List<Lesson> bookedLessons;
    private List<Lesson> cancelledLessons;
    private List<Lesson> attendedLessons;

    public Learner(String name,Gender gender,int age ,String phoneNumber,String emergencyContact){
        if(age < 4 || age > 11)
            throw new IllegalArgumentException("A learner’s age needs to be between 4 and 11");

        this.id = Learner.index;
        Learner.index++;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyContact = emergencyContact;
        this.gradeLevel = 0;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }


    public int getAge() {
        return age;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getEmergencyContact() {
        return emergencyContact;
    }


    public int getGradeLevel() {
        return gradeLevel;
    }


    public List<Lesson> getBookedLessons() {
        return bookedLessons;
    }


    public List<Lesson> getCancelledLessons() {
        return cancelledLessons;
    }


    public List<Lesson> getAttendedLessons() {
        return attendedLessons;
    }

}
