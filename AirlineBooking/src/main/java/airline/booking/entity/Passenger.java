package airline.booking.entity;

public class Passenger extends BaseEntity {

    private final String name;
    private String emailId;
    private final String phoneNumber;

    public Passenger(String name, String emailId, String phoneNumber) {
        super();
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
