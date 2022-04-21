package application;

import controller.Controller;
import model.movement.MovementStrategy;
import model.movement.RandomMovable;
import view.display.ConsoleDisplay;
import view.display.Display;
import view.input.ConsoleInput;
import view.input.Input;

public class App {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Display display = new ConsoleDisplay();
        MovementStrategy movementStrategy = new RandomMovable();
        Controller controller = new Controller(input, display, movementStrategy);
    }
}
