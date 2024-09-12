package UBER_LLD_CODE.Models;

import UBER_LLD_CODE.Strategies.DriverMatching;
import UBER_LLD_CODE.Strategies.PricingStrategy;


public class Trip {

    Rider rider;
    Driver driver;
    Location src;
    Location dest;
    TRIP_STATUS status;
    int tripId;
    double price;
    PricingStrategy pricingStrategy;
    DriverMatching driverMatchingStrategy;

    public Trip(Rider rider, Driver driver, Location src, Location dest, double price, PricingStrategy pricingStrategy, DriverMatching driverMatchingStrategy) {
        this.rider = rider;
        this.driver = driver;
        this.src = src;
        this.dest = dest;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        tripId = tripId++;
    }

    public int getTripId() {
        return tripId;
    }


    public void displayTripDetails() {
        System.out.println("Trip{" +"\nrider=" + rider.getRiderName() +",\ndriver=" + driver.getName() +",\nsrc=" + src.getX()+" "+src.getY() +",\ndest=" + dest.getX() +" " +dest.getY()+",\nstatus=" + status +",\ntripId=" + tripId +",\nprice=" + price + '}');
    }
}
