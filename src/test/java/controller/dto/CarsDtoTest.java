package controller.dto;

import model.vo.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsDtoTest {
    private CarsDto carsDto;

    @BeforeEach
    void setUp() {
        List<Car> cars = List.of(
                Car.of("apple", 1),
                Car.of("hi", 2),
                Car.of("hello", 3));
        carsDto = new CarsDto(cars);
    }

    @Test
    @DisplayName("getCarNames(), 호출 시 자동차들의 이름을 반환한다.")
    void getCarNames() {
        //given
        List<String> expectedNames = List.of("apple", "hi", "hello");

        //when
        List<String> actual = carsDto.getCarNames();

        //then
        assertThat(actual).isEqualTo(expectedNames);
    }

    @Test
    @DisplayName("getCarNames(), 호출 시 자동차들의 위치를 반환한다.")
    void getCarPositions() {
        //given
        List<Integer> expectedPositions = List.of(1, 2, 3);

        //when
        List<Integer> actual = carsDto.getCarPositions();

        //then
        assertThat(actual).isEqualTo(expectedPositions);
    }
}