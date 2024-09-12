package UBER_LLD_CODE.Models;

public class Driver {
    private String name;
    private boolean avail;
    private int rating;
    private Location location;

    public Driver(String name, boolean avail, int rating, Location location) {
        this.name = name;
        this.avail = avail;  // Correcting the typo here
        this.rating = rating;
        this.location = location;
    }


    public void updateAvail(boolean status) {
        this.avail = status;
    }

    public boolean isAvailable() {
        return avail;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public Location getLocation() {
        return location;
    }
}
