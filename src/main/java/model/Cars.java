package model;

import model.movement.MovementStrategy;
import model.vo.Car;

import java.util.Arrays;
import java.util.Comparator;
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

    protected Cars(final List<Car> inputCars) {
        racingCars = inputCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void raceAll(final MovementStrategy movementStrategy) {
        racingCars.forEach(car -> car.move(movementStrategy.generateMovement()));
    }

    private void validateDuplicationNames(String[] tokens) {
        if (tokens.length != Arrays.stream(tokens).distinct().count()) {
            throw new IllegalArgumentException("자동차의 이름은 중복 될 수 없습니다.");
        }
    }

    public List<Car> winners() {
        Car topCar = findTopCar();
        return racingCars
                .stream()
                .filter(topCar::equalsDistance)
                .collect(Collectors.toList());
    }

    private Car findTopCar() {
        List<Car> winners = sortCars(racingCars);
        return winners.get(winners.size() - 1);
    }

    private List<Car> sortCars(List<Car> racingCars) {
        return racingCars.stream()
                .sorted(Comparator.comparing(car -> car.getPosition().getValue()))
                .collect(Collectors.toUnmodifiableList());
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

