package fr.efrei.domain;

public class Booking {

    private Client client;
    private RoadTrip roadtrip;
    private int group;

    //Booking Default Constructor
    public Booking() {
    }

    //Booking Constructor
    private Booking(Builder builder) {
        this.client = builder.client;
        this.roadtrip = builder.roadtrip;
        this.group = builder.group;
    }

    //Booking Getters & Setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RoadTrip getRoadtrip() {
        return roadtrip;
    }

    public void setRoadtrip(RoadTrip roadtrip) {
        this.roadtrip = roadtrip;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    // Booking Builder
    public static class Builder {
        private Client client;
        private RoadTrip roadtrip;
        private int group;

        public Builder client(Client client) {
            this.client = client;
            return this;
        }

        public Builder roadtrip(RoadTrip roadtrip) {
            this.roadtrip = roadtrip;
            return this;
        }

        public Builder group(int group) {
            this.group = group;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }

        public Builder copy(Booking booking) {
            this.client = booking.client;
            this.roadtrip = booking.roadtrip;
            this.group = booking.group;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Booking{" +
                "client=" + client +
                ", roadtrip=" + roadtrip +
                ", group=" + group +
                '}';
    }
}

