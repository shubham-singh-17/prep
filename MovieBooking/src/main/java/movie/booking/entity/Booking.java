package movie.booking.entity;

import java.util.List;

public class Booking extends BaseEntity {
    private final List<String> seats; // ShowSeat id
    private final String show; // Show id
    private final int cost;

    public Booking(List<String> seats, String show, int cost) {
        this.seats = seats;
        this.show = show;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public List<String> getSeats() {
        return seats;
    }

    public String getShow() {
        return show;
    }
}
