
import java.util.HashSet;
import java.util.Set;

public class Ride {
    private String name;
    private boolean isSingleUseExpress; // Indicates if the ride has a single-use express option
    private Set<String> usersWhoUsedSingleUsePass; // Tracks users who have used the single-use express pass

    public Ride(String name, boolean isSingleUseExpress) {
        this.name = name;
        this.isSingleUseExpress = isSingleUseExpress;
        this.usersWhoUsedSingleUsePass = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public boolean isSingleUseExpress() {
        return isSingleUseExpress;
    }

    public boolean useRide(String userId) {
        if (isSingleUseExpress) {
            if (usersWhoUsedSingleUsePass.contains(userId)) {
                System.out.println("You have already used the express pass for this ride: " + name);
                return false; // Deny entry since the express pass has already been used
            } else {
                usersWhoUsedSingleUsePass.add(userId); // Track the user
                System.out.println("You can use the express pass for " + name + "!");
                return true; // Allow entry
            }
        } else {
            // Unlimited express pass or standby line entry
            System.out.println("Enjoy your ride on " + name + "!");
            return true;
        }
    }
}


