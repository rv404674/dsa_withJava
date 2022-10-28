package ParkingLot;

import ParkingLot.Vehicles.Vehicle;

import java.util.*;

public class ParkingFloor {
    private int floorNo;
    private int totalSlots;
    private TreeSet<Integer> truckSlots;
    private TreeSet<Integer> bikeSlots;
    private TreeSet<Integer> carSlots;
    // TODO: check later if you want to add VehicleList here itself.


    public ParkingFloor(int floorNo, int totalSlots) {
        this.floorNo = floorNo;
        this.totalSlots = totalSlots;
        this.truckSlots = new TreeSet<>();
        this.bikeSlots = new TreeSet<>();
        this.carSlots = new TreeSet<>();
        computeSlotLists();
    }

    private void computeSlotLists() {
        // NOTE: assuming no edge cases
        // min 4slots will be there atleast
        // 1 for truck, 2 for bike and rest for car
        // NOTE: We are using TreeSet because we want the lowest on the first index always.
        // park car - remove 3
        // unpark
        // add - 3 now (3 should be picked)
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

    public TreeSet<Integer> getTruckSlots() {
        return truckSlots;
    }

    public TreeSet<Integer> getBikeSlots() {
        return bikeSlots;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public void setTruckSlots(TreeSet<Integer> truckSlots) {
        this.truckSlots = truckSlots;
    }

    public void setBikeSlots(TreeSet<Integer> bikeSlots) {
        this.bikeSlots = bikeSlots;
    }

    public void setCarSlots(TreeSet<Integer> carSlots) {
        this.carSlots = carSlots;
    }

    public TreeSet<Integer> getCarSlots() {
        return carSlots;
    }
}
