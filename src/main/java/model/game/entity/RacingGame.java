package model.game.entity;

import model.car.entity.Cars;
import model.car.vo.Names;
import model.game.vo.NumberOfAttempt;
import model.movement.MovementStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGame {
    private Cars racingCars;
    private NumberOfAttempt numberOfAttempt;

    public RacingGame(final Names names, final NumberOfAttempt inputtedNumberOfAttempt) {
        validateNull(names);
        this.racingCars = new Cars(names);
        this.numberOfAttempt = inputtedNumberOfAttempt;
    }

    public RacingGame(final Cars cars, final NumberOfAttempt numberOfAttempt) {
        validateNull(cars);
        this.racingCars = cars;
        this.numberOfAttempt = numberOfAttempt;

    }

    private void validateNull(final Object inputtedNames) {
        if (inputtedNames == null) {
            throw new IllegalArgumentException("null 값이 입력되었습니다.");
        }
    }

    public void playOneRound(final MovementStrategy movementStrategy) {
        racingCars = racingCars.moveAllCar(movementStrategy);
        numberOfAttempt = numberOfAttempt.decrease();
    }

    public boolean isGameEnd() {
        return numberOfAttempt.isEnd();
    }

    public List<String> getCarNamesDuringRacing() {
        return racingCars.getCars()
                .stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getCarPositionsDuringRacing() {
        return racingCars.getCars()
                .stream()
                .map(car -> car.getPosition().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> findWinnerNames() {
        return racingCars.getWinners()
                .stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
