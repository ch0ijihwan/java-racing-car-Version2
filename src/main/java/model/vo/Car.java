package model.vo;

import java.util.Objects;

public class Car {
    private static final int ONE_STEP = 1;
    private static final int START_POSITION = 0;
    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this.name = name;
        position = Position.valueOf(START_POSITION);
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Car move(final boolean movable) {
        if (movable) {
            return new Car(this.name, position.increasePosition(ONE_STEP));
        }
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
