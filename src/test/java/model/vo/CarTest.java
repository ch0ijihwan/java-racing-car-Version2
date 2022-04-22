package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private Car car;

    @Test
    @DisplayName("from() 호출 시, 파라미터로 부터 입력 받은 name 값으로 이름을 가지며 자동차의 포지션을 0으로 가진 Car 객체를 생성한다.")
    void from() {
        //given
        String inputtedName = "apple";
        int expectedPosition = 0;

        //when
        Car actual = Car.from(inputtedName);

        //then
        assertThat(actual).isEqualTo(Car.of(inputtedName, expectedPosition));
    }

    @Test
    @DisplayName("of() 호출 시, 파라미터로 부터 입력 받은 name 과 position 을 가진 Car 객체를 생성한다.")
    void of() {
        //given
        String inputtedName = "apple";
        int inputtedPosition = 1;

        //when
        Car actual = Car.of(inputtedName, inputtedPosition);

        //then
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(new Name(inputtedName)),
                () -> assertThat(actual.getPosition()).isEqualTo(Position.from(inputtedPosition))
        );
    }

    @Test
    @DisplayName("getPosition() 호출 시, position 객체를 반환한다.")
    void getPosition() {
        //given
        car = Car.from("apple");
        Position expect = Position.from(0);

        //when
        Position actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(expect);
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
        Position expectedPosition = Position.from(expectedPositionValue);

        //when
        car.move(movable);

        //then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
