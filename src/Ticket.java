import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Represents a ticket to Universal Orlando's Islands of Adventure.
public class Ticket {
    private LocalDate chosenDate; // Customer's chosen date for their ticket
    private ExpressPass expressPass; // Associated express pass

    // Constructor for the Ticket
    public Ticket(LocalDate chosenDate, ExpressPass expressPass) {
        this.chosenDate = chosenDate;
        this.expressPass = expressPass; // Associate express pass with the ticket
    }

    // Method to buy a ticket
    public static Ticket buyTicket() {
        Scanner scanner = new Scanner(System.in);
        LocalDate customerChosenDate = null;

        while (true) { // Loop until a valid date is entered
            System.out.println("Enter the date you want to go to Islands of Adventure (yyyy-MM-dd):");
            String inputDate = scanner.nextLine();

            try {
                // Parse the input date
                customerChosenDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
                LocalDate today = LocalDate.now();

                // Check if the date is in the past
                if (customerChosenDate.isBefore(today)) {
                    System.out.println("You cannot purchase a ticket for a past date. Please enter a future date.");
                } else {
                    break; // Date is valid, break out of the loop
                }
            } catch (Exception e) {
                // Handle invalid date format
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }

        ExpressPass expressPass = null; // Initialize express pass as null

        // Ask if the customer wants an express pass
        System.out.println("Do you want an express pass? (yes/no)");
        String expressPassChoice = scanner.nextLine();

        // If they want an express pass, ask for the type
        if (expressPassChoice.equalsIgnoreCase("yes")) {
            System.out.println("Choose express pass type: 1 for Unlimited, 2 for Single-Use:");
            int passType = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            if (passType == 1) {
                expressPass = new ExpressPass(true, customerChosenDate); // Unlimited express pass
            } else if (passType == 2) {
                expressPass = new ExpressPass(false, customerChosenDate); // Single-use express pass
            } else {
                System.out.println("Invalid choice for express pass type. No express pass will be added.");
            }
        }

        // Create the ticket with or without the express pass
        Ticket ticket = new Ticket(customerChosenDate, expressPass);
        System.out.println("Ticket purchased for " + customerChosenDate + "!");
        return ticket; // Return the created ticket
    }

    // Method to validate entry to the park
    public boolean validateEntry() {
        LocalDate today = LocalDate.now(); // Get today's date
        if (!chosenDate.equals(today)) {
            System.out.println("This ticket is not valid for today's date.");
            return false;
        } else {
            System.out.println("Welcome to Islands of Adventure, have a great day!");
            return true;
        }
    }

    // Method to use express pass
    public void useExpressPass(String rideName) {
        if (expressPass != null) {
            if (expressPass.isValid(chosenDate)) { // Validate express pass date
                expressPass.usePass(rideName); // Use the express pass for the ride
            } else {
                System.out.println("This express pass is not valid for today's date.");
            }
        } else {
            System.out.println("No express pass associated with this ticket.");
        }
    }

    public ExpressPass getExpressPass() {
        return expressPass;
    }
}





