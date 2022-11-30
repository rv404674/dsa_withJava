package CabBooking.services;

import CabBooking.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookingService {
    HashMap<Integer, List<Ride>> rideStorage;

    LocationService locationService;
    PremiumService premiumService;

    public BookingService(HashMap<Integer, List<Ride>> rideStorage, LocationService locationService) {
        this.rideStorage = rideStorage;
        this.locationService = locationService;
    }


    // NOTE: get cab based on location, or any other service
    // FIXME: can optimie this a bit.
    // 1. first fetch nearest cab (lets say 10)
    // 2. then apply a cabMatchingStrategy to find a suitable cab.
    public void bookCab(Rider rider, Location destinationLocation, ISearchPolicy searchPolicy){
//        Cab cab2 = premiumService.getCab(rider);
        Cab nearestCab = searchPolicy.getCab(rider);
        int distance = locationService.getDistance(rider.getLocation(), destinationLocation);

        // ride Booked
        Ride rideObject = new Ride(24, rider.getLocation(), destinationLocation, distance, nearestCab);
        rideObject.setFare(computeFare(distance));

        // ride completed
        rideObject.setRideStatus(RideStatus.ENDED);
        if(!rideStorage.containsKey(rider.getRiderId()))
            rideStorage.put(rider.getRiderId(), new ArrayList<>());
        rideStorage.get(rider.getRiderId()).add(rideObject);
    }

    public int computeFare(int distance){
        return distance * 5;
    }
}
