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
//
        loop: while(true) {

            System.out.println("The Hatfield Junior Swimming School\n");

            System.out.println( "Press (N) to add new learner\t" + "Press (V) to view timetable\t\t" + "Press (E) to exit program\t");


            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()) {
                case "N" , "n" ->
                bookingSystem.addLearner(System.in);
                case "V" , "v" ->
                    bookingSystem.printTableMenu(System.in);
                case "E", "e" ->{ break loop;}
            }

        }


    }
}