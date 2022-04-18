package model.vo;

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
}
