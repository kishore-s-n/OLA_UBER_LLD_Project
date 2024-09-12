package UBER_LLD_CODE.Models;

public class Rider {
    private String name;
    private int rating;

    // Constructor
    public Rider(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    // Getter for name
    public String getRiderName() {
        return name;
    }

    // Getter for rating
    public int getRating() {
        return rating;
    }
}
