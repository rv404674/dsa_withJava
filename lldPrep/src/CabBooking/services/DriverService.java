package CabBooking.services;

import CabBooking.Availaibility;
import CabBooking.Driver;

import java.util.HashMap;

public class DriverService {
    HashMap<Integer, Driver> driverHashMap;
    CabService cabService;

    public DriverService(HashMap<Integer, Driver> driverHashMap, CabService cabService) {
        this.driverHashMap = driverHashMap;
        this.cabService = cabService;
    }

    public void registerDriver(Driver driver, int cabId){
        driver.setCab(cabService.getCabInfo(cabId));
        driverHashMap.put(driver.getDriverId(), driver);
    }

    public void setDriverAvailaibility(Driver driver, Availaibility availaibility){
        driverHashMap.get(driver.getDriverId()).setAvailaibility(availaibility);
    }
}
