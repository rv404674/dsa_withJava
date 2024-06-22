package ParkingLot;

// FIXME: use singleton here
public class ParkingLot {
    private static volatile ParkingLot instance = null;
    private String parkingLotId;
    private int parkingFloor;
    private int parkingSlots;

    private ParkingLot(String parkingLotId, int parkingFloor, int parkingSlots){
        this.parkingLotId = parkingLotId;
        this.parkingFloor = parkingFloor;
        this.parkingSlots = parkingSlots;
    }

    // NOTE: you can use simple synchronized as well
    // but I am using double check lock
    public static ParkingLot getInstance(String parkingLotId, int parkingFloor, int parkingSlots){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null)
                    instance = new ParkingLot(parkingLotId, parkingFloor, parkingSlots);
            }
        }
        return instance;
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