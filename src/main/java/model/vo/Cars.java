package model.vo;

import model.movement.MovementStrategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final String[] names) {
        validateDuplicationOfNames(names);
        cars = Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toUnmodifiableList());
    }

    protected Cars(final List<Car> cars) {
        this.cars = cars;
    }

    private void validateDuplicationOfNames(final String[] names) {
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("입력 받은 차 이름 중 중복이 있습니다.");
        }
    }

    public void moveAllCar(final MovementStrategy movementStrategy) {
        cars.forEach(car -> car.move(movementStrategy.generateMovable()));
    }

    public List<Car> getWinners() {
        List<Car> sortedCars = sortByPositionValue(this.cars);
        int topRecordIndex = sortedCars.size() - 1;
        Position topRecordPosition = sortedCars.get(topRecordIndex)
                .getPosition();
        return findCarsWithSameRecord(topRecordPosition);
    }

    private List<Car> sortByPositionValue(final List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(car -> car.getPosition().getValue()))
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Car> findCarsWithSameRecord(final Position topRecordPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(topRecordPosition))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
