package UBER_LLD_CODE.Strategies;

import UBER_LLD_CODE.TripMetaData;

public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetaData trip){
        double price=100.0;
        System.out.println("The default pricing is used for this trip, which gives us the price of "+price);
        return price;
    }
}
