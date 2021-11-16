package model;

import model.vo.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    @DisplayName("객체 생성시 자동차 이름 배열을 입력받아, 자동차 리스트를 생성한다.")
    void createCarList() {
        //given
        String[] inputTokens = new String[]{"coco", "apple", "india"};
        List<Car> expectedCars = Arrays.asList(new Car("coco"), new Car("apple"), new Car("india"));
        Cars cars = new Cars(inputTokens);

        //when
        List<Car> actualCars = cars.getRacingCars();

        //then
        assertThat(actualCars).isEqualTo(expectedCars);
    }

    @Test
    @DisplayName("자동차 이름 배열에서 중복 값이 있으면 예외처리를 반환한다.")
    void validateNamesDuplication() {
        //given
        String[] inputNames = new String[]{"coco", "coco", "apple"};

        //then
        assertThatThrownBy(() -> new Cars(inputNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 중복 될 수 없습니다.");
    }
}