package movie.booking.entity;

import movie.booking.model.enums.SeatType;

public class Seat extends BaseEntity {

    private final int seatNumber;
    private final SeatType seatType;

    public Seat(int seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
