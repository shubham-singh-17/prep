package airline.booking.service;

import airline.booking.entity.Airport;
import airline.booking.entity.Flight;
import airline.booking.model.enums.SeatStatus;
import airline.booking.model.enums.SeatType;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class TestService {

    private final BookingService bookingService;

    public TestService() {
        this.bookingService = new BookingService();
    }

    public void demo() {
        String dummyAirport1 = "Bengaluru";
        String dummyAirport2 = "Delhi";

        Airport airport1 = createDummyAirport(dummyAirport1);
        Airport airport2 = createDummyAirport(dummyAirport2);

        Flight flight = createDummyFlight(airport1, airport2);

        String dummyPassenger1 = "Shubham";
        String dummyPassenger2 = "Divyanshu";

        bookDummyFlightForPassenger(dummyPassenger1, flight, SeatType.BUSINESS);
        bookDummyFlightForPassenger(dummyPassenger2, flight, SeatType.ECONOMY);
    }

    // For simplicity, I am treating airportName same as airportLocation
    private Airport createDummyAirport(String airportName) {
        return bookingService.addAirport(airportName, airportName);
    }

    private Flight createDummyFlight(Airport departureAirport, Airport arrivalAirport) {
        LocalDateTime dummyArrivalTime = LocalDateTime.of(2024, 10, 2, 10, 0);
        LocalDateTime dummyDepartureTime = LocalDateTime.of(2024, 10, 2, 8, 0);
        String dummyFlightNumber = "ABC123";

        Flight flight = bookingService.addFlight(dummyFlightNumber, 50, arrivalAirport.getReferenceId(),
            departureAirport.getReferenceId(), dummyArrivalTime, dummyDepartureTime);

        addSeats(flight);

        return flight;
    }

    private void addSeats(Flight flight) {
        int businessClassPrice = 20000;
        int economyClassPrice = 3000;

        IntStream.rangeClosed(1, 10)
            .forEach(
                it -> bookingService.addFlightSeat(flight, businessClassPrice, SeatStatus.AVAILABLE,
                    SeatType.BUSINESS, String.valueOf(it))
            );

        IntStream.rangeClosed(11, 50)
            .forEach(
                it -> bookingService.addFlightSeat(flight, economyClassPrice, SeatStatus.AVAILABLE,
                    SeatType.ECONOMY, String.valueOf(it))
            );
    }

    private void bookDummyFlightForPassenger(String passengerName, Flight flight, SeatType seatType) {
        String dummyMobileNumber = "7599324163";
        String dummyEmailId = "abc@gmail.com";

        bookingService.bookFlight(passengerName, dummyEmailId, dummyMobileNumber, flight, seatType);
    }
}
