package controller;

import controller.dto.CarsDto;
import controller.dto.WinnersDto;
import model.RacingGame;
import model.movement.MovementStrategy;
import model.movement.RandomMovable;
import model.vo.Names;
import model.vo.NumberOfAttempt;
import view.display.Display;
import view.input.Input;

import java.util.Arrays;

public class Controller {
    private final Input input;
    private final Display display;

    public Controller(final Input input, final Display display) {
        this.input = input;
        this.display = display;
    }

    public void run() {
        RacingGame racingGame = setRacingGame();
        RacingGame endRacingGame = playRacingGame(racingGame);
        showRacingResult(endRacingGame);
    }

    private RacingGame setRacingGame() {
        Names names = new Names(Arrays.asList(input.inputCarNames()));
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(input.inputNumberOfAttempt());
        return new RacingGame(names, numberOfAttempt);
    }

    private RacingGame playRacingGame(final RacingGame racingGame) {
        MovementStrategy movementStrategy = new RandomMovable();
        while (!racingGame.isGameEnd()) {
            racingGame.playOneRound(movementStrategy);
            CarsDto carsDto = new CarsDto(racingGame.getCarNamesDuringRacing(), racingGame.getCarPositionsDuringRacing());
            display.printCarsStatus(carsDto);
        }
        return racingGame;
    }

    private void showRacingResult(final RacingGame racingGame) {
        WinnersDto winnersDto = new WinnersDto(racingGame.getWinnerNames());
        display.printWinners(winnersDto);
    }
}