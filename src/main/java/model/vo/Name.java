package model.vo;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_SIZE = 5;
    private final String value;

    public Name(final String name) {
        validateSizeOfName(name);
        value = name;
    }

    private void validateSizeOfName(final String name) {
        if (isLongerThanNameLengthRule(name) || name.isBlank()) {
            throw new IllegalArgumentException(String.format("이름의 길이는 %d를 초과할 수 없고 공백이 아니어야 합니다.", MAX_NAME_SIZE));
        }
    }

    private boolean isLongerThanNameLengthRule(final String name) {
        return name.length() > MAX_NAME_SIZE;
    }

    public String getValue() {
        return this.value;
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
