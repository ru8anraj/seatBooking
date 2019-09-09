package com.ru8anraj.seatBooking;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    public Theatre(String theatreName, int numOfRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numOfRows-1);
        System.out.println("last row - > " + lastRow);

        for (char row='A'; row<=lastRow; row++) {
            for (int seatNum=1; seatNum<=seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserve(String seatNumReq) {
        for(Seat seat: seats) {
            if (seat.getSeatNumber().equals(seatNumReq)) {
                return seat.reserve();
            }
        }
        return false;
    }


    // ----------------
    // Seat inner class
    private class Seat {
        private String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat number "+seatNumber+" is reserved!");
                return true;
            } else {
                System.out.println("Requested seat is already reserved!");
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Seat number "+seatNumber+" is cancelled!");
                return true;
            } else {
                System.out.println("Request seat is not reserved yet!");
                return false;
            }
        }

        public String getSeatNumber() {
            return this.seatNumber;
        }
    }
}
