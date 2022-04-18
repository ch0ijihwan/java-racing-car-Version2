package model.movement;

import java.util.Random;

public class RandomMovable implements MovementStrategy {
    private final Random RAMDOM = new Random();
    @Override
    public boolean generateMovable() {
        return RAMDOM.nextBoolean();
    }
}
