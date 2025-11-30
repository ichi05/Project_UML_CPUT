package fr.efrei.repository;

import fr.efrei.domain.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    private static BookingRepository repository = null;
    private final List<Booking> bookings = new ArrayList<>();

    private BookingRepository() {}

    public static BookingRepository getRepository() {
        if (repository == null) {
            repository = new BookingRepository();
        }
        return repository;
    }

    public void add(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getAll() {
        return bookings;
    }

    public Booking findByRoadTrip(String destinationName) {
        for (Booking b : bookings) {
            if (b.getRoadtrip().getDestinationName().equals(destinationName)) {
                return b;
            }
        }
        return null;
    }

    public void remove(Booking booking) {
        bookings.remove(booking);
    }
}


