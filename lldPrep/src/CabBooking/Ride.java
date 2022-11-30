package CabBooking;

public class Ride {
    private int rideId;
    private Location startLocation;
    private Location endLocation;
    private int fare;
    private int distance;
    private Cab cabAssigned;
    private RideStatus rideStatus;

    public Ride(int rideId, Location startLocation, Location endLocation, int distance, Cab cab) {
        this.rideId = rideId;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;
        this.rideStatus = RideStatus.BOOKED;
        this.cabAssigned = cab;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}