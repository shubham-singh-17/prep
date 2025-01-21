package cab.booking.service;

import cab.booking.entities.Rider;
import static cab.booking.models.DemoConstant.DEMO_DRIVER_1_NAME;
import static cab.booking.models.DemoConstant.DEMO_DRIVER_2_NAME;
import static cab.booking.models.DemoConstant.DEMO_DRIVER_3_NAME;
import static cab.booking.models.DemoConstant.DEMO_DROP_LOCATION;
import static cab.booking.models.DemoConstant.DEMO_LOCATION_1;
import static cab.booking.models.DemoConstant.DEMO_LOCATION_2;
import static cab.booking.models.DemoConstant.DEMO_LOCATION_3;
import static cab.booking.models.DemoConstant.DEMO_PHONE_NUMBER;
import static cab.booking.models.DemoConstant.DEMO_RIDER_1_NAME;
import static cab.booking.models.DemoConstant.DEMO_RIDER_2_NAME;
import static cab.booking.models.DemoConstant.DEMO_RIDER_3_NAME;
import static cab.booking.models.DemoConstant.DEMO_TRIP_LOCATION_1;
import static cab.booking.models.DemoConstant.DEMO_TRIP_LOCATION_2;
import static cab.booking.models.DemoConstant.DEMO_TRIP_LOCATION_3;
import static cab.booking.models.DemoConstant.DEMO_VEHICLE_2;
import static cab.booking.models.DemoConstant.DEMO_VEHICLE_3;
import static cab.booking.models.DemoConstant.DEMO_VEHICLE_1;
import cab.booking.models.Location;
import cab.booking.strategy.cabselection.CabSelectionImpl;
import cab.booking.strategy.pricing.PricingStrategyImpl;

public class DemoService {

    private final EntityService entityService;
    private final TripService tripService;
    private final CabService cabService;
    private final RiderService riderService;
    private final BookingService bookingService;

    public DemoService() {
        this.entityService = new EntityService();
        this.tripService = new TripService(entityService);
        this.cabService = new CabService(entityService);
        this.riderService = new RiderService(entityService);
        this.bookingService = new BookingService(
            entityService, cabService, tripService, new PricingStrategyImpl(), new CabSelectionImpl()
        );
    }

    public void demo() {
        registerCabs();
        Rider rider1 = registerRider(DEMO_RIDER_1_NAME);
        Rider rider2 = registerRider(DEMO_RIDER_2_NAME);
        Rider rider3 = registerRider(DEMO_RIDER_3_NAME);

        makeAllCabsAvailable();

        bookCabForRider(rider1, DEMO_TRIP_LOCATION_1);
        bookCabForRider(rider2, DEMO_TRIP_LOCATION_2);
        bookCabForRider(rider3, DEMO_TRIP_LOCATION_3);
    }

    private Rider registerRider(String name) {
        return riderService.registerRider(name, DEMO_PHONE_NUMBER);
    }

    private void bookCabForRider(Rider rider, Location pickUpLocation) {
        bookingService.bookCab(rider, pickUpLocation, DEMO_DROP_LOCATION);
    }

    private void makeAllCabsAvailable() {
        entityService.getCabs().values().forEach(cabService::makeCabAvailable);
    }

    private void registerCabs() {
        cabService.registerCab(DEMO_DRIVER_1_NAME, DEMO_PHONE_NUMBER, DEMO_VEHICLE_1, DEMO_LOCATION_1);
        cabService.registerCab(DEMO_DRIVER_2_NAME, DEMO_PHONE_NUMBER, DEMO_VEHICLE_2, DEMO_LOCATION_2);
        cabService.registerCab(DEMO_DRIVER_3_NAME, DEMO_PHONE_NUMBER, DEMO_VEHICLE_3, DEMO_LOCATION_3);
    }
}
