package cab.booking.utils;

import cab.booking.models.Location;

public class LocationUtils {

    public static double calculateDistance(Location origin, Location destination) {
        return Math.sqrt(
            Math.pow(origin.getLatitude() - destination.getLatitude(), 2)
                + Math.pow(origin.getLongitude() - destination.getLongitude(), 2)
        );
    }
}
