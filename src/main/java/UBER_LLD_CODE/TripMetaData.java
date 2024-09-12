package UBER_LLD_CODE;

import UBER_LLD_CODE.Models.Location;

public class TripMetaData {

    private Location srcLoc;
    private Location dstLoc;
    private int riderRating;
    private int driverRating;

    public TripMetaData(Location srcLoc, Location dstLoc, int riderRating) {
        this.srcLoc = srcLoc;
        this.dstLoc = dstLoc;
        this.riderRating = riderRating;
        this.driverRating = 0;
    }

    public Location getDstLoc() {
        return dstLoc;
    }
    public Location getSrcLoc() {
        return srcLoc;
    }

    public void setSrcLoc(Location srcLoc) {
        this.srcLoc = srcLoc;
    }

    public void setDstLoc(Location dstLoc) {
        this.dstLoc = dstLoc;
    }

    public void setRiderRating(int riderRating) {
        this.riderRating = riderRating;
    }

    public int getRiderRating() {
        return riderRating;
    }

    public int getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(int driverRating) {
        this.driverRating = driverRating;
    }

}
