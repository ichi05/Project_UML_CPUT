package fr.efrei.repository;

import fr.efrei.domain.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private final List<Client> clients = new ArrayList<>();

    public void add(Client client) {
        clients.add(client);
    }

    public List<Client> getAll() {
        return clients;
    }

    public Client getByEmail(String email) {
        for (Client c : clients) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public void remove(Client client) {
        clients.remove(client);
    }
}

