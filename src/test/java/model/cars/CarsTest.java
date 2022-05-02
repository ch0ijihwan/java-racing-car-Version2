package model.cars;

import model.movement.MovementStrategy;
import model.vo.Name;
import model.vo.Names;
import model.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    private Cars cars;

    @Test
    @DisplayName("Names 객체를 받아 자동차들을 생성한다.")
    void createByNames() {
        //given
        Names names = new Names(List.of("apple", "hi", "hello"));

        //when
        cars = new Cars(names);

        //then
        assertThat(cars).extracting("cars").isEqualTo(
                List.of(new Car("apple", 0),
                        new Car("hi", 0),
                        new Car("hello", 0)
                )
        );
    }

    @Test
    @DisplayName("cars 를 반환한다.")
    void getCars() {
        //given
        cars = new Cars(List.of(
                new Car("hello", 1),
                new Car("apple", 2)
        ));

        List<Car> expect = List.of(
                new Car("hello", 1),
                new Car("apple", 2)
        );

        //when
        List<Car> actual = cars.getCars();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("자동차들을 주어진 움직임 전략에 따라 움직인 후, 자동차들을 반환한다.")
    void moveAllCar() {
        //given
        cars = new Cars(List.of(
                new Car("hello", 1),
                new Car("apple", 2)
        ));
        MovementStrategy testMovement = new alwaysMove();
        List<Car> expect = List.of(
                new Car("hello", 2),
                new Car("apple", 3)
        );

        //when
        Cars actual = this.cars.moveAllCar(testMovement);

        //then
        assertThat(actual).hasFieldOrPropertyWithValue("cars", expect);
    }

    static class alwaysMove implements MovementStrategy {
        @Override
        public boolean generateMovable() {
            return true;
        }
    }

    @Test
    @DisplayName("getWinners() 호출 시, 자동차들 중 우승자의 이름을 뽑아 리스트 형태로 반환한다. 이때 우승자가 둘 이상일 경우 모두 다 반환한다.")
    void getWinners() {
        //given
        cars = new Cars(
                List.of(
                        new Car("hello", 1),
                        new Car("apple", 2),
                        new Car("hi", 2)
                )
        );

        List<Car> expect = List.of(
                new Car(new Name("apple"), Position.valueOf(2)),
                new Car(new Name("hi"), Position.valueOf(2))
        );

        //when
        List<Car> actual = cars.getWinners();

        //then
        assertThat(actual).containsAll(expect);
    }
}