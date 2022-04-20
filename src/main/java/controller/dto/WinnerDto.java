package controller.dto;

import model.vo.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDto {
    private final List<String> names;

    public WinnerDto(final List<Car> cars) {
        this.names = extractCarNames(cars);
    }

    private List<String> extractCarNames(final List<Car> cars) {
        return cars.stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> getNames() {
        return names;
    }
}
