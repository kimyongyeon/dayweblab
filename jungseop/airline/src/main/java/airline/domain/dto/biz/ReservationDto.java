package airline.domain.dto.biz;

import lombok.Builder;

import java.util.List;

@Builder
public class ReservationDto {

    private final long reservationId;

    private final PassengerDto passenger;
    private final FlightDto flight;
    private final List<TicketDto> tickets;

}
