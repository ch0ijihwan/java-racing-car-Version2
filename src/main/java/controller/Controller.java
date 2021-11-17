package controller;

import model.RacingGame;
import model.movement.MovementStrategy;

import static view.Input.inputNumberAttempts;
import static view.Input.inputRacingCarNames;
import static view.StatusDisplay.*;

public class Controller {
    private final RacingGame racingGame;
    private int numberOfAttempts;

    public Controller(final MovementStrategy movementStrategy) {
        showInputNames();
        this.racingGame = new RacingGame(inputRacingCarNames(), movementStrategy);
        showInputNumberOfAttempts();
        this.numberOfAttempts = inputNumberAttempts();
    }

    public void run() {
        showStartGame();
        while (numberOfAttempts > 0) {
            racingGame.raceOneRound();
            showGameStatus(racingGame.getCars().getRacingCars());
            numberOfAttempts--;
        }
        showBar();
        showGameStatus(racingGame.getCars().getRacingCars());
        showEndGame(racingGame.getWinners());
    }
}
