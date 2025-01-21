package cab.booking.service;

import cab.booking.entities.Cab;
import cab.booking.entities.Rider;
import cab.booking.models.Location;
import cab.booking.strategy.cabselection.CabSelectionStrategy;
import cab.booking.strategy.pricing.PricingStrategy;
import static cab.booking.utils.LocationUtils.calculateDistance;
import java.util.ArrayList;
import java.util.Objects;

public class BookingService {

    private final EntityService entityService;
    private final CabService cabService;
    private final TripService tripService;
    private final PricingStrategy pricingStrategy;
    private final CabSelectionStrategy cabSelectionStrategy;

    public BookingService(
        EntityService entityService, CabService cabService, TripService tripService, PricingStrategy pricingStrategy,
        CabSelectionStrategy cabSelectionStrategy
    ) {
        this.entityService = entityService;
        this.cabService = cabService;
        this.tripService = tripService;
        this.pricingStrategy = pricingStrategy;
        this.cabSelectionStrategy = cabSelectionStrategy;
    }

    public void bookCab(Rider rider, Location pickupLocation, Location dropLocation) {
        Cab cab = cabSelectionStrategy.selectCab(new ArrayList<>(entityService.getCabs().values()), pickupLocation);
        if (Objects.isNull(cab)) {
            System.out.printf("No cabs available at the moment for rider %s. Please try again later.%n", rider.getName());
            return;
        }

        double fare = pricingStrategy.calculateFare(pickupLocation, dropLocation);

        cabService.cabBooked(cab);
        tripService.bookTrip(rider, cab, pickupLocation, dropLocation, fare);

        System.out.printf(
            "Trip booked successfully. Trip details { RiderName: %s, DriverName: %s, tripPrice: %s, tripDistance: %s}%n",
            rider.getName(), cab.getDriverName(), fare, calculateDistance(pickupLocation, dropLocation)
        );
    }
}
