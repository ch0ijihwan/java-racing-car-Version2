package model.vo;

import java.util.Objects;

public class RoundCount {
    private static final int ONE_ROUND_COUNT = 1;
    private int count;

    public RoundCount(final int count) {
        this.count = count;
    }

    public int getRoundCount() {
        return this.count;
    }

    public void decreaseRoundCount() {
        this.count = count - ONE_ROUND_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundCount that = (RoundCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}