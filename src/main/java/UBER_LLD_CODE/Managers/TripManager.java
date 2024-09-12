package UBER_LLD_CODE.Managers;

import UBER_LLD_CODE.Models.Driver;
import UBER_LLD_CODE.Models.Location;
import UBER_LLD_CODE.Models.Rider;
import UBER_LLD_CODE.Models.Trip;
import UBER_LLD_CODE.Strategies.DriverMatching;
import UBER_LLD_CODE.Strategies.PricingStrategy;
import UBER_LLD_CODE.TripMetaData;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TripManager {
    RiderManager riderManager;
    DriverManager driverManager;
    HashMap<Integer, TripMetaData> tripsMetaDataMap=new HashMap<>();
    HashMap<Integer, Trip> tripsMap=new HashMap<>();
    private static final ReentrantLock locks=new ReentrantLock();
    private static TripManager tripManager;
    TripManager(){
        RiderManager riderManager=RiderManager.getRiderManager();
        DriverManager driverManager=DriverManager.getDriverManager();
    }

    public static TripManager getTripManager(){
        if(tripManager==null){
            try{

                locks.lock();
                if(tripManager==null){
                    tripManager=new TripManager();
                }
            }finally {
                locks.unlock();
            }
        }
        return tripManager;
    }

    public void createTrip(Rider rider, Location src, Location dest){
        TripMetaData metaData=new TripMetaData(src,dest,rider.getRating());
        StrategyManager strategyManager=StrategyManager.getInstance();
        PricingStrategy pricingStrategy=strategyManager.determinePricingStrategy(metaData);
        DriverMatching driverMatching=strategyManager.determineDriverMatching(metaData);

        Driver driver=driverMatching.matchDriver(metaData);
        double price=pricingStrategy.calculatePrice(metaData);

        if(driver!=null){

            Trip trip=new Trip(rider,driver,src,dest,price,pricingStrategy,driverMatching);
            int tripId=trip.getTripId();
            tripsMap.put(tripId,trip);
            tripsMetaDataMap.put(tripId,metaData);
        }else{

            System.out.println("No Drivers Available for the rider...");
        }
    }

    public HashMap<Integer, TripMetaData> getTripsMetaDataMap() {
        return tripsMetaDataMap;
    }

    public HashMap<Integer, Trip> getTripsMap() {
        return tripsMap;
    }


}

