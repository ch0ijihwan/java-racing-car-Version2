package controller;

import model.RacingGame;
import model.movement.MovementStrategy;
import view.displayStrategy.StatusDisplayStrategy;
import view.inputStrategy.InputStrategy;

public class Controller {
    private final RacingGame racingGame;
    private final StatusDisplayStrategy statusDisplayStrategy;

    public Controller(final MovementStrategy movementStrategy, final InputStrategy inputStrategy, final StatusDisplayStrategy statusDisplayStrategy) {
        this.statusDisplayStrategy = statusDisplayStrategy;
        statusDisplayStrategy.showInputNames();
        String[] inputtedNames = inputStrategy.inputRacingCarNames();
        statusDisplayStrategy.showInputNumberOfAttempts();
        int numberOfAttempts = inputStrategy.inputNumberAttempts();
        this.racingGame = new RacingGame(inputtedNames, numberOfAttempts, movementStrategy);
    }

    public void run() {
        statusDisplayStrategy.showStartGame();
        while (racingGame.isNotOver()) {
            racingGame.raceOneRound();
            statusDisplayStrategy.showGameStatus(racingGame.getCars().getRacingCars());
            racingGame.endOneRound();
        }
        statusDisplayStrategy.showBar();
        statusDisplayStrategy.showGameStatus(racingGame.getCars().getRacingCars());
        statusDisplayStrategy.showEndGame(racingGame.getWinners());
    }
}
