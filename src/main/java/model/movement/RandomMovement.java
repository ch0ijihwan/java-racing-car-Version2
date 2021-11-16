package model.movement;

import java.util.Random;

public class RandomMovement implements MovementStrategy {
    private static final int RANDOM_RANGE = 2;
    Random RANDOM = new Random();

    @Override
    public int generateMovement() {
        return RANDOM.nextInt(RANDOM_RANGE);
    }
}
