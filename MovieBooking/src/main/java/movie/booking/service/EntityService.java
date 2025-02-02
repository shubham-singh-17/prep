package movie.booking.service;

import movie.booking.entity.*;
import movie.booking.store.*;

import java.awt.print.Book;
import java.util.Map;

public class EntityService {

    private final ShowStore showStore;
    private final ShowSeatStore showSeatStore;
    private final MovieStore movieStore;
    private final UserStore userStore;
    private final TheatreStore theatreStore;
    private final BookingStore bookingStore;
    private final ScreenStore screenStore;
    private final SeatStore seatStore;

    public EntityService() {
        this.showStore = new ShowStore();
        this.showSeatStore = new ShowSeatStore();
        this.movieStore = new MovieStore();
        this.userStore = new UserStore();
        this.theatreStore = new TheatreStore();
        this.bookingStore = new BookingStore();
        this.screenStore = new ScreenStore();
        this.seatStore = new SeatStore();
    }


    public Map<String, Show> getShows() {
        return showStore.getEntityMap();
    }

    public Map<String, ShowSeat> getShowSeats() {
        return showSeatStore.getEntityMap();
    }

    public void saveBooking(Booking booking) {
        bookingStore.addEntity(booking);
    }

    public Map<String, Seat> getSeats() {
        return seatStore.getEntityMap();
    }

    public void saveShowSeat(ShowSeat showSeat) {
        showSeatStore.addEntity(showSeat);
    }

    public Map<String, Screen> getScreens() {
        return screenStore.getEntityMap();
    }

    public void saveShow(Show show) {
        showStore.addEntity(show);
    }

    public void saveSeat(Seat seat) {
        seatStore.addEntity(seat);
    }

    public void saveTheatre(Theatre theatre) {
        theatreStore.addEntity(theatre);
    }

    public void saveScreen(Screen screen) {
        screenStore.addEntity(screen);
    }

    public void saveUser(User user) {
        userStore.addEntity(user);
    }
}
