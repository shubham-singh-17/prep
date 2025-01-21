package cab.booking.strategy.cabselection;

import cab.booking.entities.Cab;
import cab.booking.models.Location;
import java.util.List;

public interface CabSelectionStrategy {

    Cab selectCab(List<Cab> cabs, Location pickupLocation);
}
