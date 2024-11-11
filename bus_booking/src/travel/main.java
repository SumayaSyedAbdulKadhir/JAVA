package travel;

import java.util.*;

public class main {
    public static void main(String args[]) {
        ArrayList<BUS> buses = new ArrayList<>();
        ArrayList<BOOKING> bookings = new ArrayList<>();
        
        // Adding buses
        buses.add(new BUS(1, true, 50));  // Bus 1 with AC and 50 seats
        buses.add(new BUS(2, true, 55));  // Bus 2 with AC and 55 seats
        buses.add(new BUS(3, true, 60));  // Bus 3 with AC and 60 seats

        // Display buses information
        System.out.println("Bus details:");
        for (BUS a : buses) {
            a.display();  // Display each bus details with date-wise seat availability
        }

        Scanner sc = new Scanner(System.in);
        int ch = 1;

        // Main loop to handle booking
        while (ch == 1) {
            System.out.println("Enter 1 to book, 2 to exit:");
            ch = sc.nextInt();
            if (ch == 1) {
                BOOKING book = new BOOKING(sc);  // Book a ticket

                if (book.isAvailable(buses)) {
                    System.out.println("Booking confirmed for bus number " + book.busno + " on date " + book.date);
                    book.bookSeat(buses);  // Book the seat for the specified bus and date
                    bookings.add(book);    // Add the booking to the list
                } else {
                    System.out.println("No available seats for bus number " + book.busno + " on date " + book.date);
                }
            }

            // Display updated buses information
            System.out.println("\nUpdated bus details:");
            for (BUS a : buses) {
                a.display();  // Display each bus details with updated seat availability
            }
        }

        sc.close();
    }
}
