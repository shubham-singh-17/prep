package airline.booking.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Flight {

    private final String referenceId;
    private final String flightNumber;
    private int numOfSeats;
    private String arrivalAirport; // This is airport referenceId
    private String departureAirport; // This is airport referenceId
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private final List<String> flightSeats; // These are the references of flight seats;

    public Flight(
        String flightNumber, int numOfSeats, String arrivalAirport, String departureAirport, LocalDateTime departureTime,
        LocalDateTime arrivalTime
    ) {
        this.referenceId = UUID.randomUUID().toString();
        this.flightNumber = flightNumber;
        this.numOfSeats = numOfSeats;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightSeats = new ArrayList<>();
    }

    public String getReferenceId() {
        return referenceId;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public List<String> getFlightSeats() {
        return flightSeats;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    // While setting departureTime and arrivalTime we can have a check if the arrivalTime is not greater than departureTime
    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public long durationInMinutes() {
        return Duration.between(arrivalTime, departureTime).toMinutes();
    }

    public void addSeat(String referenceId) {
        this.flightSeats.add(referenceId);
    }
}
