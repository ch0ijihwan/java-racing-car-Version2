package model.vo;

import java.util.Objects;

public class NumberOfAttempt {

    private static final int END_POINT = 0;
    private static final int MIN_NUMBER_OF_ATTEMPT = 0;
    private static final int SCALE_OF_DECREASE = 1;
    private final int value;

    public NumberOfAttempt(final int value) {
        validatePositiveValue(value);
        this.value = value;
    }

    private void validatePositiveValue(final int value) {
        if (value < MIN_NUMBER_OF_ATTEMPT) {
            throw new IllegalArgumentException("시도 횟수는 음수가 아니어야 합니다.");
        }
    }

    public boolean isEnd() {
        return value == END_POINT;
    }

    public NumberOfAttempt decrease() {
        int decreasedValue = value - SCALE_OF_DECREASE;
        return new NumberOfAttempt(decreasedValue);
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
