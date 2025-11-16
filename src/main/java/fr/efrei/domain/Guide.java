package fr.efrei.domain;

import java.util.Objects;

public class Guide {

    private String firstName;
    private String lastName;
    private String fishingTechnic;
    private boolean boat;

    // Guide Default Constructor
    public Guide() {
    }

    // Guide Constructor
    private Guide(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.fishingTechnic = builder.fishingTechnic;
        this.boat = builder.boat;
    }

    // Guide Getters & Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFishingTechnic() {
        return fishingTechnic;
    }

    public void setFishingTechnic(String fishingTechnic) {
        this.fishingTechnic = fishingTechnic;
    }

    public boolean getBoat() {
        return boat;
    }

    public void setBoat(boolean boat) {
        this.boat = boat;
    }

    // Guide Builder
    public static class Builder {
        private String firstName;
        private String lastName;
        private String fishingTechnic;
        private boolean boat;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder fishingTechnic(String fishingTechnic) {
            this.fishingTechnic = fishingTechnic;
            return this;
        }

        public Builder boat(boolean boat) {
            this.boat = boat;
            return this;
        }

        public Guide build() {
            return new Guide(this);
        }

        public Builder copy(Guide guide) {
            this.firstName = guide.firstName;
            this.lastName = guide.lastName;
            this.fishingTechnic = guide.fishingTechnic;
            this.boat = guide.boat;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guide)) return false;
        Guide guide = (Guide) o;
        return boat == guide.boat &&
                Objects.equals(firstName, guide.firstName) &&
                Objects.equals(lastName, guide.lastName) &&
                Objects.equals(fishingTechnic, guide.fishingTechnic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, fishingTechnic, boat);
    }

    @Override
    public String toString() {
        return "Guide{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fishingTechnic='" + fishingTechnic + '\'' +
                ", boat=" + boat +
                '}';
    }
}
