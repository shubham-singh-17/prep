package cab.booking.strategy.cabselection;

import cab.booking.entities.Cab;
import cab.booking.models.CabStatus;
import cab.booking.models.Location;
import static cab.booking.utils.LocationUtils.calculateDistance;
import java.util.List;

public class CabSelectionImpl implements CabSelectionStrategy {

    private static final double MAX_DISTANCE = 10;

    @Override
    public Cab selectCab(List<Cab> cabs, Location pickupLocation) {
        Cab selectedCab = null;
        double selectedCabDistance = MAX_DISTANCE + 1;

        for (Cab cab: cabs) {
            if (cab.getStatus() == CabStatus.AVAILABLE) {
                double distance = calculateDistance(cab.getCurrentLocation(), pickupLocation);

                if (distance < selectedCabDistance && distance <= MAX_DISTANCE) {
                    selectedCab = cab;
                    selectedCabDistance = distance;
                }
            }
        }

        return selectedCab;
    }
}
