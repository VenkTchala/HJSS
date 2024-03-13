package com.example.HJSS;

import java.io.InputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.IntStream;

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
            coaches.add(coach);
        }
        createTimetable();

//        Learner learner =
        String learnerNames[] = {"John", "Ibrahim", "Victor" , "Paul" , "Aurora", "Ava", "Leon" };
        String learnerGender[] = {"M", "M", "M" , "M" , "F", "F", "M" };
        int learnerAges[] = {9,10,11,8,7,6,5};
        String[] phoneNumbers = {"44648484843", "44866264265" , "44848457654", "44754234141" , "44554414375" , "44334252225" , "44534267854"  };

        String[] emergencyNumbers = {"44768484843", "44156264265" , "44768457654", "44834234141" , "44124414375" , "44524252225" , "44144267854"  };
        for(int i = 0 ; i < learnerNames.length ; i++){
            String name = learnerNames[i];
            Gender gender;
            int age = learnerAges[i];
            switch (learnerGender[i]){
                case "M" -> gender = Gender.MALE;
                case "F" -> gender = Gender.FEMALE;
                case "O" -> gender = Gender.OTHER;
                default -> {
                    return;
                }
            }
            Learner learner = new Learner(name, gender, age,phoneNumbers[i], emergencyNumbers[i]);
            learners.add(learner);
        }

    }

    public boolean addLearner(InputStream in){
        try {
            Learner learner =
                    parseLearnerFromInput(in);

            learners.add(learner);
        }
        catch (Exception e){
            System.err.println("\n" + e.getMessage() + ", please register again." + "\n");
        }
        return true;
    }

    public Learner parseLearnerFromInput(InputStream in){

        Scanner sc = new Scanner(in);

        System.out.println("\nLearner Registration.");

        System.out.println("\nEnter Your Name : ");

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
                throw new IllegalArgumentException("IllegalGender");
        }

        System.out.println("\nEnter your age : ");

        int age;
        String ageString = sc.nextLine();

        try {
            age = Integer.parseInt(ageString);
        }
        catch (Exception e){
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

    private void createTimetable(){

        Map<OperatingDays,List<String[]>> lessonMap = Map.of(
                OperatingDays.MONDAY, List.of(new String[]{
                        "Helen",
                        "4to5",
                        "1"

                },new String[]{
                        "Helen",
                        "5to6",
                        "2"
                },
                        new String[]{
                                "Helen",
                                "6to7",
                                "3"
                        }
                ),
                OperatingDays.WEDNESDAY, List.of( new String[]{
                        "Michael",
                        "4to5",
                        "4"
                },
                        new String[]{
                                "Michael",
                                "5to6",
                                "5"
                        },
                        new String[]{
                                "Sarah",
                                "6to7",
                                "1"
                        }
                ),
                OperatingDays.FRIDAY, List.of(new String[]{
                        "Helen",
                        "4to5",
                        "3"
                },new String []{
                        "Helen",
                        "5to6",
                        "4"
                },
                        new String[]{
                                "Helen",
                                "6to7",
                                "5"
                        }
                ),
                OperatingDays.SATURDAY, List.of(new String[] {
                        "Michael",
                        "2to3",
                        "2"
                },
                        new String[]{
                                "Sarah",
                                "3to4",
                                "3"
                        }

                )
        );

        timetable = new Timetable();



        Map<String,GradeLevel> intGradeLevelMap = Map.of("1",GradeLevel.ONE,
                "2",GradeLevel.TWO,
                "3",GradeLevel.THREE,
                "4", GradeLevel.FOUR,
                "5", GradeLevel.FIVE
                );

        Map<String,TimeSlot> stringTimeSlotMap = Map.of(
                "2to3",TimeSlot.TWOTOTHREEPM,
                "3to4",TimeSlot.THREETOFROURPM,
                "4to5",TimeSlot.FOURTOFIVEPM,
                "5to6", TimeSlot.FIVETOSIXPM,
                "6to7", TimeSlot.SIXTOSEVENPM
        );

        LocalDate localDate = LocalDate.now();

        for(int i = 0 ; i < 4 ; i ++){

            LocalDate firstDayOfNextWeek = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

            List<LocalDate> remainingDays = localDate.datesUntil(firstDayOfNextWeek)
                    .toList();

            remainingDays.forEach(d -> addToTimeTable(d,lessonMap,stringTimeSlotMap,intGradeLevelMap));

            localDate = firstDayOfNextWeek;
        }
    }

    public void printTableMenu(InputStream in){
        Scanner sc = new Scanner(in);

        System.out.println( "Press (C) to View lessons taught by Coach\t" + "Press (G) to view lessons by GradeLevel\t\t" + "Press (D) to view Lessons by Day\t");

        String str = sc.nextLine();

        switch (str){
            case "C", "c" -> printTableByCoach(in);
            case "G","g" -> printTableByGradeLevel(in);
            case "D","d"-> printTableByDate(in);
        }
    }

    private void printTableByGradeLevel(InputStream in){

        IntStream.range(1, GradeLevel.values().length)
                .forEach(i ->
                    System.out.println( "Press " + i + " to select lessons at Grade " + GradeLevel.values()[i])
                );

        Scanner sc = new Scanner(in);
        String selection = sc.nextLine();
        int i;

        try {
            i = Integer.parseInt(selection);

            if(i < 0 || i > GradeLevel.values().length) {
                System.err.println("Invalid option : " + i);
                return;
            }
            printTable(timetable.getLessonsByGrade(GradeLevel.values()[i]));

        }
        catch (Exception e){
            System.err.println("Invalid option : " + selection);
        }
    }

    private void printTableByCoach(InputStream in){

        IntStream.range(0, coaches.size())
                .forEach(i -> {
                    System.out.println( "Press " + i + " to select lessons taught by " + coaches.get(i).getName());
                });

        Scanner sc = new Scanner(in);
        String selection = sc.nextLine();
        int i;

        try {
            i = Integer.parseInt(selection);

            if(i < 0 || i > coaches.size()) {
            System.err.println("Invalid option : " + i);
            return;
        }
            printTable(timetable.getLessonsByCoach(coaches.get(i)));

        }
        catch (Exception e){
            System.err.println("Invalid option : " + selection);
        }
    }

    private void printTableByDate(InputStream in){
        Scanner sc = new Scanner(in);
        for(int i = 0 ; i < OperatingDays.values().length ; i++ ){
            System.out.println("Press (" + i + ") to select " + OperatingDays.values()[i]);
        }

        String str = sc.nextLine();

        int i;

        try {
            i = Integer.parseInt(str);

            if(i < 0 || i > OperatingDays.values().length) {
                System.err.println("Invalid option : " + i);
                return;
            }
            printTable(timetable.getLessonsByDay( DayOfWeek.valueOf(OperatingDays.values()[i].toString())));

        }
        catch (Exception e){
            System.err.println("Invalid option : " + str);
        }
    }



    public void addToTimeTable(LocalDate i , Map<OperatingDays,List<String[]>> lessonMap, Map<String,TimeSlot> stringTimeSlotMap, Map<String,GradeLevel> intGradeLevelMap){
        switch (i.getDayOfWeek()){
            case MONDAY,WEDNESDAY,FRIDAY,SATURDAY ->
                    lessonMap.get(OperatingDays.valueOf(i.getDayOfWeek().toString()))
                            .forEach(l -> {

                                Coach coach = coachMap.get(l[0]);
                                TimeSlot timeSlot = stringTimeSlotMap.get(l[1]);
                                GradeLevel gradeLevel = intGradeLevelMap.get(l[2]);

                                Lesson lesson = new Lesson(i,timeSlot,coach,gradeLevel);

                                timetable.addLesson(lesson);

                            });
        }
    }

    public void printTable(List<Lesson> list){
        System.out.println("-".repeat(80));

        System.out.format("%-15s%-15s%-15s%-15s%-15s%n", "Date" , "Day", "Coach" , "grade", "remainingSeats" );

        System.out.println("-".repeat(80));

        list
                .forEach(i ->
                        System.out.format("%-15s%-15s%-15s%-15d%-15d%n", i.getDate() ,i.getDate().getDayOfWeek().toString().toLowerCase() , i.getCoach().getName() , i.getGradeLevel().ordinal(), i.getVacancy() )
                        );

        System.out.println("-".repeat(80) + "\n");
    }


    public int getLearnersCount(){
        return learners.size();
    }

}
