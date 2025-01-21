package movie.booking.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import movie.booking.entity.Screen;
import movie.booking.entity.Seat;
import movie.booking.entity.Theatre;
import static movie.booking.model.constant.constant.DUMMY_SCREEN_NUMBER;
import static movie.booking.model.constant.constant.ONE;
import movie.booking.model.enums.SeatType;

public class TheatreService {

    private EntityService entityService;
    
    public TheatreService(EntityService entityService) {
        this.entityService = entityService;
    }


    public void createScreen(int goldSeat, int premiumSeat, int basicSeat) {
        Screen screen = new Screen(DUMMY_SCREEN_NUMBER);

        createSeats(ONE, basicSeat, SeatType.BASIC, screen);
        createSeats(basicSeat + ONE, goldSeat+basicSeat, SeatType.GOLD, screen);
        createSeats(basicSeat+goldSeat + ONE, basicSeat+goldSeat+premiumSeat,
            SeatType.PREMIUM, screen);

        entityService.saveScreen(screen);
    }

    private void createSeats(int startingSeatNumber, int endingSeatNumber, SeatType seatType, Screen screen) {
        IntStream.rangeClosed(startingSeatNumber, endingSeatNumber)
            .forEach(it -> {
                Seat seat = createSeat(it, seatType);
                screen.addSeats(seat.getId());
            });
    }

    private Seat createSeat(int seatNumber, SeatType seatType) {
        Seat seat = new Seat(seatNumber, seatType);
        entityService.saveSeat(seat);

        return seat;
    }

    public Theatre createTheatre(List<Screen> screens, String name, String location) {
        List<String> screenIds = screens.stream()
                                     .map(Screen::getId)
                                     .collect(Collectors.toList());

        Theatre theatre = new Theatre(name, location, screenIds);
        entityService.saveTheatre(theatre);

        return theatre;
    }
}
