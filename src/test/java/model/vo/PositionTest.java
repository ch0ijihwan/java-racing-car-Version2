package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PositionTest {
    @Test
    @DisplayName("getValue() 호출 시, value 를 반환한다.")
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

    static Stream<Arguments> createSameOrNotSamePositionsParameterProvider() {
        return Stream.of(
                arguments(new Position(1), new Position(1), true),
                arguments(new Position(1), new Position(2), false)
        );
    }
}
