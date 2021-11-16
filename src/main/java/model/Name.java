package model;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_SIZE = 5;
    private static final int MIN_NAME_SIZE = 1;
    private final String value;

    public Name(String value) {
        validateNameSize(value);
        this.value = value;
    }

    private void validateNameSize(final String value) {
        if (value.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("Name 값의 길이는 5를 초과할 수 없습니다.");
        }
        if (value.length() < MIN_NAME_SIZE) {
            throw new IllegalArgumentException("Name 값의 길이는 0보다 길어야합니다.");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
