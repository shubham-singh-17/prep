package airline.booking.entity;

import java.util.UUID;

public class Airport {

    private final String referenceId;
    private final String name;
    private final String location; // This should be a location object but for simplicity I am keeping it as string

    public Airport(String name, String location) {
        this.referenceId = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getReferenceId() {
        return referenceId;
    }
}
