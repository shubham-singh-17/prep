package airline.booking.store;

import airline.booking.entity.Airport;
import java.util.HashMap;
import java.util.Map;

public class AirportStore {

    private final Map<String, Airport> airportMap;

    public AirportStore() {
        this.airportMap = new HashMap<>();
    }

    public Map<String, Airport> getAirportMap() {
        return airportMap;
    }

    public void addAirport(Airport airport) {
        airportMap.put(airport.getReferenceId(), airport);
    }
}
