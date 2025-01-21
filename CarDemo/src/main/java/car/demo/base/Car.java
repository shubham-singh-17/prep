package car.demo.base;

import car.demo.models.CarType;
import car.demo.models.Location;

public abstract class Car {

    private CarType type;
    private Location location;

    public Car(CarType type, Location location) {
        this.location = location;
        this.type = type;
        construct();
    }

    public abstract void construct();

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCarType(CarType carType) {
        this.type = carType;
    }

    public Location getLocation() {
        return this.location;
    }

    public CarType getCarType() {
        return this.type;
    }

    @Override
    public String toString(){
        return "CarType - " + type + " Location - " + location;
    }
}
