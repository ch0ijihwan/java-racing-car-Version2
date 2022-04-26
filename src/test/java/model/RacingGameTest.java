package model;

import model.movement.MovementStrategy;
import model.vo.Car;
import model.vo.Cars;
import model.vo.Names;
import model.vo.NumberOfAttempt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    @DisplayName("입력받은 자동차 이름들과 시도 횟수를 기반으로 , RacingGame 객체를 만든다.")
    void create() {
        //given
        Names names = new Names(List.of("apple", "hello", "hi"));
        int numberOfAttempt = 5;
        Cars expect = new Cars(List.of(
                new Car("apple", 0),
                new Car("hello", 0),
                new Car("hi", 0))
        );

        //when
        racingGame = new RacingGame(names, numberOfAttempt);

        //then
        assertThat(racingGame).extracting("racingCars")
                .isEqualTo(expect);
    }

    @Test
    @DisplayName("생체 생성 시, 입력받은 값이 null 이면 예외처리를 반환한다.")
    void validateNull() {
        //given
        int numberOfAttempt = 2;

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame(null, numberOfAttempt))
                .withMessage("null 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("입력 받은 움직임 전략에 따라서 자동차를 이동 시킨다. 그리고 numberOfAttempt 를 하나 줄인다.")
    void playOneRound() {
        //given
        Cars cars = new Cars(List.of(
                new Car("apple", 0),
                new Car("hello", 0),
                new Car("hi", 0))
        );
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(1);
        Cars expectCars = new Cars(List.of(
                new Car("apple", 1),
                new Car("hello", 1),
                new Car("hi", 1))
        );
        NumberOfAttempt expectNumberOfAttempt = new NumberOfAttempt(0);
        racingGame = new RacingGame(cars, numberOfAttempt);

        //when
        racingGame.playOneRound(testMovementStrategy);

        //then
        assertThat(racingGame).extracting("racingCars", "numberOfAttempt")
                .containsExactly(expectCars, expectNumberOfAttempt);
    }

    @ParameterizedTest
    @DisplayName("isGameEnd() 호출 시, 게임이 끝났으면 true 를 반환 그렇지 않으면 false 를 반환한다.")
    @MethodSource("createNumberOfAttemptParameterProvider")
    void isGameEnd(final int inputtedNumberOfAttempt, final boolean expect) {
        //given
        Names names = new Names(List.of("apple", "hello", "hi"));
        racingGame = new RacingGame(names, inputtedNumberOfAttempt);
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
    @DisplayName("getCarNamesDuringRacing() 호출 시, 게임 내 자동차들의 이름 리스트를 반환한다.")
    void getCarNamesDuringRacing() {
        //given
        int numberOfAttempt = 2;
        Names names = new Names(List.of("apple", "hello", "hi"));
        racingGame = new RacingGame(names, numberOfAttempt);
        List<String> expect = List.of("apple", "hello", "hi");

        //when
        List<String> actual = racingGame.getCarNamesDuringRacing();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("게임 내 자동차들의 포지션 리스트를 반환한다.")
    void getCarPositions() {
        //given
        Cars cars = new Cars(List.of(
                new Car("apple", 1),
                new Car("apple", 2),
                new Car("hi", 3))
        );
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(2);
        racingGame = new RacingGame(cars, numberOfAttempt);
        List<Integer> expect = List.of(1, 2, 3);

        //when
        List<Integer> actual = racingGame.getCarPositionsDuringRacing();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("우승자 이름으로 구성된 리스트를 반환한다.")
    void getWinnerNames() {
        //given
        Cars cars = new Cars(
                List.of(new Car("hi", 2),
                        new Car("apple", 2),
                        new Car("hello", 1))
        );
        racingGame = new RacingGame(cars, new NumberOfAttempt(1));
        List<String> expect = List.of("hi", "apple");

        //when
        List<String> actual = racingGame.getWinnerNames();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
