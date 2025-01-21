package airline.booking.store;

import airline.booking.entity.Flight;
import java.util.HashMap;
import java.util.Map;

public class FlightStore {

    private final Map<String, Flight> flightMap;

    public FlightStore() {
        this.flightMap = new HashMap<>();
    }

    public Map<String, Flight> getFlightMap() {
        return flightMap;
    }

    public void addFlight(Flight flight) {
        flightMap.put(flight.getReferenceId(), flight);
    }
}
