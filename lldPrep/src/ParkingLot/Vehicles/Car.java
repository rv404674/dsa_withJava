package ParkingLot.Vehicles;

public class Car extends Vehicle{
    @Override
    public Vehicle getVehicle(String registrationNumber, String color, int slotNo, int floorNo) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = VehicleType.CAR;
        this.slotNo = slotNo;
        this.floorNo = floorNo;
        return this;
    }
}
