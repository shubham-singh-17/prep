package car.demo.factory;

import car.demo.base.Car;
import car.demo.implementation.Luxury;
import car.demo.implementation.Sedan;
import car.demo.implementation.Suv;
import car.demo.models.CarType;
import car.demo.models.Location;

public class CarFactory {

    public static Car buildCar(CarType type, Location location) {
        return getCar(type, location);
    }

    public static Car buildCar(CarType type) {
        Location defaultLocation = Location.INDIA;

        return getCar(type, defaultLocation);
    }

    private static Car getCar(CarType type, Location defaultLocation) {
        Car car = null;

        switch (type) {
            case SUV:
                car = new Suv(defaultLocation);
                break;
            case SEDAN:
                car = new Sedan(defaultLocation);
                break;
            case LUXURY:
                car = new Luxury(defaultLocation);
                break;
            default:
                break;

        }

        return car;
    }
}
