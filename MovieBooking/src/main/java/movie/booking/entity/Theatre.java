package movie.booking.entity;

import java.util.List;

public class Theatre extends BaseEntity {

    private final String name;
    private final String location; // For simplicity keeping it string, it should be a complete LocationObject
    private final List<String> screens;

    public Theatre(String name, String location, List<String> screens) {
        this.name = name;
        this.location = location;
        this.screens = screens;
    }

    public List<String> getScreens() {
        return screens;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
