package travel;

import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class BOOKING {
    String name;
    int busno;
    Date date;

    // Constructor
    public BOOKING(Scanner sc) {
        System.out.println("Enter Passenger name: ");
        name = sc.next();
        System.out.println("Enter bus no: ");
        busno = sc.nextInt();
        System.out.println("Enter date (dd-MM-yyyy): ");
        String n = sc.next();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = sdf.parse(n);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // Method to check if seats are available for a particular date
    public boolean isAvailable(ArrayList<BUS> buses) {
        int booked = 0;
        int capacity = 0;

        // Loop through buses to find the capacity and booked seats for the bus
        for (BUS bb : buses) {
            if (bb.get_bus_no() == busno) {
                capacity = bb.get_capacity();
                booked = bb.getBookedSeatsForDate(date);
                break;
            }
        }

        // Return true if there are available seats for the given date, else false
        return booked < capacity;
    }

    // Book the seat (if available)
    public void bookSeat(ArrayList<BUS> buses) {
        for (BUS bus : buses) {
            if (bus.get_bus_no() == busno) {
                bus.bookSeat(date);  // Book the seat for the particular date
                break;
            }
        }
    }
}

