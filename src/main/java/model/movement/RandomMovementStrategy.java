package model.movement;

import java.util.Random;

public class RandomMovementStrategy implements MovementStrategy {
    Random RANDOM = new Random();

    @Override
    public boolean generateMovement() {
        return RANDOM.nextBoolean();
    }
}
