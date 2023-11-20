package airline.domain.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 티켓 정보
 * 1. 티켓 번호
 * 2. 예약 번호
 * 3. 좌석 번호
 * 4. 가격
 */
@Builder
@Getter
@EqualsAndHashCode
public class Ticket {

    private final long ticketId;

    private final long reservationId;
    private final int seatNumber;
    private final int price;

}
