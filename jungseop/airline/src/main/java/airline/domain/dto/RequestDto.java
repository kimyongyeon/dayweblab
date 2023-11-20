package airline.domain.dto;

import lombok.Builder;

@Builder
public class RequestDto<T> {

    private final T data;

}
