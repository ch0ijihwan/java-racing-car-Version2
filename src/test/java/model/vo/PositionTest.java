package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {
    @Test
    @DisplayName("getValue() 호출 시, value 를 반환한다.")
    void getValue() {
        //given
        final int inputtedValue = 1;
        final int expectedValue = 1;
        Position position = Position.from(inputtedValue);

        //when
        int actual = position.getValue();

        //then
        assertThat(actual).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("Position 객체 생성 시, 음수를 받으면 예외처리를 반환한다.")
    void createPosition() {
        //given
        int inputtedValue = -1;

        //then
        assertThatThrownBy(() -> Position.from(inputtedValue)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Position 은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("increasePosition() 호출 시, 파라미터로 부터 입력받은 값 만큼을 증가시킨 Position 을 반환한다.")
    void increasePosition() {
        //given
        Position position = Position.from(1);
        int incrementalValue = 2;
        Position expectedPosition = Position.from(3);

        //when
        Position actualValue = position.increasePosition(incrementalValue);

        //then
        assertThat(actualValue).isEqualTo(expectedPosition);
    }
}
