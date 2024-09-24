import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ExpressPass {
    private boolean isUnlimited; // true for unlimited pass, false for single-use
    private LocalDate validDate; // The date the express pass is valid for
    private Set<String> usedRides; // Track rides used with single-use express pass

    // Constructor
    public ExpressPass(boolean isUnlimited, LocalDate validDate) {
        this.isUnlimited = isUnlimited;
        this.validDate = validDate;
        this.usedRides = new HashSet<>();
    }

    public boolean isUnlimited() {
        return isUnlimited;
    }

    public boolean isValid(LocalDate currentDate) {
        return validDate.equals(currentDate);
    }

    public void usePass(String rideName) {
        if (isUnlimited) {
            // If the pass is unlimited, always allow access and do not track rides
            System.out.println("Unlimited express pass used for " + rideName + "! Enjoy your ride!");
        } else {
            // For single-use express passes, track the ride usage
            if (usedRides.contains(rideName)) {
                System.out.println("Single-use express pass has already been used for " + rideName + ".");
            } else {
                usedRides.add(rideName);
                System.out.println("Single-use express pass used for " + rideName + "! Enjoy your ride!");
            }
        }
    }
}


