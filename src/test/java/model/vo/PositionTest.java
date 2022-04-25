package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    @Test
    @DisplayName("포지션 값을 반환한다.")
    void getValue() {
        //given
        final int value = 1;
        Position position = Position.valueOf(value);

        //when
        int actual = position.getValue();

        //then
        assertThat(actual).isEqualTo(value);
    }

    @Test
    @DisplayName("Position 객체 생성 시, 음수를 받으면 예외처리를 반환한다.")
    void createPosition() {
        //given
        int negativeNumber = -1;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> Position.valueOf(negativeNumber))
                .withMessage("Position 은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("increasePosition() 호출 시, 파라미터로 부터 입력받은 값 만큼을 증가시킨 Position 을 반환한다.")
    void increasePosition() {
        //given
        Position position = Position.valueOf(1);
        int incrementalValue = 2;
        Position expect = Position.valueOf(3);

        //when
        Position actual = position.increasePosition(incrementalValue);

        //then
        assertThat(actual).isEqualTo(expect);
    }
}
