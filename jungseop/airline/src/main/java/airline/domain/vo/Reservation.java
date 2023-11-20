package airline.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * 예약 정보
 * 1. 예약 번호
 * 2. 승객 아이디
 * 3. 비행 번호
 */
@Builder
@Getter
@EqualsAndHashCode
public class Reservation {

    private final long reservationId;

    private final long passengerId;
    private final long flightId;

}
