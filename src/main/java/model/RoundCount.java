package model;

import java.util.Objects;

public class RoundCount {
    private int count;

    public RoundCount(int count) {
        this.count = count;
    }

    public int getRoundCount() {
        return this.count;
    }

    public void decreaseRoundCount() {
        this.count = count - 1;
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