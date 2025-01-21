package cab.booking.entities;

import java.util.UUID;

public abstract class BaseEntity {

    private final String id;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
