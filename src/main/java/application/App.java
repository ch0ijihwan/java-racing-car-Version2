package application;

import controller.Controller;
import model.movement.MovementStrategy;
import model.movement.RandomMovementStrategy;
import view.displaystrategy.StatusDisplay;
import view.displaystrategy.StatusDisplayStrategy;
import view.inputstrategy.ConsoleInputStrategy;
import view.inputstrategy.InputStrategy;

public class App {
    public static void main(String[] args) {
        MovementStrategy movementStrategy = new RandomMovementStrategy();
        InputStrategy inputStrategy = new ConsoleInputStrategy();
        StatusDisplayStrategy statusDisplayStrategy = new StatusDisplay();
        Controller controller = new Controller(movementStrategy, inputStrategy, statusDisplayStrategy);
        controller.run();
    }
}
