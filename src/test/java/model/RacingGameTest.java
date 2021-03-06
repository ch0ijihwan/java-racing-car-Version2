package model;

import model.car.entity.Car;
import model.car.entity.Cars;
import model.car.vo.Names;
import model.game.entity.RacingGame;
import model.game.vo.NumberOfAttempt;
import model.movement.MovementStrategy;
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
    @DisplayName("생체 생성 시, 입력받은 값이 null 이면 예외처리를 반환한다.")
    void validateNull() {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(2);

        //when
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGame((Names) null, numberOfAttempt))
                .withMessage("null 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("입력 받은 움직임 전략에 따라서 자동차를 이동 시킨 후, numberOfAttempt 를 하나 줄인다.")
    void playOneRound() {
        //given
        Names names = new Names(List.of("apple", "hello", "hi"));
        Cars cars = new Cars(names);
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(1);
        NumberOfAttempt expectNumberOfAttempt = new NumberOfAttempt(0);
        racingGame = new RacingGame(cars, numberOfAttempt);

        //when
        racingGame.playOneRound(testMovementStrategy);

        //then
        assertThat(racingGame).hasFieldOrPropertyWithValue("numberOfAttempt", expectNumberOfAttempt);
    }

    @ParameterizedTest
    @DisplayName("isGameEnd() 호출 시, 게임이 끝났으면 true 를 반환 그렇지 않으면 false 를 반환한다.")
    @MethodSource("createNumberOfAttemptParameterProvider")
    void isGameEnd(final NumberOfAttempt inputtedNumberOfAttempt, final boolean expect) {
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
                Arguments.of(new NumberOfAttempt(1), true),
                Arguments.of(new NumberOfAttempt(2 ), false)
        );
    }

    @Test
    @DisplayName("getCarNamesDuringRacing() 호출 시, 게임 내 자동차들의 이름 리스트를 반환한다.")
    void getCarNamesDuringRacing() {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(2);
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
        Names names = new Names(List.of("apple", "hello", "hi"));
        Cars cars = new Cars(names);
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(2);
        racingGame = new RacingGame(cars, numberOfAttempt);
        racingGame.playOneRound(testMovementStrategy);
        racingGame.playOneRound(testMovementStrategy);
        List<Integer> expect = List.of(2, 2, 2);

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
        List<String> actual = racingGame.findWinnerNames();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
