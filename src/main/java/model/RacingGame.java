package model;

import model.movement.MovementStrategy;
import model.vo.Car;
import model.vo.Cars;
import model.vo.RoundCount;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final MovementStrategy movementStrategy;
    private RoundCount roundCount;

    public RacingGame(final String[] inputtedNames, final int inputtedRoundCount, final MovementStrategy movementStrategy) {
        this.cars = new Cars(inputtedNames);
        this.roundCount = new RoundCount(inputtedRoundCount);
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

    public RoundCount getRoundCount() {
        return roundCount;
    }

    public boolean isNotOver() {
        return roundCount.getRoundCount() != 0;
    }

    public void endOneRound() {
        roundCount.decreaseRoundCount();
    }
}
