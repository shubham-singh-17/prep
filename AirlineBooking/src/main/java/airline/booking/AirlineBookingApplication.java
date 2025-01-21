package airline.booking;

import airline.booking.service.TestService;

public class AirlineBookingApplication {


    public static void main(String[] args) {
        TestService testService = new TestService();

        testService.demo();
    }
}
