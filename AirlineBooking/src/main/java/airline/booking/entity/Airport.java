package airline.booking.entity;

public class Airport extends BaseEntity {

    private final String name;
    private final String location; // This should be a location object but for simplicity I am keeping it as string

    public Airport(String name, String location) {
        super();
        this.name = name;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
