package cab.booking.service;

import cab.booking.entities.Cab;
import cab.booking.entities.Rider;
import cab.booking.entities.Trip;
import cab.booking.store.CabStore;
import cab.booking.store.RiderStore;
import cab.booking.store.TripStore;
import java.util.Map;

public class EntityService {

    private final CabStore cabStore;
    private final RiderStore riderStore;
    private final TripStore tripStore;

    public EntityService() {
        this.cabStore = new CabStore();
        this.riderStore = new RiderStore();
        this.tripStore = new TripStore();
    }

    public Map<String, Cab> getCabs() {
        return cabStore.getEntityMap();
    }

    public void saveCab(Cab cab) {
        cabStore.addEntity(cab);
    }

    public Map<String, Rider> getRiders() {
        return riderStore.getEntityMap();
    }

    public void saveRider(Rider rider) {
        riderStore.addEntity(rider);
    }

    public Map<String, Trip> getTrips() {
        return tripStore.getEntityMap();
    }

    public void saveTrip(Trip trip) {
        tripStore.addEntity(trip);
    }
}
