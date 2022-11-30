package CabBooking.services;

import CabBooking.Cab;
import CabBooking.Location;

import java.util.HashMap;

public class CabService {
    HashMap<Integer, Cab> cabHashMap;

    public CabService(HashMap<Integer, Cab> cabHashMap) {
        this.cabHashMap = cabHashMap;
    }

    public void registerCab(Cab cab){
        cabHashMap.put(cab.getCabId(), cab);
    }

    public void updateCabLocation(int cabId, Location newLocation){
        cabHashMap.get(cabId).setLocation(newLocation);
    }

    public Cab getCabInfo(int cabId){
        return cabHashMap.get(cabId);
    }
}
