package model.car.vo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(final List<String> names) {
        Objects.requireNonNull(names, "null 값이 입력되었습니다.");
        validateDuplication(names);
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateDuplication(final List<String> names) {
        int sizeAfterDeduplication = names.stream()
                .collect(Collectors.toUnmodifiableSet())
                .size();
        if (sizeAfterDeduplication != names.size()) {
            throw new IllegalArgumentException("입력 받은 이름들 중 중복이 있습니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Names names1 = (Names) o;
        return Objects.equals(names, names1.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
