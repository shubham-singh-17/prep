package movie.booking.entity;

import movie.booking.model.enums.SeatStatus;

public class ShowSeat extends BaseEntity {

    private final String seatId;
    private SeatStatus status;
    private final int price; // Keeping price static for simplicity
    private String user;

    public ShowSeat(String seatId, int price) {
        this.status = SeatStatus.AVAILABLE;
        this.seatId = seatId;
        this.price = price;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public String getSeatId() {
        return seatId;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public String getUser() {
        return user;
    }
}
