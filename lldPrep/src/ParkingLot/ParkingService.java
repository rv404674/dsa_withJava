package ParkingLot;

import ParkingLot.Vehicles.Vehicle;
import ParkingLot.Vehicles.VehicleType;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

// FIXME: improve this.
public class ParkingService {
    public synchronized Ticket  parkVehicle(
             ParkingLot parkingLot,
            HashMap<Integer, ParkingFloor> floorList, String vehicleType, String registrationNumer, String color) {

        // park vehicle,
        // get slots for vehicle
        // lowest floor
        // lowest slot
        int floors = parkingLot.getParkingFloor();
        int slot = -1;
        int floor = -1;

        if (vehicleType.equals(VehicleType.CAR.name())) {
            for(int i=1; i<=floors; i++){
                ParkingFloor parkingFloor = floorList.get(i);
                if (parkingFloor.getCarSlots().isEmpty()) continue;
                else {
                    // got the floor
                    TreeSet<Integer> temp = parkingFloor.getCarSlots();
                    Iterator<Integer> iterator = temp.iterator();
                    slot = iterator.next();
                    floor = i;
                    temp.remove(slot);

                    // NOTE: reduce the parking slots available on that floor
                    parkingFloor.setCarSlots(temp);
                    floorList.put(i, parkingFloor);
                    break;
                }
            }

        }
        // TODO: add for bike.

        if (slot == -1) {
            return  null;
        }

        Ticket ticket = new Ticket(parkingLot.getParkingLotId(), floor, slot);
        return ticket;
    }


    public synchronized void unparkVehicle(
            HashMap<Integer, ParkingFloor> floorHashMap,
            HashMap<String, Vehicle> ticketHashMap,
            String ticketId
    ) {
        // unpark vehicle
        // check for validity
        // update the vehicle list
        // add the slot to the parkingFloor
        // update hasthable for floow
        // delete ticket from HT
        // return
        Vehicle vehicle = ticketHashMap.get(ticketId);
        int floor = vehicle.getFloorNo();
        int slot = vehicle.getSlotNo();

        ParkingFloor parkingFloor = floorHashMap.get(floor);
        if(vehicle.getVehicleType() == VehicleType.CAR){
            // add it in cars list
            TreeSet<Integer> carSlots = parkingFloor.getCarSlots();
            // FIXME: later, we want to show lowest slot first
            // not the first slots.
            carSlots.add(slot);
            parkingFloor.setCarSlots(carSlots);
        }
        // TODO: do it for cars and bike


        floorHashMap.put(floor, parkingFloor);
        ticketHashMap.remove(ticketId);
        //  WB-45-HO-9032 and Color: white

        System.out.println("Unparked vehicle with Registration Number:" + vehicle.getRegistrationNumber() + " " + vehicle.getColor());
    }
}
