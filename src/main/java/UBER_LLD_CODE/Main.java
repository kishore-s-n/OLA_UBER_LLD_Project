package UBER_LLD_CODE;

import UBER_LLD_CODE.Managers.RiderManager;
import UBER_LLD_CODE.Managers.TripManager;
import UBER_LLD_CODE.Models.*;
import UBER_LLD_CODE.Managers.DriverManager;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //---------------Creating Riders and Drivers--------------------------------
        Rider kishoreRider = new Rider("Kishore", 3);
        Rider keertiRider = new Rider("Keerti", 4);
        Rider kumarRider = new Rider("Gaurav", 5);
        Rider basithRider = new Rider("Basith", 4);

        RiderManager riderMgr = RiderManager.getRiderManager();

        riderMgr.addRider("Kishore", kishoreRider);
        riderMgr.addRider("keerti", keertiRider);
        riderMgr.addRider("gaurav", kumarRider);
        riderMgr.addRider("Basith", basithRider);

        Driver arun=new Driver("Arun",true,5,new Location(30,10));
        Driver ram = new Driver("Yogita", true,3,new Location(20,10));
        Driver ashok = new Driver("Riddhi",true,4,new Location(20,20));

        DriverManager driverMgr = DriverManager.getDriverManager();

        driverMgr.addDriver("arun", arun);
        driverMgr.addDriver("yogita", ram);
        driverMgr.addDriver("riddhi", ashok);


        // These are retrived from the local memory, This can be implemented in databases for more drivers and riders.
        //-------------------------------------------------------------------------

        TripManager tripMgr = TripManager.getTripManager();


        System.out.println("\nCreating Trip for Kishore from location (10,10) to (30,30)");
        tripMgr.createTrip(kishoreRider, new Location(10, 10), new Location(30, 30));


        System.out.println("\nCreating Trip for Keerti from location (10,10) to (30,30)");
        tripMgr.createTrip(keertiRider, new Location(100, 10), new Location(30, 30));

        System.out.println("\nCreating Trip for Gaurav from location (200,200) to (500,500)");
        tripMgr.createTrip(kumarRider, new Location(200, 200), new Location(500, 500));


        System.out.println("\nCreating Trip for Basith from location (200,200) to (500,500)");
        tripMgr.createTrip(kumarRider, new Location(200, 200), new Location(500, 500));

        //-------------------Display all the trips created--------------------------

        HashMap<Integer, Trip> tripsMap = tripMgr.getTripsMap();
        for (Trip trip : tripsMap.values()) {
            trip.displayTripDetails();
        }
    }
}
