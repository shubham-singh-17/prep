package airline.booking.store;

import airline.booking.entity.FlightSeat;
import java.util.HashMap;
import java.util.Map;

public class FlightSeatStore {

    private final Map<String, FlightSeat> flightSeatMap;

    public FlightSeatStore() {
        this.flightSeatMap = new HashMap<>();
    }

    public Map<String, FlightSeat> getFlightSeatMap() {
        return flightSeatMap;
    }

    public void addFlightSeat(FlightSeat flightSeat) {
        flightSeatMap.put(flightSeat.getReferenceId(), flightSeat);
    }
}
