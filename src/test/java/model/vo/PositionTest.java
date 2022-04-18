package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PositionTest {
    @Test
    @DisplayName("getValue() 호출 시, value 를 반환한다. ")
    void getValue() {
        //given
        final int inputtedValue = 1;
        final int expectedValue = 1;
        Position position = new Position(inputtedValue);

        //when
        int actualValue = position.getValue();

        //then
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("Position 객체 생성 시, 음수를 받으면 예외처리를 반환한다.")
    void createPosition() {
        //given
        int inputtedValue = -1;

        //then
        assertThatThrownBy(() -> new Position(inputtedValue)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Position 은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("increasePosition() 호출 시, 파라미터로 부터 입력받은 값 만큼 현재 value 값을 증가 시킨다.")
    void increasePosition() {
        //given
        Position position = new Position(1);
        int incrementalValue = 2;
        int expectedValue = 3;

        //when
        int actualValue = position.increasePosition(incrementalValue);

        //then
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @MethodSource("createPositionComparisonParameterProvider")
    @DisplayName("isFartherThan() 호출 시, 파라미터로 부터 입려 받은 Position 객체와 위치를 비교하여, 더 클 경우 true 를 반환한다.")
    void isFartherThan(Position position, Position anotherPosition, boolean expect) {
        //when
        boolean actual = position.isFatherThan(anotherPosition);

        //then
        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> createPositionComparisonParameterProvider() {
        return Stream.of(
                arguments(new Position(1), new Position(2), false,
                        arguments(new Position(2), new Position(1), true))
        );
    }

    @ParameterizedTest
    @MethodSource("createSameOrNotSamePositionsParameterProvider")
    @DisplayName("isSame() 호출 시, 거리를 비교하여 같으면 true 를 반환 그렇지 않으면 false 를 반환")
    void isSame(Position position, Position anotherPosition, boolean expect) {
        //when
        boolean actual = position.isSame(anotherPosition);
        //then
        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> createSameOrNotSamePositionsParameterProvider() {
        return Stream.of(
                arguments(new Position(1), new Position(1), true),
                arguments(new Position(1), new Position(2), false)
        );
    }
}
