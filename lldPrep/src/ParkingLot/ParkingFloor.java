package ParkingLot;

import ParkingLot.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingFloor {
    private int floorNo;
    private int totalSlots;
    private List<Integer> truckSlots;
    private List<Integer> bikeSlots;
    private List<Integer> carSlots;
    // TODO: check later if you want to add VehicleList here itself.


    public ParkingFloor(int floorNo, int totalSlots) {
        this.floorNo = floorNo;
        this.totalSlots = totalSlots;
        this.truckSlots = new ArrayList<>();
        this.bikeSlots = new ArrayList<>();
        this.carSlots = new ArrayList<>();
        computeSlotLists();
    }

    private void computeSlotLists() {
        // NOTE: assuming no edge cases
        // min 4slots will be there atleast
        // 1 for truck, 2 for bike and rest for car
        for (int i=1; i<=totalSlots; i++){
            if(i<=1){
                truckSlots.add(i);
            } else if(i>=2 && i<=3) {
                bikeSlots.add(i);
            } else {
                carSlots.add(i);
            }
        }
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public List<Integer> getTruckSlots() {
        return truckSlots;
    }

    public List<Integer> getBikeSlots() {
        return bikeSlots;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void setTruckSlots(List<Integer> truckSlots) {
        this.truckSlots = truckSlots;
    }

    public void setBikeSlots(List<Integer> bikeSlots) {
        this.bikeSlots = bikeSlots;
    }

    public void setCarSlots(List<Integer> carSlots) {
        this.carSlots = carSlots;
    }

    public List<Integer> getCarSlots() {
        return carSlots;
    }
}
