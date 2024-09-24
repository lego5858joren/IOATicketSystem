import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RideManager {
    private List<Ride> rides;

    public RideManager() {
        rides = new ArrayList<>();
        initializeRides(); // Method to add predefined rides
    }

    private void initializeRides() {
        // Initialize rides with predefined options
        rides.add(new Ride("The Incredible Hulk Coaster", true));
        rides.add(new Ride("Jurassic Park River Adventure", false));
        rides.add(new Ride("Harry Potter and the Forbidden Journey", true));
        rides.add(new Ride("The Amazing Adventures of Spider-Man", false));
        rides.add(new Ride("Hagrid's Magical Creatures Motorbike Adventure", true));
        rides.add(new Ride("Dr. Doom's Free Fall", false));
        rides.add(new Ride("VelociCoaster", true));
        rides.add(new Ride("Flight of the Hippogriff", false));
        rides.add(new Ride("Dudley Do-Rights Rip Saw Falls", false));
        rides.add(new Ride("Popeye & Bluto's Bilge-Rat Barges", false));
        rides.add(new Ride("Storm Force Accelatron", false));
        rides.add(new Ride("Skull Island: Reign of Kong", false));
        rides.add(new Ride("The Cat in the Hat", false));
        rides.add(new Ride("The High in the Sky Seuss Trolley Train Ride!", false));
        rides.add(new Ride("One Fish, Two Fish, Red Fish, Blue Fish", false));
        rides.add(new Ride("Caro-Seuss-el", false));
    }

    public void enterRide(String rideName, String userId, ExpressPass expressPass) {
        for (Ride ride : rides) {
            if (ride.getName().equalsIgnoreCase(rideName)) {
                // Check if the user has an express pass and it's valid
                if (expressPass != null && expressPass.isValid(LocalDate.now())) {
                    expressPass.usePass(rideName);
                } else {
                    // Simulate wait time for users without an express pass
                    Random random = new Random();
                    int waitTime = random.nextInt(10) + 1; // Random wait time between 1 and 10 seconds
                    System.out.println("You do not have an express pass. Please wait for " + waitTime + " seconds.");
                    try {
                        Thread.sleep(waitTime * 1000); // Sleep for the generated wait time
                    } catch (InterruptedException e) {
                        System.out.println("An error occurred while waiting.");
                    }
                    System.out.println("Your wait is over. Enjoy your ride on " + rideName + "!");
                }
                return;
            }
        }
        System.out.println("Ride not found: " + rideName);
    }

    public List<Ride> getRides() {
        return rides;
    }
}



