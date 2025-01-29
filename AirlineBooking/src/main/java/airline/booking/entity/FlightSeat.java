package airline.booking.entity;

import airline.booking.model.enums.SeatStatus;
import airline.booking.model.enums.SeatType;
import java.util.UUID;

public class FlightSeat extends Seat {

    private int price; // It should be a money object with currency mentioned
    private SeatStatus status;
    private String passenger; // Passenger referenceId

    public FlightSeat(String seatNumber, SeatType seatType, int price, SeatStatus status) {
        super(seatNumber, seatType);
        this.status = status;
        this.price = price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public int getPrice() {
        return price;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
