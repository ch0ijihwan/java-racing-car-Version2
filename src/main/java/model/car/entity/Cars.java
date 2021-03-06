package model.car.entity;

import model.car.vo.Names;
import model.car.vo.Position;
import model.movement.MovementStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final Names names) {
        cars = names.getNames()
                .stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public Cars(final List<Car> cars) {
        validateCars(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void validateCars(final List<Car> cars) {
        validateNullOrEmpty(cars);
        validateDuplication(cars);
    }

    private void validateNullOrEmpty(final List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 없습니다.");
        }
    }

    private void validateDuplication(final List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException("자동차들 중 중복이 있습니다.");
        }
    }

    public Cars moveAllCar(final MovementStrategy movementStrategy) {
        List<Car> movedCars = cars.stream()
                .map(car -> car.move(movementStrategy.generateMovable()))
                .collect(Collectors.toUnmodifiableList());
        return new Cars(movedCars);
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
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
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
}
