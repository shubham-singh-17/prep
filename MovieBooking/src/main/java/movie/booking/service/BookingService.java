package movie.booking.service;

import java.util.List;
import java.util.stream.Collectors;
import movie.booking.entity.Booking;
import movie.booking.entity.Seat;
import movie.booking.entity.Show;
import movie.booking.entity.ShowSeat;
import movie.booking.model.UserSeatType;
import movie.booking.model.enums.SeatStatus;
import movie.booking.model.enums.SeatType;

public class BookingService {

    private final EntityService entityService;

    public BookingService(EntityService entityService) {
        this.entityService = entityService;
    }

    public Booking bookSeats(String showId, List<UserSeatType> userSeatTypeList) {
        Show show = entityService.getShows().get(showId);
        List<ShowSeat> showSeats = show.getShowSeats().stream()
                                       .map(seatId -> entityService.getShowSeats().get(seatId))
                                       .collect(Collectors.toList());

        List<String> seats = bookSeats(userSeatTypeList, showSeats);
        int totalCost = getTotalCost(seats);

        Booking booking = new Booking(seats, showId, totalCost);
        entityService.saveBooking(booking);

        return booking;
    }

    private List<String> bookSeats(List<UserSeatType> userSeatTypeList, List<ShowSeat> showSeats) {
        return userSeatTypeList.stream()
                   .map(userSeatType -> bookSeat(showSeats, userSeatType.getUserId(), userSeatType.getSeatType()))
                   .collect(Collectors.toList());
    }

    private int getTotalCost(List<String> seats) {
        return seats.stream()
            .map(seatId -> entityService.getShowSeats().get(seatId))
            .map(ShowSeat::getPrice)
            .reduce(0, Integer::sum);
    }

    private String bookSeat(List<ShowSeat> showSeats, String user, SeatType seatType) {
        return showSeats.stream()
            .filter(seat -> {
                Seat seatDetails = entityService.getSeats().get(seat.getSeatId());
                return seatDetails.getSeatType() == seatType && seat.getStatus() == SeatStatus.AVAILABLE;
            })
            .findFirst()
            .map(seat -> {
                seat.setStatus(SeatStatus.TAKEN);
                seat.setUser(user);

                return seat.getId();
            })
            .orElseThrow(() -> new RuntimeException("Seat not available"));
    }
}
