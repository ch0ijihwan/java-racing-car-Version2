package model.vo;

import model.movement.MovementStrategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> racingCars;

    public Cars(final String[] inputtedNames) {
        validateDuplicationNames(inputtedNames);
        racingCars = Arrays.stream(inputtedNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(final List<Car> inputedCars) {
        racingCars = inputedCars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    public void moveAll(final MovementStrategy movementStrategy) {
        racingCars.forEach(car -> car.move(movementStrategy.generateMovable()));
    }

    private void validateDuplicationNames(final String[] tokens) {
        if (hasDuplication(tokens)) {
            throw new IllegalArgumentException("자동차의 이름은 중복 될 수 없습니다.");
        }
    }

    private boolean hasDuplication(final String[] tokens) {
        return tokens.length != Arrays.stream(tokens).distinct().count();
    }

    public List<Car> getWinnerCars() {
        int mostFarPosiotion = findMaxPosition();
        return findSamePositionCars(mostFarPosiotion);
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.racingCars) {
            if (car.getPosition().getValue() > maxPosition) {
                maxPosition = car.getPosition().getValue();
            }
        }
        return maxPosition;
    }

    private List<Car> findSamePositionCars(int pivotPosition) {
        return this.racingCars
                .stream()
                .filter(car -> car.getPosition().getValue() == pivotPosition)
                .collect(Collectors.toList());
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

