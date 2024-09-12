package UBER_LLD_CODE.Models;
public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getX(){
        return latitude;
    }
    public double getY(){
        return longitude;
    }
}
