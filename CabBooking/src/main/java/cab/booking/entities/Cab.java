package cab.booking.entities;

import cab.booking.models.CabStatus;
import cab.booking.models.Location;
import cab.booking.models.VehicleInfo;

public class Cab extends BaseEntity {

    private final String driverName;
    private final String driverPhoneNumber;
    private final VehicleInfo vehicleInfo;
    private CabStatus status;
    private final Location currentLocation;

    public Cab(VehicleInfo vehicleInfo, String driverName, String driverPhoneNumber, Location currentLocation) {
        super();
        this.vehicleInfo = vehicleInfo;
        this.driverName = driverName;
        this.driverPhoneNumber = driverPhoneNumber;
        this.status = CabStatus.NOT_AVAILABLE;
        this.currentLocation = currentLocation;
    }

    public VehicleInfo getVehicleInfo() {
        return vehicleInfo;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public CabStatus getStatus() {
        return status;
    }

    public void setStatus(CabStatus status) {
        this.status = status;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }
}
