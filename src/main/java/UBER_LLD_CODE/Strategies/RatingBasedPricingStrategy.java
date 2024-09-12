package UBER_LLD_CODE.Strategies;

import UBER_LLD_CODE.TripMetaData;

public class RatingBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetaData trip) {
        boolean isHighRating=trip.getRiderRating()>4;
        double price= isHighRating?55.0:65.0;
        if(isHighRating){
            System.out.println("This rider has high rating of "+trip.getRiderRating()+" so the price is being determined as "+price);
        }else{
            System.out.println("This rider has low rating of "+trip.getRiderRating()+" so the price is being determined as "+price);
        }
        return price;
    }
}
