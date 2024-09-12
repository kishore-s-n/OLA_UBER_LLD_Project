package UBER_LLD_CODE.Managers;

import UBER_LLD_CODE.Models.Rider;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RiderManager {
    // Singleton instance
    private static RiderManager riderMgrInstance = null;
    private static final Lock lock = new ReentrantLock();

    // Riders map (similar to unordered_map in C++)
    private HashMap<String, Rider> ridersMap = new HashMap<>();

    // Private constructor to prevent instantiation
    private RiderManager() {}

    // Static method to get the singleton instance
    public static RiderManager getRiderManager() {
        if (riderMgrInstance == null) {
            // Use lock to ensure thread-safety
            lock.lock();
            try {
                if (riderMgrInstance == null) {
                    riderMgrInstance = new RiderManager();
                }
            } finally {
                lock.unlock();
            }
        }
        return riderMgrInstance;
    }

    // Add a rider to the map
    public void addRider(String pRiderName, Rider pRider) {
        lock.lock();
        try {
            ridersMap.put(pRiderName, pRider);
        } finally {
            lock.unlock();
        }
    }

    // Retrieve a rider from the map
    public Rider getRider(String pRiderName) {
        lock.lock();
        try {
            return ridersMap.get(pRiderName);
        } finally {
            lock.unlock();
        }
    }
}
