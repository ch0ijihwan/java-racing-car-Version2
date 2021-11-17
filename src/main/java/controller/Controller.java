package controller;

import model.RacingGame;
import model.movement.MovementStrategy;

import static view.Input.inputNumberAttempts;
import static view.Input.inputRacingCarNames;
import static view.StatusDisplay.*;

public class Controller {
    private final RacingGame racingGame;

    public Controller(final MovementStrategy movementStrategy) {
        showInputNames();

        showInputNumberOfAttempts();
        String[] inputtedNames = inputRacingCarNames();
        int numberOfAttempts = inputNumberAttempts();
        this.racingGame = new RacingGame(inputtedNames, numberOfAttempts, movementStrategy);
    }

    public void run() {
        showStartGame();
        while (racingGame.isNotOver()) {
            racingGame.raceOneRound();
            showGameStatus(racingGame.getCars().getRacingCars());
            racingGame.endOneRound();
        }
        showBar();
        showGameStatus(racingGame.getCars().getRacingCars());
        showEndGame(racingGame.getWinners());
    }
}
