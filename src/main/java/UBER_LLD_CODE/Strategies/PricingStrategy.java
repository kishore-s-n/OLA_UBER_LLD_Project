package UBER_LLD_CODE.Strategies;

import UBER_LLD_CODE.TripMetaData;

public interface PricingStrategy {

    public abstract double calculatePrice(TripMetaData tripMetaData);
}
