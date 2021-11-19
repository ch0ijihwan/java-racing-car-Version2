package view.StatusDisplayStrategy;

import model.vo.Car;

import java.util.List;

public interface StatusDisplayStrategy {

    void showInputNames();

    void showInputNumberOfAttempts();

    void showStartGame();

    void showGameStatus(List<Car> racingCars);

    void showBar();

    void showEndGame(List<Car> winners);
}