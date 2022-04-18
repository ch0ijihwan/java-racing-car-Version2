package model.vo;

import java.util.Objects;

public class Position {
    private int value;

    public Position(final int value) {
        validatePositionRange(value);
        this.value = value;
    }

    private void validatePositionRange(final int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Position 은 음수가 될 수 없습니다.");
        }
    }

    public final int getValue() {
        return value;
    }

    public int increasePosition(final int incrementalValue) {
        this.value += incrementalValue;
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
