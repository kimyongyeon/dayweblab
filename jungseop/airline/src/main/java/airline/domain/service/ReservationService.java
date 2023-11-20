package airline.domain.service;

import airline.domain.vo.Reservation;
import airline.infra.repo.ReservationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation makeReservation(Reservation reservation) {
        reservationRepository.create(reservation);
        return reservationRepository.findById(reservation.getReservationId());
    }

    public void cancelReservation(Reservation reservation) {
        boolean result = reservationRepository.delete(reservation.getReservationId());

        if (result == false) {
            throw new IllegalArgumentException("해당하는 예약이 없습니다.");
        }
    }

}
