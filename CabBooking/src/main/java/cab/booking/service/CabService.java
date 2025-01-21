package cab.booking.service;

import cab.booking.entities.Cab;
import cab.booking.models.CabStatus;
import cab.booking.models.Location;
import cab.booking.models.VehicleInfo;

public class CabService {

    private final EntityService entityService;

    public CabService(EntityService entityService) {
        this.entityService = entityService;
    }

    public void registerCab(String driverName, String phoneNumber, VehicleInfo vehicleInfo, Location location) {
        Cab cab = new Cab(vehicleInfo, driverName, phoneNumber, location);
        entityService.saveCab(cab);
    }

    public void makeCabAvailable(Cab cab) {
        cab.setStatus(CabStatus.AVAILABLE);
    }

    public void cabBooked(Cab cab) {
        cab.setStatus(CabStatus.IN_RIDE);
    }
}
