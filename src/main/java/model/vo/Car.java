package model.vo;

import java.util.Objects;

public class Car {
    private static final int ONE_STEP = 1;
    private static final int START_POSITION = 0;
    private final Name name;
    private final Position position;

    public static Car from(final String name) {
        return of(name, START_POSITION);
    }

    public static Car of(final String name, final int position) {
        return new Car(name, position);
    }

    private Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void move(final boolean movable) {
        if (movable) {
            position.increasePosition(ONE_STEP);
        }
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
