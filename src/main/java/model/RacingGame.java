package model;

import model.movement.MovementStrategy;
import model.vo.Cars;
import model.vo.Names;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private Cars racingCars;
    private NumberOfAttempt numberOfAttempt;

    public RacingGame(final Names names, final int inputtedNumberOfAttempt) {
        validateNull(names);
        this.racingCars = new Cars(names);
        this.numberOfAttempt = new NumberOfAttempt(inputtedNumberOfAttempt);
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

    public List<String> getWinnerNames() {
        return racingCars.getWinners()
                .stream()
                .map(car -> car.getName().getValue())
                .collect(Collectors.toUnmodifiableList());
    }
}
