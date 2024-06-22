package ParkingLot.Vehicles;

public abstract class Vehicle {
    protected String registrationNumber;
    protected String color;
    protected VehicleType vehicleType;
    protected int slotNo;
    protected int floorNo;

    public abstract Vehicle getVehicle(String registrationNumber, String Color, int slotNo, int floorNo);

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public int getFloorNo() {
        return floorNo;
    }
}


