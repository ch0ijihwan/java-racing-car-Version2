package model.vo;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Position implements Comparable<Position> {

    private static final int MAXIMUM_VALUE_OF_FREQUENTLY_USED_POSITION = 50;
    private static final int MINIMUM_POSITION_VALUE = 0;
    private static final int DEFAULT_POSITION_VALUE = 0;
    private static final Map<Integer, Position> CACHE_POSITIONS = createCacheForPositions();

    private final int value;

    private static Map<Integer, Position> createCacheForPositions() {
        return IntStream.range(MINIMUM_POSITION_VALUE, MAXIMUM_VALUE_OF_FREQUENTLY_USED_POSITION)
                .boxed()
                .collect(Collectors.toUnmodifiableMap(key -> key, Position::new));
    }

    public static Position valueOfDefaultWithZero() {
        return CACHE_POSITIONS.get(DEFAULT_POSITION_VALUE);
    }

    public static Position valueOf(final int value) {
        return CACHE_POSITIONS.getOrDefault(value, new Position(value));
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
        return Position.valueOf(value + incrementalValue);
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
