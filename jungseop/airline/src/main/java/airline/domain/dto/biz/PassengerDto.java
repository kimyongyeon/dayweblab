package airline.domain.dto.biz;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PassengerDto {

    private final long passengerId;

    private final String name;
    private final List<ReservationDto> reservations;

}
