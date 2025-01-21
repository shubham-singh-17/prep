package car.demo.implementation;

import car.demo.base.Car;
import car.demo.models.CarType;
import car.demo.models.Location;

public class Sedan extends Car {

    public Sedan(Location location) {
        super(CarType.SEDAN, location);
    }

    @Override
    public void construct() {
        System.out.println("I am fast, looks sleek and comfortable on highways");
    }
}
