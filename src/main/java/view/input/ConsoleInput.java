package view.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private static final String VALIDATE_MESSAGE_BLANK_OR_NULL = "아무 것도 입력 되지 않았거나, 공백만 입력되었니다.";

    @Override
    public String[] inputCarNames() {
        System.out.println("경주할 자동 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).");
        String inputtedValue = SCANNER.nextLine();
        hasDelimiter(inputtedValue);
        hasNullOrBlank(inputtedValue);
        return inputtedValue.split(DELIMITER);
    }

    private void hasDelimiter(final String inputtedValue) {
        if (!inputtedValue.contains(DELIMITER)) {
            throw new IllegalArgumentException(String.format("구분 문자인 %s 가 없습니다.", DELIMITER));
        }
    }

    private void hasNullOrBlank(final String inputtedValue) {
        if (inputtedValue.isBlank()) {
            throw new IllegalArgumentException(VALIDATE_MESSAGE_BLANK_OR_NULL);
        }
    }

    @Override
    public Integer inputNumberOfAttempt() {
        System.out.println("시도 횟수는 몇회인가요?");
        String inputtedNumberOfAttempt = SCANNER.nextLine();
        hasNullOrBlank(inputtedNumberOfAttempt);
        return Integer.parseInt(inputtedNumberOfAttempt);
    }
}
