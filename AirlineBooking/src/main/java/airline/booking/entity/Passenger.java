package airline.booking.entity;

import java.util.UUID;

public class Passenger {

    private final String referenceId;
    private final String name;
    private String emailId;
    private final String phoneNumber;

    public Passenger(String name, String emailId, String phoneNumber) {
        this.referenceId = UUID.randomUUID().toString();
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getReferenceId() {
        return referenceId;
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
