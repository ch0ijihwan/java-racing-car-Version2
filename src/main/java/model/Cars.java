package model;

import model.vo.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    List<Car> racingCars;

    public Cars(final String[] inputtedNames) {
        validateDuplicationNames(inputtedNames);
        racingCars = Arrays.stream(inputtedNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    private void validateDuplicationNames(String[] tokens) {
        if (tokens.length != Arrays.stream(tokens).distinct().count()) {
            throw new IllegalArgumentException("자동차의 이름은 중복 될 수 없습니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(racingCars, cars.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}

