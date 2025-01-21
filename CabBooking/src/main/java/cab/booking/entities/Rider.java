package cab.booking.entities;

public class Rider extends BaseEntity {

    private final String name;
    private final String phoneNumber;

    public Rider(String name, String phoneNumber) {
        super();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
