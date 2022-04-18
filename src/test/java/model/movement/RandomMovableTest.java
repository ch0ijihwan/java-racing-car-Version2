package model.movement;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovableTest {
    @Test
    @DisplayName("generateMovable() 호출 시 랜덤으로 true 혹은 false 를 반환한다.")
    void generateMovable() {
        //given
        MovementStrategy movementStrategy = new RandomMovable();

        //when
        boolean actual = movementStrategy.generateMovable();

        //then
        assertThat(actual).isInstanceOfAny(Boolean.class);
    }
}