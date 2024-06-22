package CabBooking;

public class Cab {
    private int cabId;
    private Location location;
    private String licenseNumber;
    private String name;

    public Cab(int cabId, Location location, String licenseNumber, String name) {
        this.cabId = cabId;
        this.location = location;
        this.licenseNumber = licenseNumber;
        this.name = name;
    }

    public int getCabId() {
        return cabId;
    }

    public Location getLocation() {
        return location;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
