package car.demo.implementation;

import car.demo.base.Car;
import car.demo.models.CarType;
import car.demo.models.Location;

public class Luxury extends Car {

    public Luxury(Location location) {
        super(CarType.LUXURY, location);
    }

    @Override
    public void construct() {
        System.out.println("U will feel rich sitting inside me and I have great features and look");
    }
}
