package controller.dto;

import model.vo.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {
    private final List<String> carNames;
    private final List<Integer> carPositions;

    public CarsDto(final List<Car> cars) {
        carNames = extractCarNames(cars);
        carPositions = extractCarPositions(cars);
    }

    private List<String> extractCarNames(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Integer> extractCarPositions(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getPosition().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
