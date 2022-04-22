package model.vo;

import model.movement.MovementStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final String[] names) {
        validateDuplicationOfNames(names);
        cars = Arrays.stream(names)
                .map(Car::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private void validateDuplicationOfNames(final String[] names) {
        if (hasDuplication(names)) {
            throw new IllegalArgumentException("입력 받은 차 이름 중 중복이 있습니다.");
        }
    }

    private boolean hasDuplication(final String[] names) {
        return Arrays.stream(names)
                .distinct()
                .count() != names.length;
    }

    public void moveAllCar(final MovementStrategy movementStrategy) {
        cars.forEach(car -> car.move(movementStrategy.generateMovable()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
                .sorted(Comparator.comparing(Car::getPosition))
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
