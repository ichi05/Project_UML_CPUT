package fr.efrei.factory;

import fr.efrei.domain.RoadTrip;
import fr.efrei.domain.Guide;

public class RoadTripFactory {

    private RoadTripFactory() {}

    /**
     * Crée un RoadTrip avec validations.
     */
    public static RoadTrip create(
            String destinationName,
            Guide guide,
            String species,
            String levelRequired,
            String date
    ) {

        if (isNullOrBlank(destinationName)) {
            throw new IllegalArgumentException("destinationName ne doit pas être vide");
        }

        if (guide == null) {
            throw new IllegalArgumentException("guide ne doit pas être nul");
        }

        if (isNullOrBlank(species)) {
            throw new IllegalArgumentException("species ne doit pas être vide");
        }

        if (isNullOrBlank(levelRequired)) {
            throw new IllegalArgumentException("levelRequired ne doit pas être vide");
        }

        if (isNullOrBlank(date)) {
            throw new IllegalArgumentException("date ne doit pas être vide");
        }

        return new RoadTrip.Builder()
                .destinationName(destinationName.trim())
                .guide(guide)
                .species(species.trim())
                .levelRequired(levelRequired.trim())
                .date(date.trim())
                .build();
    }

    private static boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}