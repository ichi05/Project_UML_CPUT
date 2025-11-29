package fr.efrei.repository;

import fr.efrei.domain.AgencyEmployee;

public class AgencyEmployeeRepository {

    private AgencyEmployee employee;

    public void setEmployee(AgencyEmployee employee) {
        this.employee = employee;
    }

    public AgencyEmployee getEmployee() {
        return employee;
    }
}

