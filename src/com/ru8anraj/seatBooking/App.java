package com.ru8anraj.seatBooking;

public class App {
    public static void main(String[] args) {
        Theatre ajanta = new Theatre("ajanta", 10, 20);

        if (ajanta.reserve("A05")) {
            System.out.println("Please Pay!");
        } else {
            System.out.println("Seat taken!");
        }

        if (ajanta.reserve("A05")) {
            System.out.println("Please Pay!");
        } else {
            System.out.println("Seat taken!");
        }
    }
}

