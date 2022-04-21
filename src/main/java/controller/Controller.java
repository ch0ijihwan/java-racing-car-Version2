package controller;

import controller.dto.CarsDto;
import controller.dto.WinnersDto;
import model.RacingGame;
import model.movement.MovementStrategy;
import view.display.Display;
import view.input.Input;

public class Controller {
    private final MovementStrategy movementStrategy;
    private final Input input;
    private final Display display;

    public Controller(final Input input, final Display display, final MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
        this.input = input;
        this.display = display;
        run();
    }

    private void run() {
        RacingGame racingGame = new RacingGame(input.inputCarNames(), input.inputNumberOfAttempt());
        while (!racingGame.isGameEnd()) {
            racingGame.playOneRound(movementStrategy);
            CarsDto carsDto = new CarsDto(racingGame.getCarsDuringRacing());
            display.printCarsStatus(carsDto);
        }
        WinnersDto winnersDto = new WinnersDto(racingGame.getWinners());
        display.printWinners(winnersDto);
    }
}