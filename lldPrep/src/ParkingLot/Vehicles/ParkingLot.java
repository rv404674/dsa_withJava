package ParkingLot.Vehicles;

public class ParkingLot {
    String parkingLotId;
    int parkingFloor;
    int parkingSlots;

    public ParkingLot(String parkingLotId, int parkingFloor, int parkingSlots) {
        this.parkingLotId = parkingLotId;
        this.parkingFloor = parkingFloor;
        this.parkingSlots = parkingSlots;
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public int getParkingFloor() {
        return parkingFloor;
    }

    public int getParkingSlots() {
        return parkingSlots;
    }
}
