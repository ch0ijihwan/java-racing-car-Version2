package view;

import model.vo.Car;

import java.util.List;
import java.util.stream.IntStream;

public class StatusDisplay {
    private StatusDisplay() {
    }

    public static void showInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표( , ) 기준으로 구분).");
    }

    public static void showInputNumberOfAttempts() {
        System.out.println("총 시도할 횟수를 입력하세요");
    }

    public static void showStartGame() {
        System.out.println("실행 결과");
    }

    public static void showGameStatus(List<Car> racingCars) {
        IntStream.range(0, racingCars.size())
                .forEach(index -> System.out.println(racingCars.get(index).getName().getValue() + " : "
                        + "- ".repeat(racingCars.get(index).getPosition().getValue())));
        System.out.println();

    }

    public static void showBar() {
        System.out.println("====================================================");
    }

    public static void showEndGame(List<Car> winners) {
        System.out.print("최종 우승자는  ");
        if (winners.size() == 1) {
            System.out.print(winners.get(0).getName().getValue()
            );
        }
        if (winners.size() > 1) {
            IntStream.range(0, winners.size())
                    .forEach(index -> System.out.print(winners.get(index).getName().getValue() + ","
                    ));
        }
        System.out.print(" 입니다.");
    }
}
