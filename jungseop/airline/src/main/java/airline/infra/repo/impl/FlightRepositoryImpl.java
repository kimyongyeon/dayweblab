package airline.infra.repo.impl;

import airline.domain.vo.Flight;
import airline.infra.repo.FlightRepository;

import java.util.ArrayList;
import java.util.List;

public class FlightRepositoryImpl implements FlightRepository {

    private final List<Flight> store = new ArrayList<>();

    @Override
    public void create(Flight flight) {
        store.add(flight);
    }

    @Override
    public boolean update(long id, Flight newFlight) {
        boolean result = delete(id);
        if (result == true) {
            store.add(newFlight);
        }

        return result;
    }

    @Override
    public boolean delete(long id) {
        return store.removeIf(flight -> flight.getFlightId() == id);
    }

    @Override
    public Flight findById(long id) {
        return store.stream()
                .filter(flight -> flight.getFlightId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Flight> findAll() {
        return store;
    }
}
