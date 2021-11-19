package view.displaystrategy;

import model.vo.Car;

import java.util.List;
import java.util.StringJoiner;

public class StatusDisplay implements StatusDisplayStrategy {
    private static final String SPOT = ",";
    private static final String POSITION_BAR = " - ";
    private static final String COLON = " : ";

    @Override
    public void showInputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표( , ) 기준으로 구분).");
    }

    @Override
    public void showInputNumberOfAttempts() {
        System.out.println("총 시도할 횟수를 입력하세요");
    }

    @Override
    public void showStartGame() {
        System.out.println("실행 결과");
    }

    @Override
    public void showGameStatus(List<Car> racingCars) {
        for (Car car : racingCars
        ) {
            System.out.print(car.getNameValue());
            System.out.print(COLON);
            System.out.println(POSITION_BAR.repeat(car.getPositionValue()));
        }
        System.out.println();
    }

    @Override
    public void showBar() {
        System.out.println("====================================================");
    }

    @Override
    public void showEndGame(List<Car> winners) {
        System.out.print("최종 우승자는  ");
        StringJoiner stringJoiner = new StringJoiner(SPOT);
        winners.forEach(winner -> stringJoiner.add(winner.getNameValue()));
        System.out.print(stringJoiner);
        System.out.print(" 입니다.");
    }
}
