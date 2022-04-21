package model;

import model.movement.MovementStrategy;
import model.vo.Car;
import model.vo.Cars;

import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final Cars racingCars;
    private final NumberOfAttempt numberOfAttempt;

    public RacingGame(final String[] inputtedNames, final int inputtedNumberOfAttempt) {
        this.racingCars = new Cars(inputtedNames);
        this.numberOfAttempt = new NumberOfAttempt(inputtedNumberOfAttempt);
    }

    public RacingGame(final Cars inputtedCars, final int numberOfAttempt) {
        this.racingCars = inputtedCars;
        this.numberOfAttempt = new NumberOfAttempt(numberOfAttempt);
    }

    public List<Car> getWinners() {
        return racingCars.getWinners();
    }

    public void playOneRound(final MovementStrategy movementStrategy) {
        racingCars.moveAllCar(movementStrategy);
        numberOfAttempt.decrease();
    }

    public boolean isGameEnd() {
        return numberOfAttempt.isEnd();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return Objects.equals(racingCars, that.racingCars) && Objects.equals(numberOfAttempt, that.numberOfAttempt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars, numberOfAttempt);
    }

    public List<Car> getCarsDuringRacing() {
        return racingCars.getCars();
    }
}
