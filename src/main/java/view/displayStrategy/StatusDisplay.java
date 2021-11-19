package view.displayStrategy;

import model.vo.Car;

import java.util.List;
import java.util.stream.IntStream;

public class StatusDisplay implements StatusDisplayStrategy {
    private static final int FIRST_INDEX = 0;

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
        IntStream.range(0, racingCars.size())
                .forEach(index -> System.out.println(racingCars.get(index).getName().getValue() + " : "
                        + "- ".repeat(racingCars.get(index).getPosition().getValue())));

        //TODO : 두가지로 해결, forEach로 인덱스 관여하고, getPosition과 getValues 줄이기
        System.out.println();
    }

    @Override
    public  void showBar() {
        System.out.println("====================================================");
    }

    @Override
    public void showEndGame(List<Car> winners) {
        System.out.print("최종 우승자는  ");
        if (winners.size() == 1) {
            System.out.print(winners.get(FIRST_INDEX).getNameValue());
        }
        if (winners.size() > 1) { // TODO : StringJoiner 공부해서 적용 해보기
            //TODO : 디미터 법칙 찾아 보기 -> 아래 코드는 디미터 법칙에 위배 됨.
            IntStream.range(0, winners.size())
                    .forEach(index -> System.out.print(winners.get(index).getName().getValue() + ","));
        }
        System.out.print(" 입니다.");
    }
}
