package model;

import model.movement.MovementStrategy;
import model.movement.RandomMovementStrategy;
import model.vo.Car;
import model.vo.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {
    private final MovementStrategy movementStrategy = new RandomMovementStrategy();

    @Test
    @DisplayName("객체 생성 시, 파라미터로 부터 입력받은 자동차 이름들을 가진 Cars 객체와, 파라미터로 부터 입력 받은 RoundCount 객체를 생성한다.")
    void createRacingGame() {
        //given
        String[] inputtedNames = new String[]{"a", "b", "c"};
        Cars expectedCars = new Cars(new String[]{"a", "b", "c"});
        int inputRoundCount = 5;
        RoundCount expectedRoundCount = new RoundCount(5);

        //when
        RacingGame racingGame = new RacingGame(inputtedNames, inputRoundCount, movementStrategy);

        //then
        assertAll(
                () -> assertThat(racingGame.getCars()).isEqualTo(expectedCars),
                () -> assertThat(racingGame.getRoundCount()).isEqualTo(expectedRoundCount)
        );
    }

    @Test
    @DisplayName("isNotOver 실행시,  RoundCount 객체가 0 이 아닌 경우 true 를 반환한다.")
    void isNotOver() {
        //given
        String[] inputtedNames = new String[]{"a", "b", "c"};
        int inputRoundCount = 5;
        RacingGame racingGame = new RacingGame(inputtedNames, inputRoundCount, movementStrategy);

        //when
        boolean actual = racingGame.isNotOver();

        //then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("getWinner 메서드 실행시, 우승자들로 구성된 Car 리스트를 반환한다.")
    void getWinner() {
        //given
        List<Car> inputtedCars = Arrays.asList(new Car("cocoa", 1), new Car("sky", 2), new Car("love", 2));
        RacingGame racingGame = new RacingGame(inputtedCars, movementStrategy);
        List<Car> expectedWinners = Arrays.asList(new Car("sky", 2), new Car("love", 2));

        //when
        List<Car> actual = racingGame.getWinners();

        //then
        assertThat(actual).isEqualTo(expectedWinners);
    }

    @Test
    @DisplayName("getCars 실행시 cars 객체를 반환한다.")
    void getCars() {
        //given
        List<Car> inputtedCars = Arrays.asList(new Car("cocoa", 1), new Car("sky", 2), new Car("love", 2));
        RacingGame racingGame = new RacingGame(inputtedCars, movementStrategy);
        Cars expectedCars = new Cars(inputtedCars);
        //when
        Cars actual = racingGame.getCars();

        //then
        assertThat(actual).isEqualTo(expectedCars);
    }
}