package model;

import java.util.Objects;

public class NumberOfAttempt {
    private static final int MIN_VALUE = 0;
    private int value;

    public NumberOfAttempt(final int value) {
        validatePositiveValue(value);
        this.value = value;
    }

    private void validatePositiveValue(final int value) {
        if (value < 1) {
            throw new IllegalArgumentException("시도 횟수는 양수여야 합니다.");
        }
    }

    public boolean isEnd() {
        return value == MIN_VALUE;
    }

    public void decrease() {
        value--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberOfAttempt that = (NumberOfAttempt) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "NumberOfAttempt{" +
                "value=" + value +
                '}';
    }
}
