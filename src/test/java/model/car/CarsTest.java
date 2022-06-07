package model.car;

import model.car.entity.Car;
import model.car.entity.Cars;
import model.car.vo.Names;
import model.movement.MovementStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarsTest {
    private Cars cars;

    @Test
    @DisplayName("Names 객체를 받아 자동차들을 생성한다.")
    void createByNames() {
        //given
        Names names = new Names(List.of("apple", "hi", "hello"));
        List<Car> expect = List.of(
                new Car("apple", 0),
                new Car("hi", 0),
                new Car("hello", 0));

        //when
        cars = new Cars(names);

        //then
        assertThat(cars).extracting("cars")
                .isEqualTo(expect);
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

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 받은 자동차들이 존재하지 않으면 예외처리 반환")
    void validateNullOfEmpty(final List<Car> input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(input))
                .withMessage("자동차가 없습니다.");
    }

    @Test
    @DisplayName("자동차들이 중복 될 경우 예외처리 반환")
    void validateDuplication() {
        //given
        List<Car> input = List.of(new Car("apple", 1),
                new Car("apple", 1));
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Cars(input))
                .withMessage("자동차들 중 중복이 있습니다.");
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
                new Car("apple", 2),
                new Car("hi", 2)
        );

        //when
        List<Car> actual = cars.getWinners();

        //then
        assertThat(actual).containsAll(expect);
    }
}