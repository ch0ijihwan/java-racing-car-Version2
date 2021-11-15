package model;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_SIZE = 5;
    private final String value;


    public Name(String value) {
        validateName(value);
        this.value = value;
    }

    private void validateName(final String value) {
        if (value.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("Name 값의 길이는 5를 초과할 수 없습니다.");
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
