package UBER_LLD_CODE.Managers;

import UBER_LLD_CODE.Models.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DriverManager {
    DriverManager() {}


    private static DriverManager instance = new DriverManager();
    private static final Lock locks=new ReentrantLock();

    private final HashMap<String, Driver> drivers=new HashMap<>();

    public static DriverManager getDriverManager() {
        if (instance == null) {
            locks.lock();
            try{
                if (instance == null) {
                    instance = new DriverManager();
                }
            }finally {
                locks.unlock();
            }
        }
        return instance;
    }

    public Driver getFirstAvailableDriver() {
        for (Map.Entry<String, Driver> entry : drivers.entrySet()) {
            return entry.getValue(); // Return the first driver encountered
        }
        return null; // In case the map is empty
    }

    public void addDriver(String driverName,Driver driver) {
        drivers.put(driverName,driver);
    }
    public Driver getDriver(String driverName) {
        return drivers.get(driverName);
    }

    public HashMap<String,Driver> getDrivers(){
        return drivers;
    }
}