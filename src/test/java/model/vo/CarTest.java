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
    @DisplayName("입력받은 Name 을 가지며 Position 을 0으로 가진 Car 객체를 생성한다.")
    void createByName() {
        //given
        Name name = new Name("apple");

        //when
        Car actual = new Car(name);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("name", new Name("apple"))
                .hasFieldOrPropertyWithValue("position", Position.valueOf(0));
    }

    @Test
    @DisplayName("name 과 position 을 가진 Car 객체를 생성한다.")
    void createByNameAndPosition() {
        //given
        Name name = new Name("apple");
        Position position = Position.valueOf(1);

        //when
        Car actual = new Car(name, position);

        //then
        assertAll(
                () -> assertThat(actual.getName()).isEqualTo(name),
                () -> assertThat(actual.getPosition()).isEqualTo(position)
        );
    }

    @Test
    @DisplayName("getPosition() 호출 시, position 객체를 반환한다.")
    void getPosition() {
        //given
        car = new Car(new Name("apple"));
        Position expect = Position.valueOf(0);

        //when
        Position actual = car.getPosition();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("getName() 호출 시, Name 객체를 반환한다.")
    void getName() {
        //given
        Name name = new Name("apple");
        car = new Car(name);

        //when
        Name actual = car.getName();

        //then
        assertThat(actual).isEqualTo(name);
    }

    @ParameterizedTest
    @DisplayName("move() 호출 시, 파라미터로 true 를 입력 받으면 Position 을 1 증가 시킨 자동차를 생성해 반환한다.")
    @CsvSource(value = {"true,1", "false,0"})
    void move(final boolean movable, final int position) {
        //given
        Name name = new Name("apple");
        car = new Car(name, Position.valueOf(0));

        //when
        Car actual = car.move(movable);

        //then
        assertThat(actual).isEqualTo(new Car(name, Position.valueOf(position)));
    }
}
