package cab.booking.strategy.pricing;

import cab.booking.models.Location;

public interface PricingStrategy {

    double calculateFare(Location origin, Location destination);
}
