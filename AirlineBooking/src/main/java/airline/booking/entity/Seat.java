package airline.booking.entity;

import airline.booking.model.enums.SeatType;

public class Seat {

    private final String seatNumber;
    private SeatType seatType;

    public Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
