package movie.booking.service;

import java.time.LocalDateTime;
import movie.booking.entity.Screen;
import movie.booking.entity.Seat;
import movie.booking.entity.Show;
import movie.booking.entity.ShowSeat;

public class ShowService {

    private final EntityService entityService;

    public ShowService(EntityService entityService) {
        this.entityService = entityService;
    }

    public Show createShow(
        String theatreId, String movieId, String screenId, LocalDateTime from, LocalDateTime to, int goldSeatPrice,
        int premiumSeatPrice, int basicSeatPrice
    ) {
        Show show = new Show(movieId, from, to, theatreId, screenId);
        createShowSeats(show, screenId, goldSeatPrice, premiumSeatPrice, basicSeatPrice);

        entityService.saveShow(show);

        return show;
    }

    private void createShowSeats(
        Show show, String screenId, int goldSeatPrice, int premiumSeatPrice, int basicSeatPrice
    ) {
        Screen screen = entityService.getScreens().get(screenId);

        screen.getSeats().forEach(seatId -> {
            Seat seat = entityService.getSeats().get(seatId);

            int seatPrice = getSeatPrice(seat, goldSeatPrice, premiumSeatPrice, basicSeatPrice);
            ShowSeat showSeat = createShowSeat(seat, seatPrice);

            show.addShowSeats(showSeat.getId());
        });
    }

    private int getSeatPrice(Seat seat, int goldSeatPrice, int premiumSeatPrice, int basicSeatPrice) {
        switch (seat.getSeatType()) {
            case GOLD:
                return goldSeatPrice;
            case PREMIUM:
                return premiumSeatPrice;
            case BASIC:
                return basicSeatPrice;
            default:
                return 0;
        }
    }

    private ShowSeat createShowSeat(Seat seat, int seatPrice) {
        ShowSeat showSeat = new ShowSeat(seat.getId(), seatPrice);
        entityService.saveShowSeat(showSeat);

        return showSeat;
    }
}
