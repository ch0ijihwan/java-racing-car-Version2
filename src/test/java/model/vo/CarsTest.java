package model.vo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of(
                Car.of("hi", 3), Car.of("hello", 3),
                Car.of("happy", 1)
        ));
    }

    @Test
    @DisplayName("Cars 객체 생성 시, 입력받은 자동차 이름 중 중복이 있으면 예외를 반환한다.")
    void createCars() {
        //given
        String[] inputtedCarNames = new String[]{"hello", "hello"};

        //then
        assertThatThrownBy(() -> new Cars(inputtedCarNames)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 받은 차 이름 중 중복이 있습니다.");
    }

    @Test
    @DisplayName("getCars() 호출 시, cars 를 반환한다.")
    void getCars() {
        //given
        List<Car> expect = List.of(
                Car.of("hi", 3), Car.of("hello", 3),
                Car.of("happy", 1));

        //when
        List<Car> actual = cars.getCars();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("getWinners() 호출 시, 자동차들 중 우승자의 이름을 뽑아 리스트 형태로 반환한다. 이때 우승자가 둘 이상일 경우 모두 다 반환한다.")
    void getWinners() {
        //given
        List<Car> expectedWinners = List.of(Car.of("hello", 3), Car.of("hi", 3));

        //when
        List<Car> actualWinners = cars.getWinners();

        //then
        assertThat(actualWinners).containsAll(expectedWinners);
    }
}