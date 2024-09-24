import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RideManager rideManager = new RideManager();

        // Buy a ticket and associated express pass if desired
        Ticket ticket = Ticket.buyTicket();

        // If the ticket was successfully purchased
        if (ticket != null) {
            if (ticket.validateEntry()) {
                // Allow the user to go on rides
                String userId = "User123"; // Placeholder for user ID

                while (true) {
                    System.out.println("Available rides:");
                    for (Ride ride : rideManager.getRides()) {
                        System.out.println("- " + ride.getName());
                    }

                    System.out.println("Enter the ride you want to go on (or 'exit' to quit):");
                    String rideName = scanner.nextLine();

                    if (rideName.equalsIgnoreCase("exit")) {
                        break;
                    }

                    // Attempt to enter the ride using the ticket and express pass
                    rideManager.enterRide(rideName, userId, ticket.getExpressPass());
                }
            }
        } else {
            System.out.println("Ticket purchase failed.");
        }

        scanner.close();
        System.out.println("Thank you for using the Islands of Adventure Ticketing System!");
    }
}




