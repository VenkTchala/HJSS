package com.example.HJSS;

import java.io.InputStream;
import java.util.*;

public class BookingSystem {
    private List<Learner> learners;
    private List<Coach> coaches;
    private Timetable timetable;
    private Map<String , Coach> coachMap;

    public BookingSystem(){
        learners = new ArrayList<>();
        coaches = new ArrayList<>();

        coachMap = new HashMap<>(4);
        Gender[] genders = new Gender[]{Gender.FEMALE,Gender.MALE,Gender.FEMALE};
        String[] names = new String[] {"Helen","Michael","Sarah"};
        for(int i = 0 ; i < names.length ; i++ ){
            Coach coach = new Coach(names[i],genders[i]);
            coachMap.put(names[i],coach);
        }
    }
    public boolean addLearner(InputStream in){
        try {
            Learner learner =
                    parseLearnerFromInput(in);

            learners.add(learner);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
        return true;
    }

    public Learner parseLearnerFromInput(InputStream in){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name : ");

        String name = sc.nextLine();

        System.out.println("\nPress M/m if Male, F/f if Female, O/o if others : ");

        String genderString = sc.nextLine();
        Gender gender;
        switch (genderString){
            case "M" , "m" :
                gender = Gender.MALE;
                break;

            case "F" ,"f" :
                gender = Gender.FEMALE;
                break;
            case "O","o" :
                gender = Gender.OTHER;
                break;
            default:
                System.out.println("Invalid gender");
                throw new IllegalArgumentException("IllegalGender");
        }

        System.out.println("\nEnter your age : ");

        int age;
        String ageString = sc.nextLine();

        try {
            age = Integer.parseInt(ageString);
        }
        catch (Exception e){
            System.out.println("Invalid age : " + ageString);
            throw new IllegalArgumentException("IllegalGender");
        }

        System.out.println("\nEnter your phone number : ");

        String phoneString = sc.nextLine();

        try {
            Long.parseLong(phoneString);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Phone Number : " + phoneString + " is not valid");
        }

        System.out.println("\nEnter your guardian's phone number : ");

        String emergencyString = sc.nextLine();

        try {
            Long.parseLong(emergencyString);
        }
        catch (Exception e){
            throw new IllegalArgumentException("Invalid phone guardian phone number : " + emergencyString);
        }

        Learner learner;

        learner = new Learner(name,gender,age,phoneString,emergencyString);

        System.out.println("\nCongratulations! You have been sucessfully registered with HJSS");
        System.out.println("\nYour HJSS Id is : " + learner.getId());

        return learner;
    }

    public int getLearnersCount(){
        return learners.size();
    }

}
