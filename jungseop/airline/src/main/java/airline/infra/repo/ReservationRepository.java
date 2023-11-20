package airline.infra.repo;

import airline.domain.vo.Reservation;
import airline.infra.MemoryRepository;

import java.util.List;

public interface ReservationRepository extends MemoryRepository<Reservation> {

    List<Reservation> findByPassengerIdList(long passengerId);
}
