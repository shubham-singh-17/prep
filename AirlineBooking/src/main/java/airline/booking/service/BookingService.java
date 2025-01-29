package airline.booking.service;

import airline.booking.entity.Airport;
import airline.booking.entity.Flight;
import airline.booking.entity.FlightSeat;
import airline.booking.entity.Passenger;
import airline.booking.model.enums.SeatStatus;
import airline.booking.model.enums.SeatType;
import airline.booking.store.AirportStore;
import airline.booking.store.FlightSeatStore;
import airline.booking.store.FlightStore;
import airline.booking.store.PassengerStore;
import java.time.LocalDateTime;
import java.util.Objects;

public class BookingService {

    private final EntityService entityService;

    public BookingService(EntityService entityService) {
        this.entityService = entityService;
    }

    public Airport addAirport(String name, String location) {
        Airport airport = new Airport(name, location);
        entityService.addAirport(airport);

        return airport;
    }

    public Flight addFlight(
        String flightNumber, int numOfSeats, String arrivalAirport, String departureAirport, LocalDateTime arrivalTime,
        LocalDateTime departureTime
    ) {
        Flight flight = new Flight(flightNumber, numOfSeats, arrivalAirport, departureAirport, arrivalTime, departureTime);
        entityService.addFlight(flight);

        return flight;
    }

    public void bookFlight(String name, String emailId, String phoneNumber, Flight flight, SeatType seatType) {
        Passenger passenger = new Passenger(name, emailId, phoneNumber);
        entityService.addPassenger(passenger);

        FlightSeat seat = getAvailableFlightSeat(flight, seatType);

        if (Objects.isNull(seat)) {
            System.out.println("No seats available while booking seat for passenger : " + name);
            return;
        }

        seat.setPassenger(passenger.getId());
        seat.setStatus(SeatStatus.TAKEN);

        log(name, flight, seat);
    }

    private void log(String name, Flight flight, FlightSeat seat) {
        System.out.printf(
            "Booking successful for passenger : %s, FlightNumber : %s, SeatNumber : %s, Price: %s, " +
                "DepartureAirport: %s, ArrivalAirport: %s, Duration: %s minutes, DepartureTime: %s%n",
            name, flight.getFlightNumber(), seat.getSeatNumber(), seat.getPrice(),
            entityService.getAirportMap().get(flight.getDepartureAirport()).getName(),
            entityService.getAirportMap().get(flight.getArrivalAirport()).getName(), flight.durationInMinutes(),
            flight.getDepartureTime()
        );
    }

    private FlightSeat getAvailableFlightSeat(Flight flight, SeatType seatType) {
        return flight.getFlightSeats().stream()
            .filter(it -> entityService.getFlightSeatMap().get(it).getStatus() == SeatStatus.AVAILABLE
                              && seatType.equals(entityService.getFlightSeatMap().get(it).getSeatType()))
            .map(it -> entityService.getFlightSeatMap().get(it))
            .findFirst()
            .orElse(null);
    }

    public void addFlightSeat(
        Flight flight, int price, SeatStatus seatStatus, SeatType seatType, String seatNumber
    ) {
        FlightSeat flightSeat = new FlightSeat(seatNumber, seatType, price, seatStatus);
        entityService.addFlightSeat(flightSeat);
        flight.addSeat(flightSeat.getId());
    }
}
