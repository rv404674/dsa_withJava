package CabBooking.services;

import CabBooking.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class LocationService implements ISearchPolicy{
    HashMap<Integer, Driver> driverHashMap;

    public LocationService(HashMap<Integer, Driver> driverHashMap) {
        this.driverHashMap = driverHashMap;
    }

    // searchbasedonAvailaibiluty
    // FIXME: what if I want to book a PremiumCab
    public Cab getCab(Rider rider){
        Location riderlocation = rider.getLocation();
        Cab nearestCab = null;
        int distance = Integer.MAX_VALUE;

        Iterator hMIterator = driverHashMap.entrySet().iterator();
        while(hMIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry) hMIterator.next();
            Driver driver = (Driver) mapElement.getValue();

            // check availability
            if(driver.getAvailaibility() == Availaibility.AVAILAIBLE){
                int curDistance = getDistance(driver.getCab().getLocation(), riderlocation);
                if(curDistance < distance) {
                    nearestCab = driver.getCab();
                    distance = curDistance;
                }
            }
        }

        return nearestCab;
    }

    public int getDistance(Location l1, Location l2){
        return (int)Math.sqrt( Math.pow((l2.getX() - l1.getX()), 2) + Math.pow((l2.getY() - l1.getY()), 2));
    }

}

