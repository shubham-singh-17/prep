package cab.booking.models;

public class VehicleInfo {

    private final String vehicleNumber;
    private final String vehicleModel;
    private final VehicleType vehicleType;

    public VehicleInfo(String number, String model, VehicleType type) {
        this.vehicleNumber = number;
        this.vehicleModel = model;
        this.vehicleType = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
