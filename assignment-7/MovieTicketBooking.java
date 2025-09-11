import java.util.Scanner;

public class MovieTicketBooking {

    // MovieTicket class definition
    static class MovieTicket {
        String movieName;
        String seatNumber;
        double price;

        // Method to book a ticket
        public void bookTicket(String name, String seat, double p) {
            movieName = name;
            seatNumber = seat;
            price = p;
            System.out.println("Ticket booked successfully!");
        }

        // Method to display ticket details
        public void displayTicket() {
            System.out.println("\n--- Ticket Details ---");
            System.out.println("Movie Name: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: ₹" + price);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create MovieTicket object
        MovieTicket ticket = new MovieTicket();

        // Input booking details
        System.out.print("Enter movie name: ");
        String name = sc.nextLine();

        System.out.print("Enter seat number: ");
        String seat = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        // Book and display ticket
        ticket.bookTicket(name, seat, price);
        ticket.displayTicket();
    }
}