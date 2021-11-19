package model.movement;

import java.util.Random;

public class RandomMovementStrategy implements MovementStrategy {
    private final Random random = new Random();

    @Override
    public boolean generateMovement() {
        return RANDOM.nextBoolean();
    }
}
