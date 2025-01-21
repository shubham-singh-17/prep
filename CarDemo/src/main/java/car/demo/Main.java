package car.demo;

import car.demo.factory.CarFactory;
import car.demo.models.CarType;
import car.demo.models.Location;

public class Main {

    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.LUXURY, Location.INDIA));
        System.out.println(CarFactory.buildCar(CarType.SEDAN, Location.UK));
        System.out.println(CarFactory.buildCar(CarType.SUV));
    }
}
