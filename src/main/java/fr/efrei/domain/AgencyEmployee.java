package fr.efrei.domain;

public class AgencyEmployee {

    private String agencyName;
    private String mobile;
    private String email;

    //AgencyEmployee Default Constructor
    public AgencyEmployee() {
    }

    //AgencyEmployee Constructor
    private AgencyEmployee(Builder builder) {
        this.agencyName = builder.agencyName;
        this.mobile = builder.mobile;
        this.email = builder.email;
    }

    //AgencyEmployee Getters & Setters
    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // AgencyEmployee Builder
    public static class Builder {
        private String agencyName;
        private String mobile;
        private String email;

        public Builder agencyName(String agencyName) {
            this.agencyName = agencyName;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public AgencyEmployee build() {
            return new AgencyEmployee(this);
        }

        public Builder copy(AgencyEmployee employee) {
            this.agencyName = employee.agencyName;
            this.mobile = employee.mobile;
            this.email = employee.email;
            return this;
        }
    }

    @Override
    public String toString() {
        return "AgencyEmployee{" +
                "agencyName='" + agencyName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
