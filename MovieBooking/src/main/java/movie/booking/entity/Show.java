package movie.booking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show extends BaseEntity {
    private final String movie;
    private final LocalDateTime from;
    private final LocalDateTime to;
    private final LocalDate date;
    private final String theatre;
    private final String screen;
    private final List<String> showSeats;

    public Show(String movie, LocalDateTime from, LocalDateTime to, String theatre, String screen) {
        this.movie = movie;
        this.theatre = theatre;
        this.date = from.toLocalDate();
        this.from = from;
        this.to = to;
        this.screen = screen;
        this.showSeats = new ArrayList<>();
    }

    public void addShowSeats(String showSeatId) {
        showSeats.add(showSeatId);
    }

    public List<String> getShowSeats() {
        return showSeats;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMovie() {
        return movie;
    }

    public String getScreen() {
        return screen;
    }

    public String getTheatre() {
        return theatre;
    }

    public LocalDateTime getTo() {
        return to;
    }
}
