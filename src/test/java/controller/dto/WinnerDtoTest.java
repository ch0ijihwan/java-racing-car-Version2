package controller.dto;

import model.vo.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerDtoTest {
    @Test
    @DisplayName("getNames() 호출 시, 우승자의 이름들을 리스트로 반환한다.")
    void getNames() {
        //given
        List<Car> cars = List.of(Car.of("apple", 1), Car.of("hi", 1));
        List<String> expectedNames = List.of("apple", "hi");
        WinnerDto winnerDto = new WinnerDto(cars);

        //when
        List<String> actual = winnerDto.getNames();

        //then
        assertThat(actual).isEqualTo(expectedNames);
    }
}
