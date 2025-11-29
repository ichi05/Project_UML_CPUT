package fr.efrei.factory;

import fr.efrei.domain.Booking;
import fr.efrei.domain.Client;
import fr.efrei.domain.RoadTrip;

public class BookingFactory {

    private BookingFactory() {
    }

    /**
     * Crée une réservation (Booking) avec validations.
     */
    public static Booking create(Client client, RoadTrip roadtrip, int group) {

        if (client == null) {
            throw new IllegalArgumentException("client ne doit pas être nul");
        }

        if (roadtrip == null) {
            throw new IllegalArgumentException("roadtrip ne doit pas être nul");
        }

        if (group <= 0) {
            throw new IllegalArgumentException("group doit être supérieur à 0");
        }

        return new Booking.Builder()
                .client(client)
                .roadtrip(roadtrip)
                .group(group)
                .build();
    }
}