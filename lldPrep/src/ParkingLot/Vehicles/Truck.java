package ParkingLot.Vehicles;

import ParkingLot.Util;

public class Truck extends Vehicle{
    @Override
    public Vehicle getVehicle(String registrationNumber, String color, int slotNo, int floorNo) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = VehicleType.TRUCK;
        this.slotNo = slotNo;
        this.floorNo = floorNo;
        return this;
    }
}
