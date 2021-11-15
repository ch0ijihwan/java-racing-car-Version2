package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.text.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {
    private static final int NEGATIVE_NUMBER = -1;
    private Position position;

    @Test
    @DisplayName("포지션에 대한 값이 음수일경우 IllegalArgumentException 반환 .")
    void validateName() {
        //then
        assertThatThrownBy(() -> {
            new Position(NEGATIVE_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
