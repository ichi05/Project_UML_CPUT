package fr.efrei.factory;

import fr.efrei.domain.AgencyEmployee;

public class AgencyEmployeeFactory {

    private AgencyEmployeeFactory() {
    }

    /**
     * Crée un AgencyEmployee avec vérifications des champs obligatoires.
     */
    public static AgencyEmployee create(String agencyName, String mobile, String email) {

        if (isNullOrBlank(agencyName)) {
            throw new IllegalArgumentException("agencyName ne doit pas être vide");
        }

        if (isNullOrBlank(mobile)) {
            throw new IllegalArgumentException("mobile ne doit pas être vide");
        }

        if (isNullOrBlank(email)) {
            throw new IllegalArgumentException("email ne doit pas être vide");
        }

        return new AgencyEmployee.Builder()
                .agencyName(agencyName.trim())
                .mobile(mobile.trim())
                .email(email.trim())
                .build();
    }

    private static boolean isNullOrBlank(String s) {
        return s == null || s.isBlank();
    }
}
