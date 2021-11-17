package model;

import model.movement.MovementStrategy;
import model.vo.Car;
import model.vo.Cars;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final MovementStrategy movementStrategy;

    public RacingGame(final String[] inputtedNames, final MovementStrategy movementStrategy) {
        this.cars = new Cars(inputtedNames);
        this.movementStrategy = movementStrategy;

    }

    protected RacingGame(final List<Car> carListForTest, final MovementStrategy movementStrategy) {
        cars = new Cars(carListForTest);
        this.movementStrategy = movementStrategy;
    }

    public List<Car> getWinners() {
        return cars.winners();
    }

    public void raceOneRound() {
        cars.moveAll(movementStrategy);
    }

    public Cars getCars() {
        return this.cars;
    }
}
