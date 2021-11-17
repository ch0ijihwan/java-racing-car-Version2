import controller.Controller;
import model.movement.MovementStrategy;
import model.movement.RandomMovementStrategy;

public class App {
    public static void main(String[] args) {
        MovementStrategy movementStrategy = new RandomMovementStrategy();
        Controller controller = new Controller(movementStrategy);
        controller.run();
    }
}
