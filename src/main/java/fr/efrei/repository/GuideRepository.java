package fr.efrei.repository;

import fr.efrei.domain.Guide;
import java.util.ArrayList;
import java.util.List;

public class GuideRepository {

    private final List<Guide> guides = new ArrayList<>();

    public void add(Guide guide) {
        guides.add(guide);
    }

    public List<Guide> getAll() {
        return guides;
    }

    public Guide getByFullName(String firstName, String lastName) {
        for (Guide g : guides) {
            if (g.getFirstName().equals(firstName) &&
                    g.getLastName().equals(lastName)) {
                return g;
            }
        }
        return null;
    }

    public void remove(Guide guide) {
        guides.remove(guide);
    }
}

