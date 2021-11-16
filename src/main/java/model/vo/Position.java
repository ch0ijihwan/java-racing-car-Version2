package model.vo;

import java.util.Objects;

public class Position {
    private int value;

    public Position(final int value) {
        validatePosition(value);
        this.value = value;
    }

    public Position move(int movement) {
        value = value + movement;
        return this;
    }

    public int getValue() {
        return value;
    }

    private void validatePosition(final int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position 값이 음수입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return value == position1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
