package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PositionTest {
    private static final int NEGATIVE_NUMBER = -1;
    private Position position;

    @Test
    @DisplayName("객체 생성시 입력받은 양수를 position 으로 초기화 한다.")
    void createPosition()
    {
        //given
        int inputNumber = 3;
        int expectedNumber = 3;

        //when
        Position actual = new Position(inputNumber);

        //then
        assertThat(actual).isEqualTo(new Position(expectedNumber));
    }

    @Test
    @DisplayName("포지션에 대한 값이 음수일경우 IllegalArgumentException 반환 .")
    void validateName() {
        //then
        assertThatThrownBy(() -> new Position(NEGATIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Position 값이 음수입니다.");
    }
}
