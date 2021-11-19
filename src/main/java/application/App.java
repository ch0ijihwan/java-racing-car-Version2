package application;

import controller.Controller;
import model.movement.MovementStrategy;
import model.movement.RandomMovementStrategy;
import view.displayStrategy.StatusDisplay;
import view.displayStrategy.StatusDisplayStrategy;
import view.inputStrategy.ConsoleInputStrategy;
import view.inputStrategy.InputStrategy;

public class App {
    public static void main(String[] args) {
        MovementStrategy movementStrategy = new RandomMovementStrategy();
        InputStrategy inputStrategy = new ConsoleInputStrategy();
        StatusDisplayStrategy statusDisplayStrategy = new StatusDisplay();
        Controller controller = new Controller(movementStrategy, inputStrategy, statusDisplayStrategy);
        controller.run();
    }
}
