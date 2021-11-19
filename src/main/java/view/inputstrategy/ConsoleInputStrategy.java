package view.inputstrategy;

import java.util.Scanner;
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
