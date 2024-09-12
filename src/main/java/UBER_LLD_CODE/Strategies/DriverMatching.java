package UBER_LLD_CODE.Strategies;

import UBER_LLD_CODE.TripMetaData;

import UBER_LLD_CODE.Models.Driver;

public interface DriverMatching {
    public abstract Driver matchDriver(TripMetaData tripMetaData);
}

