package CabBooking.services;

import CabBooking.Cab;
import CabBooking.Rider;

public interface ISearchPolicy {
    public Cab getCab(Rider rider);
}
