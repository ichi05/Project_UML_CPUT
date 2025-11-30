package fr.efrei.views;

import fr.efrei.domain.*;
import fr.efrei.factory.ClientFactory;
import fr.efrei.factory.RoadTripFactory;
import fr.efrei.repository.*;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String PIN = "0000";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClientRepository clientRepo = ClientRepository.getRepository();
        GuideRepository guideRepo = GuideRepository.getRepository();
        RoadTripRepository roadTripRepo = RoadTripRepository.getRepository();
        BookingRepository bookingRepo = BookingRepository.getRepository();

        Guide defaultGuide = new Guide.Builder()
                .firstName("John")
                .lastName("Fisherman")
                .fishingTechnic("Fly Fishing")
                .boat(true)
                .build();
        guideRepo.add(defaultGuide);

        Client professor = ClientFactory.create(
                "Kruben",
                "Naidoo",
                "Expert",
                "kruben.naidoo@efrei.fr",
                true,
                1
        );
        clientRepo.add(professor);

        roadTripRepo.add(RoadTripFactory.create("Alaska", defaultGuide, "Salmon", "Intermediate", "12/06/2025"));
        roadTripRepo.add(RoadTripFactory.create("Amazon Rainforest", defaultGuide, "Piranha", "Expert", "18/07/2025"));
        roadTripRepo.add(RoadTripFactory.create("Maldives", defaultGuide, "Marlin", "Beginner", "22/08/2025"));
        roadTripRepo.add(RoadTripFactory.create("Norway Fjords", defaultGuide, "Cod", "Intermediate", "05/05/2025"));
        roadTripRepo.add(RoadTripFactory.create("Great Barrier Reef", defaultGuide, "Tuna", "Advanced", "10/09/2025"));

        System.out.println("===================================");
        System.out.println("   FISHING AGENCY BOOKING SYSTEM");
        System.out.println("===================================");

        String inputPin;
        do {
            System.out.print("\nVeuillez entrer votre code PIN : ");
            inputPin = scanner.nextLine();

            if (!inputPin.equals(PIN)) {
                System.out.println("Code PIN incorrect, veuillez réessayer.");
            }

        } while (!inputPin.equals(PIN));

        System.out.println("\n✔ Connexion réussie ! Bienvenue.\n");

        int choice = 0;

        while (choice != 3) {

            System.out.println("\n==============================");
            System.out.println("           MENU");
            System.out.println("==============================");
            System.out.println("1 → Faire une réservation");
            System.out.println("2 → Annuler une réservation");
            System.out.println("3 → Quitter");
            System.out.print("Votre choix : ");

            if (!scanner.hasNextInt()) {
                System.out.println("\nAre you kidding me ? Nuh-uh. Idiot. :)");
                break;
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.println("\nListe des RoadTrips disponibles :\n");

                List<RoadTrip> trips = roadTripRepo.getAll();
                for (int i = 0; i < trips.size(); i++) {
                    RoadTrip rt = trips.get(i);
                    System.out.println((i + 1) + ". " + rt.getDestinationName()
                            + " (" + rt.getDate() + ")");
                }

                System.out.print("\nVeuillez choisir un RoadTrip (1-" + trips.size() + ") : ");
                int tripChoice = scanner.nextInt();
                scanner.nextLine();

                if (tripChoice < 1 || tripChoice > trips.size()) {
                    System.out.println("Choix invalide.");
                    continue;
                }

                RoadTrip selected = trips.get(tripChoice - 1);

                if (bookingRepo.findByRoadTrip(selected.getDestinationName()) != null) {
                    System.out.println("RoadTrip déjà pris !");
                } else {

                    System.out.println("\n✔ Le RoadTrip est disponible !");
                    System.out.println("Veuillez entrer les informations du client :\n");

                    System.out.print("Prénom : ");
                    String firstName = scanner.nextLine();

                    System.out.print("Nom : ");
                    String lastName = scanner.nextLine();

                    System.out.print("Email : ");
                    String email = scanner.nextLine();

                    Client newClient = ClientFactory.create(
                            firstName,
                            lastName,
                            "Visitor",
                            email,
                            true,
                            1
                    );

                    clientRepo.add(newClient);

                    Booking booking = new Booking.Builder()
                            .client(newClient)
                            .roadtrip(selected)
                            .group(1)
                            .build();

                    bookingRepo.add(booking);

                    System.out.println("\n======================================");
                    System.out.println("✔ Réservation confirmée !");
                    System.out.println("Client : " + firstName + " " + lastName);
                    System.out.println("Email : " + email);
                    System.out.println("Destination : " + selected.getDestinationName());
                    System.out.println("Date : " + selected.getDate());
                    System.out.println("======================================");
                }

            } else if (choice == 2) {

                List<Booking> bookings = bookingRepo.getAll();

                if (bookings.isEmpty()) {
                    System.out.println("\nAucune réservation existante.");
                    continue;
                }

                System.out.println("\nRéservations existantes :\n");

                for (int i = 0; i < bookings.size(); i++) {
                    Booking b = bookings.get(i);
                    System.out.println((i + 1) + ". " +
                            b.getRoadtrip().getDestinationName() +
                            " — " +
                            b.getClient().getFirstName() + " " + b.getClient().getLastName());
                }

                System.out.print("\nChoisissez une réservation à annuler (1-" + bookings.size() + ") : ");
                int cancelChoice = scanner.nextInt();
                scanner.nextLine();

                if (cancelChoice < 1 || cancelChoice > bookings.size()) {
                    System.out.println("Choix invalide.");
                    continue;
                }

                Booking toCancel = bookings.get(cancelChoice - 1);
                bookingRepo.remove(toCancel);

                System.out.println("\nRéservation annulée avec succès pour : " +
                        toCancel.getRoadtrip().getDestinationName());

            } else if (choice == 3) {

                System.out.println("\nProgramme terminé. À bientôt !");

            } else {

                System.out.println("\nAre you kidding me ? Nuh-uh. Idiot. :)");
                break;
            }
        }
    }
}


