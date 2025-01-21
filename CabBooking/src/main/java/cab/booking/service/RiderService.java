package cab.booking.service;

import cab.booking.entities.Rider;

public class RiderService {

    private final EntityService entityService;

    public RiderService(EntityService entityService) {
        this.entityService = entityService;
    }

    public Rider registerRider(String name, String phoneNumber) {
        Rider rider = new Rider(name, phoneNumber);
        entityService.saveRider(rider);

        return rider;
    }
}
