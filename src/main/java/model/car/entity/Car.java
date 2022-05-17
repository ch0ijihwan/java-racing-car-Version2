package model.car.entity;

import model.car.vo.Name;
import model.car.vo.Position;

import java.util.Objects;

public class Car {

    private static final int ONE_STEP = 1;

    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this.name = name;
        position = Position.valueOfDefaultWithZero();
    }

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(final String name, final int position) {
        this.name = new Name(name);
        this.position = Position.valueOf(position);
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}
