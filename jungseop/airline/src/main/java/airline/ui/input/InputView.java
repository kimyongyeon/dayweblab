package airline.ui.input;

import airline.domain.dto.biz.PassengerDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static PassengerDto inputPassengerInfo() {
        System.out.print("회원 아이디와 이름을 입력하세요. : ");
        String input = scanner.nextLine();

        String[] splitInput = input.split(" ");
        return PassengerDto.builder()
                .passengerId(Long.parseLong(splitInput[0]))
                .name(splitInput[1])
                .build();
    }

    public static void cleanUpResource() {
        scanner.close();
    }

}
