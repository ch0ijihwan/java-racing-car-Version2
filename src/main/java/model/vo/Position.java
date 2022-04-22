package model.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class Position implements Comparable<Position> {
    private static final int MAXIMUM_POSITION_VALUE = 50;
    private static final int MINIMUM_POSITION_VALUE = 0;
    private static final Map<Integer, Position> positions = new HashMap<>();
    private final int value;

    static {
        IntStream.range(0, MAXIMUM_POSITION_VALUE)
                .forEach(positionValue -> positions.put(positionValue, new Position(positionValue)));
    }

    static Position from(final int value) {
        validatePositionRange(value);
        return positions.getOrDefault(value, new Position(value));
    }

    private Position(final int value) {
        validatePositionRange(value);
        this.value = value;

    }

    private static void validatePositionRange(final int value) {
        if (value < MINIMUM_POSITION_VALUE) {
            throw new IllegalArgumentException("Position 은 음수가 될 수 없습니다.");
        }
    }

    public final int getValue() {
        return value;
    }

    public Position increasePosition(final int incrementalValue) {
        return Position.from(value + incrementalValue);
    }

    @Override
    public int compareTo(Position otherPosition) {
        return getValue() - otherPosition.getValue();
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

    @Override
    public String toString() {
        return "Position{" +
                "value=" + value +
                '}';
    }
}
