package UBER_LLD_CODE.Strategies;

import UBER_LLD_CODE.Managers.DriverManager;
import UBER_LLD_CODE.Models.Driver;
import UBER_LLD_CODE.Models.Location;
import UBER_LLD_CODE.TripMetaData;

import java.util.HashMap;
import java.util.Map;

public class LeastTimeBasedMatching implements DriverMatching {

    // Helper method to calculate the distance between two locations
    private double calculateDistance(Location loc1, Location loc2) {
        // Euclidean distance formula: sqrt((x2 - x1)^2 + (y2 - y1)^2)
        double xDiff = loc2.getX() - loc1.getX();
        double yDiff = loc2.getY() - loc1.getY();
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    @Override
    public Driver matchDriver(TripMetaData trip) {
        DriverManager driverManager = DriverManager.getDriverManager();
        HashMap<String, Driver> drivers = driverManager.getDrivers();

        if (drivers.isEmpty()) {
            System.out.println("No drivers found");
            return null;
        }

        System.out.println("Searching from available drivers based on location");

        Location tripSourceLocation = trip.getSrcLoc();  // Get source location of the trip

        // Variables to store the nearest driver and the shortest distance
        Driver nearestDriver = null;
        double shortestDistance = Double.MAX_VALUE;

        // Iterate through the available drivers to find the nearest one
        for (Map.Entry<String, Driver> entry : drivers.entrySet()) {
            Driver driver = entry.getValue();

            // Only consider drivers that are available
            if (driver.isAvailable()) {
                Location driverLocation = driver.getLocation();  // Assuming Driver has a getLocation() method

                // Calculate the distance between the driver and the trip's source location
                double distance = calculateDistance(driverLocation, tripSourceLocation);

                // If this driver is closer, update the nearestDriver and shortestDistance
                if (distance < shortestDistance) {
                    nearestDriver = driver;
                    shortestDistance = distance;
                }
            }
        }

        // Check if a nearest driver was found
        if (nearestDriver != null) {
            System.out.println("Nearest available driver found: " + nearestDriver.getName() + " at a distance of " + shortestDistance);
            nearestDriver.updateAvail(false);
        } else {
            System.out.println("No available drivers nearby.");
        }

        return nearestDriver;
    }
}
