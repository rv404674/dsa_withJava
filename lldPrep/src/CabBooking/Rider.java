package CabBooking;

public class Rider {
    private int riderId;
    private Location location;
    private String name;
    private String phoneNo;

    public Rider(int riderId, Location location, String name, String phoneNo) {
        this.riderId = riderId;
        this.location = location;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public int getRiderId() {
        return riderId;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
