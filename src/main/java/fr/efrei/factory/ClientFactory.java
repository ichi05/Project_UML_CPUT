package fr.efrei.factory;

import fr.efrei.domain.Client;

public class ClientFactory {

    private ClientFactory() {}

    /**
     * Crée un Client avec validations.
     */
    public static Client create(
            String firstName,
            String lastName,
            String level,
            String email,
            boolean majority,
            int group
    ) {

        if (isNullOrBlank(firstName)) {
            throw new IllegalArgumentException("firstName ne doit pas être vide");
        }

        if (isNullOrBlank(lastName)) {
            throw new IllegalArgumentException("lastName ne doit pas être vide");
        }

        if (isNullOrBlank(level)) {
            throw new IllegalArgumentException("level ne doit pas être vide");
        }

        if (isNullOrBlank(email)) {
            throw new IllegalArgumentException("email ne doit pas être vide");
        }

        if (group <= 0) {
            throw new IllegalArgumentException("group doit être supérieur à 0");
        }

        return new Client.Builder()
                .firstName(firstName.trim())
                .lastName(lastName.trim())
                .level(level.trim())
                .email(email.trim())
                .majority(majority)
                .group(group)
                .build();
    }

    private static boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}
