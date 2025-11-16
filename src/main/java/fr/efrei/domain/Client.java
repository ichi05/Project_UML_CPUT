package fr.efrei.domain;

public class Client {

    private String firstName;
    private String lastName;
    private String level;
    private String email;
    private boolean majority;
    private int group;

    //Client Default Constructor
    public Client() {
    }

    //Client Constructor
    private Client(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.level = builder.level;
        this.email = builder.email;
        this.majority = builder.majority;
        this.group = builder.group;
    }

    // Client Getters & Setters
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getMajority() {
        return majority;
    }

    public void setMajority(boolean majority) {
        this.majority = majority;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    // Client Builder
    public static class Builder {
        private String firstName;
        private String lastName;
        private String level;
        private String email;
        private boolean majority;
        private int group;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder majority(boolean majority) {
            this.majority = majority;
            return this;
        }

        public Builder group(int group) {
            this.group = group;
            return this;
        }

        public Client build() {
            return new Client(this);
        }

        public Builder copy(Client client) {
            this.firstName = client.firstName;
            this.lastName = client.lastName;
            this.level = client.level;
            this.email = client.email;
            this.majority = client.majority;
            this.group = client.group;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", level='" + level + '\'' +
                ", email='" + email + '\'' +
                ", majority=" + majority +
                ", group=" + group +
                '}';
    }
}
