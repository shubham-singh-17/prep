package movie.booking.entity;

public class User extends BaseEntity {
    private final String name;
    private final String mobileNumber;


    public User(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
