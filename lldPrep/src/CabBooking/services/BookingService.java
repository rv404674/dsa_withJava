package CabBooking.services;

import CabBooking.*;

import java.util.HashMap;

public class BookingService {
    HashMap<Integer, Ride> rideStorage;
    LocationService locationService;
    PremiumService premiumService;

    public BookingService(HashMap<Integer, Ride> rideStorage, LocationService locationService) {
        this.rideStorage = rideStorage;
        this.locationService = locationService;
    }


    // NOTE: get cab based on location, or any other service
    public void bookCab(Rider rider, Location destinationLocation, ISearchPolicy searchPolicy){
//        Cab cab2 = premiumService.getCab(rider);
        Cab nearestCab = searchPolicy.getCab(rider);
        int distance = locationService.getDistance(rider.getLocation(), destinationLocation);

        // ride Booked
        Ride rideObject = new Ride(24, rider.getLocation(), destinationLocation, distance, nearestCab);
        rideObject.setFare(computeFare(distance));

        // ride completed
        rideObject.setRideStatus(RideStatus.ENDED);
        rideStorage.put(rider.getRiderId(), rideObject);
    }

    public int computeFare(int distance){
        return distance * 5;
    }
}
