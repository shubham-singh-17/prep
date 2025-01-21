package car.demo.implementation;

import car.demo.base.Car;
import car.demo.models.CarType;
import car.demo.models.Location;

public class Suv extends Car {

    public Suv(Location location) {
        super(CarType.SUV, location);
    }

    @Override
    public void construct() {
        System.out.println("U can ride me anywhere on any kind of terrain, I have a spectacular road presence");
    }
}
