package airline.booking.store;

import airline.booking.entity.Passenger;
import java.util.HashMap;
import java.util.Map;

public class PassengerStore {

    private final Map<String, Passenger> passengerMap;

    public PassengerStore() {
        this.passengerMap = new HashMap<>();
    }

    public Map<String, Passenger> getPassengerMap() {
        return passengerMap;
    }

    public void addPassenger(Passenger passenger) {
        passengerMap.put(passenger.getReferenceId(), passenger);
    }
}
