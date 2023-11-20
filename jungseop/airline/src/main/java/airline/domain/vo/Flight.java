package airline.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 비행 정보
 * 1. 비행 번호
 * 2. 출발지
 * 3. 목적지
 * 4. 출발 시간
 * 5. 도착 시간
 * 6. 좌석 수
 */
@Builder
@Getter
@EqualsAndHashCode
public class Flight {

    private final long flightId;

    private final String departure;
    private final String destination;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int seatsAvailable;

}
