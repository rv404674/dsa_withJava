package CabBooking;

public class Driver {
    private int driverId;
    private Cab cab;
    private String name;
    private Availaibility availaibility;

    public Driver(int driverId, Cab cab, String name, Availaibility availaibility) {
        this.driverId = driverId;
        this.cab = cab;
        this.name = name;
        this.availaibility = availaibility;
    }

    public int getDriverId() {
        return driverId;
    }

    public Cab getCab() {
        return cab;
    }

    public String getName() {
        return name;
    }

    public Availaibility getAvailaibility() {
        return availaibility;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public void setAvailaibility(Availaibility availaibility) {
        this.availaibility = availaibility;
    }
}
