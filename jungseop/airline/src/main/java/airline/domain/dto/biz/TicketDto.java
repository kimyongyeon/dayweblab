package airline.domain.dto.biz;

import lombok.Builder;

@Builder
public class TicketDto {

    private final long ticketId;

    private final ReservationDto reservation;
    private final int seatNumber;
    private final int price;

}
