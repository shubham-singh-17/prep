package movie.booking.entity;

public class Movie extends BaseEntity {

    private final String name;
    private final int durationInMinutes;

    public Movie(String name, int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getName() {
        return name;
    }
}
