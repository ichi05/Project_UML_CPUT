package fr.efrei.repository;

import fr.efrei.domain.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository {

    private final List<Booking> bookings = new ArrayList<>();

    public void add(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getAll() {
        return bookings;
    }

    public void remove(Booking booking) {
        bookings.remove(booking);
    }
}

