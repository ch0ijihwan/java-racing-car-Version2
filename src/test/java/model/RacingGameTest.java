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

class RacingGameTest {
    private final MovementStrategy movementStrategy = new RandomMovementStrategy();

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
    void getCars()
    {
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