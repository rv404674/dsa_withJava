package ParkingLot;

import ParkingLot.Vehicles.ParkingLot;
import ParkingLot.Vehicles.Vehicle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        ParkingLot parkingLot = null;
        ParkingService parkingService = new ParkingService();

        // this hashtables will be used as DB
        HashMap<Integer, ParkingFloor> floorHashMap = new HashMap<>();
        // use for easy access during unpark
        HashMap<String, Vehicle> ticketHashMap = new HashMap<>();

        while(scanner.hasNext()){
            String input = scanner.next();
            // TODO:
            // process this and so something.
            // park_vehicle CAR KA-01-DB-1234 black
            // unpark_vehicle PR1234_2_5
            String[] tokens = input.split(" ");
            if (Objects.equals(tokens[0], "create_parking_lot")){
                // TODO: put this in parkingCreateServiceLater
                // create_parking_lot PR1234 2 6

                int floor = Integer.parseInt(tokens[2]);
                int slots = Integer.parseInt(tokens[3]);
                parkingLot = new ParkingLot(tokens[1], floor, slots);

                for( int i=1; i<=floor; i++){
                    ParkingFloor parkingFloor = new ParkingFloor(i, slots);
                    floorHashMap.put(i, parkingFloor);
                }

                System.out.println("Parking lot created");
                System.out.println(Arrays.asList(floorHashMap));
            } else if (Objects.equals(tokens[0], "park_vehicle")) {
                String vehicleType = tokens[1];
                String registrationNumber = tokens[2];
                String color = tokens[3];

                Ticket ticket= parkingService.parkVehicle(parkingLot, floorHashMap, vehicleType, registrationNumber, color) ;
                if (ticket == null){
                    System.out.println("Parking Lot Full\n");
                } else {
                    Vehicle vehicle = VehicleFactory.getVehicle(vehicleType, registrationNumber, color, ticket.slotNo, ticket.floorNo);
                    String ticketId = ticket.getTicketId();

                    System.out.println("Parked vehicle. Ticket ID:" + ticketId);
                    ticketHashMap.put(ticketId, vehicle);
                }

            } else {
                String ticketId = tokens[1];
                if(!ticketHashMap.containsKey(ticketId)){
                    System.out.println("Invalid ticket");
                } else {
                    parkingService.unparkVehicle(floorHashMap, ticketHashMap, ticketId);
                }

            }


        }
    }
}
