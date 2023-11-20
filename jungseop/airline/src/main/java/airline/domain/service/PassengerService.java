package airline.domain.service;

import airline.domain.vo.Passenger;
import airline.infra.repo.PassengerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public void signUp(long id, String name) {
        Passenger passenger = Passenger.builder()
                .passengerId(id)
                .name(name)
                .build();
        passengerRepository.create(passenger);
    }

    public Passenger getPassenger(long passengerId) {
        return passengerRepository.findById(passengerId);
    }

}
