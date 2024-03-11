package com.example;

import com.example.HJSS.BookingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();

        while(true) {

            System.out.println("The Hatfield Junior Swimming School\n");

            System.out.println("Press (N) to add new learner\n");

            Scanner scanner = new Scanner(System.in);

            if (scanner.nextLine().equals("N")) {
                bookingSystem.addLearner(System.in);
            }

        }

    }
}