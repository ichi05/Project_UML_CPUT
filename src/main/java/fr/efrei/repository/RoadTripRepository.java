package fr.efrei.repository;

import fr.efrei.domain.RoadTrip;
import java.util.ArrayList;
import java.util.List;

public class RoadTripRepository {

    private static RoadTripRepository repository = null;
    private final List<RoadTrip> roadTrips = new ArrayList<>();

    private RoadTripRepository() {}

    public static RoadTripRepository getRepository() {
        if (repository == null) {
            repository = new RoadTripRepository();
        }
        return repository;
    }

    public void add(RoadTrip roadTrip) {
        roadTrips.add(roadTrip);
    }

    public List<RoadTrip> getAll() {
        return roadTrips;
    }

    public RoadTrip getByDestination(String destinationName) {
        for (RoadTrip rt : roadTrips) {
            if (rt.getDestinationName().equals(destinationName)) {
                return rt;
            }
        }
        return null;
    }

    public void remove(RoadTrip roadTrip) {
        roadTrips.remove(roadTrip);
    }
}


