package movie.booking.model;

import movie.booking.model.enums.SeatType;

public class UserSeatType {

    private final String userId;
    private final SeatType seatType;

    public UserSeatType(String userId, SeatType seatType) {
        this.userId = userId;
        this.seatType = seatType;
    }

    public String getUserId() {
        return userId;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
