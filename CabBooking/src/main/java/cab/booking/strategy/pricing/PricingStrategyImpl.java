package cab.booking.strategy.pricing;

import cab.booking.models.Location;
import static cab.booking.utils.LocationUtils.calculateDistance;

public class PricingStrategyImpl implements PricingStrategy {

    private static final double BASE_FARE = 40.0;
    private static final double PER_KM_FARE = 10.0;

    @Override
    public double calculateFare(Location origin, Location destination) {
        return BASE_FARE + PER_KM_FARE * calculateDistance(origin, destination);
    }
}
