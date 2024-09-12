package UBER_LLD_CODE.Managers;

import UBER_LLD_CODE.Strategies.*;
import UBER_LLD_CODE.TripMetaData;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StrategyManager {
    private static StrategyManager instance = new StrategyManager();
    private static final Lock locks= new ReentrantLock();
    public static StrategyManager getInstance() {
        if(instance == null){
            try{
                 locks.lock();
                 if(instance == null){
                    instance  = new StrategyManager();
                 }
            }finally{
                 locks.unlock();
            }
        }
        return instance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData tripMetaData){
        if(tripMetaData.getRiderRating()>3){
            return new RatingBasedPricingStrategy();
        }else{
            return new DefaultPricingStrategy();
        }
    }

    public DriverMatching determineDriverMatching(TripMetaData tripMetaData){
        if(tripMetaData.getRiderRating()>3){
            return new LeastTimeBasedMatching();
        }
        return new LeastTimeBasedMatching();
    }
}
