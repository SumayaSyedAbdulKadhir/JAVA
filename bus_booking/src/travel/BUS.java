package travel;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BUS {
    private int bno;
    private boolean ac;
    private int capacity;
    private Map<Date, Integer> bookedSeatsByDate;  // Map to track booked seats for each date

    // Constructor
    public BUS(int a, boolean b, int c) {
        this.bno = a;
        this.ac = b;
        this.capacity = c;
        this.bookedSeatsByDate = new HashMap<>();  // Initialize the map
    }

    // Getter methods
    public int get_bus_no() {
        return bno;
    }

    public boolean get_type() {
        return ac;
    }

    public int get_capacity() {
        return capacity;
    }

    // Method to get the booked seats for a particular date
    public int getBookedSeatsForDate(Date date) {
        return bookedSeatsByDate.getOrDefault(date, 0);  // Default to 0 if no bookings for that date
    }

    // Method to book a seat for a particular date
    public void bookSeat(Date date) {
        bookedSeatsByDate.put(date, getBookedSeatsForDate(date) + 1);  // Increment booked seats for that date
    }

    // Display bus information, including booked and vacant seats for all dates
    public void display() {
        System.out.println("------------------------");
        System.out.println("Bus Number: " + bno);
        System.out.println("Bus type (AC): " + ac);
        System.out.println("Bus capacity: " + capacity);

        // Display booked and vacant seats for each date
        for (Map.Entry<Date, Integer> entry : bookedSeatsByDate.entrySet()) {
            int booked = entry.getValue();
            int vacant = capacity - booked;
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Date: " + df.format(entry.getKey()) + " - Booked seats: " + booked + ", Vacant seats: " + vacant);
        }

        if (bookedSeatsByDate.isEmpty()) {
            System.out.println("No bookings yet.");
        }
    }
}

