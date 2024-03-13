package com.example;

import com.example.HJSS.BookingSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        while (bookingSystem.isLearnerSelected()){

            System.out.println("\nThe Hatfield Junior Swimming School\n");

            System.out.println( "Press (N) to add new learner\t" + "Press (L) if already registered\n");

            Scanner sc = new Scanner(System.in);

            switch (sc.nextLine()) {
                case "N" , "n" ->
                    bookingSystem.addLearner(System.in);
                case "L" , "l" ->
                    bookingSystem.selectUserTable(System.in);
            }
        }


//
        loop: while(true) {

            System.out.println("The Hatfield Junior Swimming School\n");

            System.out.println("Logged in as : " + bookingSystem.getLoggedInUserName() + " Grade - " + bookingSystem.getLoggedInUserGrade() +"\n");

            System.out.println("Press (V) to view timetable & Book lessons\t\t" + "Press (E) to exit program\n");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()) {
                case "V" , "v" ->
                    bookingSystem.printTableMenu(System.in);
                case "E", "e" ->{ break loop;}
            }

        }


    }
}