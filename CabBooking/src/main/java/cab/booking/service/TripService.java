package cab.booking.service;

import cab.booking.entities.Cab;
import cab.booking.entities.Rider;
import cab.booking.entities.Trip;
import cab.booking.models.Location;

public class TripService {

    private final EntityService entityService;

    public TripService(EntityService entityService) {
        this.entityService = entityService;
    }

    public void bookTrip(Rider rider, Cab cab, Location pickupLocation, Location dropLocation, double fare) {
        Trip trip = new Trip(rider.getId(), cab.getId(), pickupLocation, dropLocation, fare);
        entityService.saveTrip(trip);
    }
}
