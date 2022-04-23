package controller.dto;

import model.vo.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersDtoTest {
    @Test
    @DisplayName("getNames() 호출 시, 입력 받았던 자동차들의 이름을 리스트로 반환한다.")
    void getNames() {
        //given
        List<Car> cars = List.of(Car.of("apple", 1), Car.of("hi", 1));
        List<String> expectedNames = List.of("apple", "hi");
        WinnersDto winnersDto = new WinnersDto(cars);

        //when
        List<String> actual = winnersDto.getNames();

        //then
        assertThat(actual).isEqualTo(expectedNames);
    }
}
