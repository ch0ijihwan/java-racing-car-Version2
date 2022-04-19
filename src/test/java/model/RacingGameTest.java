package model;

import model.movement.MovementStrategy;
import model.vo.Car;
import model.vo.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {
    private RacingGame racingGame;
    private final MovementStrategy testMovementStrategy = new alwaysMove();
    static class alwaysMove implements MovementStrategy {
        @Override
        public boolean generateMovable() {
            return true;
        }
    }


    @Test
    @DisplayName("객체 생성 시, 파라미터로 부터 입력받은 자동차 이름들과 시도 횟수를 기반으로 , Cars 객체와 NumberOfAttempt 객체를 만든다.")
    void create() {
        //given
        String[] inputtedNames = new String[]{"apple", "hi", "hello"};
        int inputtedNumberOfAttempt = 5;

        //when
        racingGame = new RacingGame(inputtedNames, inputtedNumberOfAttempt);

        //then
        assertThat(racingGame).isEqualTo(new RacingGame(inputtedNames, inputtedNumberOfAttempt));
    }

    @Test
    @DisplayName("playOneRound() 호출 시, 파라미터로 부터 입력 받은 움직임 전략에 따라서 자동차를 이동 시킨다." +
            " 그리고 numberOfAttempt 를 1 감소 시킨다.")
    void playOneRound() {
        //given
        String[] inputtedNames = new String[]{"apple", "hi"};
        int inputtedNumberOfAttempt = 2;
        Cars expectedCars = new Cars(List.of(Car.of("apple", 1), Car.of("hi", 1)));
        NumberOfAttempt expectedNumberOfAttempt = new NumberOfAttempt(1);
        racingGame = new RacingGame(inputtedNames, inputtedNumberOfAttempt);

        //when
        racingGame.playOneRound(testMovementStrategy);

        //then
        assertAll(
                () -> assertThat(racingGame)
                        .extracting("racingCars")
                        .isEqualTo(expectedCars),
                () -> assertThat(racingGame).extracting("numberOfAttempt")
                        .isEqualTo(expectedNumberOfAttempt)
        );
    }


    @ParameterizedTest
    @DisplayName("isGameEnd() 호출 시, 게임이 끝났으면 true 를 반환 그렇지 않으면 false 를 반환한다.")
    @MethodSource("createNumberOfAttemptParameterProvider")
    void isGameEnd(int inputtedNumberOfAttempt, boolean expect) {
        //given
        String[] inputtedNames = new String[]{"apple", "hi"};
        racingGame = new RacingGame(inputtedNames, inputtedNumberOfAttempt);
        racingGame.playOneRound(testMovementStrategy);

        //when
        boolean actual = racingGame.isGameEnd();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> createNumberOfAttemptParameterProvider() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, false)
        );
    }

    @Test
    @DisplayName("getWinners() 호출 시, 우승자로 구성된 Car 리스트를 반환한다.")
    void getWinners() {
        //given
        Cars inputtedCars = new Cars(List.of(
                Car.of("hello", 1),
                Car.of("hi", 2),
                Car.of("apple", 2)));
        int inputtedNumberOfAttempt = 1;
        List<Car> expectedWinners = List.of(
                Car.of("hi", 2),
                Car.of("apple", 2));
        racingGame = new RacingGame(inputtedCars, inputtedNumberOfAttempt);

        //when
        List<Car> actualWinners =  racingGame.getWinners();

        //then
        assertThat(actualWinners).containsAll(expectedWinners);
    }
}
