package model.vo;

import java.util.Objects;

public class Car {
    private Position position;
    private final Name name;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean equalsDistance(Car car) {
        return this.position.equals(car.position);
    }

    public void move(int movement) {
        this.position = this.position.move(movement);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(position, car.position) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position.getValue() +
                ", name=" + name.getValue() +
                '}';
    }
}
