package fr.efrei.repository;

import fr.efrei.domain.AgencyEmployee;

public class AgencyEmployeeRepository {

    private static AgencyEmployeeRepository repository = null;
    private AgencyEmployee employee;

    private AgencyEmployeeRepository() {}

    public static AgencyEmployeeRepository getRepository() {
        if (repository == null) {
            repository = new AgencyEmployeeRepository();
        }
        return repository;
    }

    public void setEmployee(AgencyEmployee employee) {
        this.employee = employee;
    }

    public AgencyEmployee getEmployee() {
        return employee;
    }
}


