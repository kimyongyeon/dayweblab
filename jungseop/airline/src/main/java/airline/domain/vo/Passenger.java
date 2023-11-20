package airline.domain.vo;

import airline.domain.dto.biz.PassengerDto;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 승객 정보
 * 1. 승객 아이디
 * 2. 이름
 */
@Builder
@Getter
@EqualsAndHashCode
public class Passenger {

   private final long passengerId;

   private final String name;

   public static Passenger to(PassengerDto passengerDto) {
      Passenger passenger = Passenger.builder()
              .passengerId(passengerDto.getPassengerId())
              .name(passengerDto.getName())
              .build();
      return passenger;
   }

   /*
    public static CustomerVO to(CustomerDTO customerDTO) {
        CustomerVO customerVO = CustomerVO.builder()
                .customerId(customerDTO.getCustomerId())
                .name(customerDTO.getName())
                .build();
        customerVO.setRegDate(LocalDateTime.now());
        customerVO.setRegister("insertAdmin");
        return customerVO;
    }
}
    */

}
