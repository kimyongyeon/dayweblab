package airline.domain.dto.biz;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class FlightDto {

    private final long flightId;

    private final String departure;
    private final String destination;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int seatsAvailable;

}
