package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("Car 객체 생성시 자동차의 이름만 받은경우, 받은 이름과 Position 을 0 으로 하는 자동차 객체를 생성한다.")
    void createCarWhenInputName() {
        //given
        String inputName = "cocoa";
        String expectName = "cocoa";
        int expectedPosition = 0;

        //when
        Car car = new Car(inputName);

        //then
        assertThat(car).isEqualTo(new Car(expectName, expectedPosition));
    }

    @Test
    @DisplayName("객체 생성시, name 과 position 에 대한 값을 입력 받으면, 그 값에 대한 Name 객체와 Position 객체를 생성한다.")
    void createCarWhenInputNameAndPosition() {
        //given
        String inputName = "apple";
        int inputPosition = 2;
        String expectedName = "apple";
        int expectedPosition = 2;

        //when
        Car actual = new Car(inputName, inputPosition);

        //then
        assertThat(actual).isEqualTo(new Car(expectedName, expectedPosition));
    }

    @Test
    @DisplayName("move 메서드 실행시 파라미터로 부터 입력받은 수 만큼, 기존의 position 값에 입력받은 값을 더한 새로은 Position 객체로 갈아 끼운다.")
    void move() {
        //given
        Car car = new Car("apple", 1);
        int expectedPosition = 2;

        //when
        car.move(true);
        Position actualPosition = car.getPosition();

        //then
        assertThat(actualPosition).isEqualTo(new Position(expectedPosition));
    }
}
