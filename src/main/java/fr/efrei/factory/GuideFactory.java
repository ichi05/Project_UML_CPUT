package fr.efrei.factory;

import fr.efrei.domain.Guide;

public class GuideFactory {

    private GuideFactory() {}

    /**
     * Crée un Guide avec validations.
     */
    public static Guide create(
            String firstName,
            String lastName,
            String fishingTechnic,
            boolean boat
    ) {

        if (isNullOrBlank(firstName)) {
            throw new IllegalArgumentException("firstName ne doit pas être vide");
        }

        if (isNullOrBlank(lastName)) {
            throw new IllegalArgumentException("lastName ne doit pas être vide");
        }

        if (isNullOrBlank(fishingTechnic)) {
            throw new IllegalArgumentException("fishingTechnic ne doit pas être vide");
        }

        return new Guide.Builder()
                .firstName(firstName.trim())
                .lastName(lastName.trim())
                .fishingTechnic(fishingTechnic.trim())
                .boat(boat)
                .build();
    }

    private static boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}