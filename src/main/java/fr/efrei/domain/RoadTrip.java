package fr.efrei.domain;

import java.util.Objects;

public class RoadTrip {

    private String destinationName;
    private Guide guide;
    private String species;
    private String levelRequired;
    private String date; // tu peux passer en LocalDate plus tard si tu veux

    //RoadTrip Default Constructor
    public RoadTrip() {
    }

    //RoadTrip Constructor
    private RoadTrip(Builder builder) {
        this.destinationName = builder.destinationName;
        this.guide = builder.guide;
        this.species = builder.species;
        this.levelRequired = builder.levelRequired;
        this.date = builder.date;
    }

    //RoadTrip Getters & Setters
    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(String levelRequired) {
        this.levelRequired = levelRequired;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // RoadTrip Builder
    public static class Builder {
        private String destinationName;
        private Guide guide;
        private String species;
        private String levelRequired;
        private String date;

        public Builder destinationName(String destinationName) {
            this.destinationName = destinationName;
            return this;
        }

        public Builder guide(Guide guide) {
            this.guide = guide;
            return this;
        }

        public Builder species(String species) {
            this.species = species;
            return this;
        }

        public Builder levelRequired(String levelRequired) {
            this.levelRequired = levelRequired;
            return this;
        }

        public Builder date(String date) {
            this.date = date;
            return this;
        }

        public RoadTrip build() {
            return new RoadTrip(this);
        }

        public Builder copy(RoadTrip roadTrip) {
            this.destinationName = roadTrip.destinationName;
            this.guide = roadTrip.guide;
            this.species = roadTrip.species;
            this.levelRequired = roadTrip.levelRequired;
            this.date = roadTrip.date;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoadTrip)) return false;
        RoadTrip roadTrip = (RoadTrip) o;
        return Objects.equals(destinationName, roadTrip.destinationName) &&
                Objects.equals(guide, roadTrip.guide) &&
                Objects.equals(date, roadTrip.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinationName, guide, date);
    }

    @Override
    public String toString() {
        return "RoadTrip{" +
                "destinationName='" + destinationName + '\'' +
                ", guide=" + guide +
                ", species='" + species + '\'' +
                ", levelRequired='" + levelRequired + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

