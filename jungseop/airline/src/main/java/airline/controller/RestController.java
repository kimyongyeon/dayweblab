package airline.controller;

import airline.domain.service.PassengerService;
import airline.domain.service.ReservationService;
import airline.domain.service.TicketService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestController {

    private final PassengerService passengerService;
    private final ReservationService reservationService;
    private final TicketService ticketService;

    public void signUpMember() {

    }

}
