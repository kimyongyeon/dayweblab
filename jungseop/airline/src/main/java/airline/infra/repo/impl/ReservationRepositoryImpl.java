package airline.infra.repo.impl;

import airline.domain.vo.Reservation;
import airline.infra.repo.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationRepositoryImpl implements ReservationRepository {

    private final List<Reservation> store = new ArrayList<>();

    @Override
    public void create(Reservation reservation) {
        store.add(reservation);
    }

    @Override
    public boolean update(long id, Reservation newReservation) {
        boolean result = delete(id);
        if (result == true) {
            store.add(newReservation);
        }

        return result;
    }

    @Override
    public boolean delete(long id) {
        return store.removeIf(reservation -> reservation.getReservationId() == id);
    }

    @Override
    public Reservation findById(long id) {
        return store.stream()
                .filter(reservation -> reservation.getReservationId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reservation> findAll() {
        return store;
    }

    @Override
    public List<Reservation> findByPassengerIdList(long passengerId) {
        return store.stream()
                .filter(reservation -> reservation.getPassengerId() == passengerId)
                .collect(Collectors.toList());
    }
}
