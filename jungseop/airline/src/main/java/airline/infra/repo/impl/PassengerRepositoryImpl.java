package airline.infra.repo.impl;

import airline.domain.vo.Passenger;
import airline.infra.repo.PassengerRepository;

import java.util.ArrayList;
import java.util.List;

public class PassengerRepositoryImpl implements PassengerRepository {

    private final List<Passenger> store = new ArrayList<>();

    @Override
    public void create(Passenger passenger) {
        store.add(passenger);
    }

    @Override
    public boolean update(long id, Passenger newPassenger) {
        boolean result = delete(id);
        if (result == true) {
            store.add(newPassenger);
        }

        return result;
    }

    @Override
    public boolean delete(long id) {
        return store.removeIf(passenger -> passenger.getPassengerId() == id);
    }

    @Override
    public Passenger findById(long id) {
        return store.stream()
                .filter(passenger -> passenger.getPassengerId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Passenger> findAll() {
        return store;
    }
}
