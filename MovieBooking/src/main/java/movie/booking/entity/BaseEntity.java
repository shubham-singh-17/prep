package movie.booking.entity;

import java.util.UUID;

public class BaseEntity {

    private final String id = UUID.randomUUID().toString();

    public String getId() {
        return id;
    }
}
