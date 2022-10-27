package ParkingLot.Vehicles;

public enum VehicleType {
    TRUCK,
    BIKE,
    CAR;

    public VehicleType getTypeFromString(String type){
        if (type == VehicleType.TRUCK.name()) {
            return VehicleType.TRUCK;
        } else if (type == VehicleType.BIKE.name()) {
            return VehicleType.BIKE;
        } else {
            return VehicleType.CAR;
        }
    }

}
