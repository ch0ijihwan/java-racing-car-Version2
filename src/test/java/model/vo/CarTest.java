package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @Test
    @DisplayName("getPosition() 호출 시, position 객체를 반환한다.")
    void getPosition() {
        //given
        car = Car.from("apple");

        //when
        Position actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(new Position(0));
    }

    @Test
    @DisplayName("getName() 호출 시, Name 객체를 반환한다.")
    void getName() {
        //given
        String inputtedCarName = "apple";
        car = Car.from("apple");

        //when
        Name actual = car.getName();

        //then
        assertThat(actual).isEqualTo(new Name(inputtedCarName));
    }

    @ParameterizedTest
    @DisplayName("move() 호출 시, 파라미터로 true 를 입력 받으면 Position 을 1 증가 시킨다.")
    @CsvSource(value = {"true,1", "false,0"})
    void move(final boolean movable, final int expectedPositionValue) {
        //given
        car = Car.from("apple");
        Position expectedPosition = new Position(expectedPositionValue);

        //when
        car.move(movable);

        //then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
