package movie.booking.entity;

import java.util.ArrayList;
import java.util.List;

public class Screen extends BaseEntity {

    private final int screenNumber;
    private final List<String> seats;

    public Screen(int screenNumber) {
        this.screenNumber = screenNumber;
        this.seats = new ArrayList<>();
    }

    public List<String> getSeats() {
        return seats;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void addSeats(String seatId) {
        seats.add(seatId);
    }
}
