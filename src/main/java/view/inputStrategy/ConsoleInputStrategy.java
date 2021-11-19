package view.inputStrategy;

import java.util.Scanner;
//TODO : 인터페이스로 바꿔보기
public class ConsoleInputStrategy implements InputStrategy{
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public  String[] inputRacingCarNames() {
        return SCANNER.nextLine()
                .split(",");
    }

    @Override
    public  int inputNumberAttempts() {
        return SCANNER.nextInt();
    }
}
