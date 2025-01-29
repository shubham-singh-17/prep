package airline.booking.service;

import airline.booking.entity.Airport;
import airline.booking.entity.Flight;
import airline.booking.entity.FlightSeat;
import airline.booking.entity.Passenger;
import airline.booking.store.AirportStore;
import airline.booking.store.FlightSeatStore;
import airline.booking.store.FlightStore;
import airline.booking.store.PassengerStore;

import java.util.Map;

public class EntityService {

    private final AirportStore airportStore;
    private final FlightStore flightStore;
    private final FlightSeatStore flightSeatStore;
    private final PassengerStore passengerStore;

    public EntityService() {
        this.airportStore = new AirportStore();
        this.flightSeatStore = new FlightSeatStore();
        this.flightStore = new FlightStore();
        this.passengerStore = new PassengerStore();
    }

    public void addFlightSeat(FlightSeat flightSeat) {
        flightSeatStore.addEntity(flightSeat);
    }

    public Map<String, FlightSeat> getFlightSeatMap() {
        return flightSeatStore.getEntityMap();
    }

    public Map<String, Airport> getAirportMap() {
        return airportStore.getEntityMap();
    }

    public void addPassenger(Passenger passenger) {
        passengerStore.addEntity(passenger);
    }

    public void addFlight(Flight flight) {
        flightStore.addEntity(flight);
    }

    public void addAirport(Airport airport) {
        airportStore.addEntity(airport);
    }
}
