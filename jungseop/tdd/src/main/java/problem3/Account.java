package problem3;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Account {

    private final String accountNumber;

    private long balance;

}
