package model.movement;

import java.util.Random;

public class RandomMovable implements MovementStrategy {
    private static final int NOT_MOVING_VALUE = 4;
    private static final Random RAMDOM = new Random();

    @Override
    public boolean generateMovable() {
        int judgmentValue = RAMDOM.nextInt(10);
        return canMove(judgmentValue);
    }

    private boolean canMove(final int boundaryValue) {
        return NOT_MOVING_VALUE<= boundaryValue;
    }
}
