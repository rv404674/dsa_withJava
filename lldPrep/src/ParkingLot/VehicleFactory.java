package ParkingLot;


import ParkingLot.Vehicles.*;

public class VehicleFactory {

    public static Vehicle getVehicle(
            String type,
            String registrationNumber,
            String color,
            int slotNo,
            int floorNo
    ){
        switch (type){
            case "TRUCK" : {
                // 1 truck, 2 bike, 3 car
                Vehicle truck = new Truck();
                return truck.getVehicle(registrationNumber, color, slotNo, floorNo) ;
            }
            case "BIKE" : {
                Vehicle bike = new Bike();
                return bike.getVehicle(registrationNumber, color, slotNo, floorNo) ;
            }
            default: {
                Vehicle car = new Car();
                return car.getVehicle(registrationNumber, color, slotNo, floorNo);
            }
        }

    }


}
