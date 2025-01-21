package cab.booking.entities;

import cab.booking.models.Location;
import cab.booking.models.TripStatus;

public class Trip extends BaseEntity {

    private final String riderId;
    private final String cabId;
    private TripStatus status;
    private final Location origin;
    private final Location destination;
    private final double fare;

    public Trip(String riderId, String cabId, Location origin, Location destination, double fare) {
        super();
        this.riderId = riderId;
        this.cabId = cabId;
        this.origin = origin;
        this.destination = destination;
        this.fare = fare;
        this.status = TripStatus.ACTIVE;
    }

    public String getRiderId() {
        return riderId;
    }

    public String getCabId() {
        return cabId;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public Location getOrigin() {
        return origin;
    }

    public Location getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }
}
