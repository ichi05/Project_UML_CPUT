package fr.efrei.domain;

import fr.efrei.factory.BookingFactory;
import fr.efrei.factory.ClientFactory;
import fr.efrei.factory.GuideFactory;
import fr.efrei.factory.RoadTripFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Fishing RoadTrip App ===");

        // 1. Création d’un Guide
        Guide guide = GuideFactory.create(
                "Jean",
                "Durand",
                "Lancer à la mouche",
                true
        );

        // 2. Création d’un RoadTrip
        RoadTrip trip = RoadTripFactory.create(
                "Île de Ré",
                guide,
                "Bar rayé",
                "Intermédiaire",
                "2025-07-15"
        );

        // 3. Création d’un Client
        Client client = ClientFactory.create(
                "Marie",
                "Dupont",
                "Intermédiaire",
                "marie.dupont@example.com",
                true,
                3
        );

        // 4. Création d’une réservation (Booking)
        Booking booking = BookingFactory.create(
                client,
                trip,
                3
        );

        // 5. Affichage
        System.out.println("\n=== Résultat ===");
        System.out.println("Guide : " + guide);
        System.out.println("RoadTrip : " + trip);
        System.out.println("Client : " + client);
        System.out.println("Booking : " + booking);

        System.out.println("\n=== Application terminée ===");
    }
}
