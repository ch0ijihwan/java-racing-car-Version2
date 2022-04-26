package model.vo;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(final List<String> names) {
        validateNull(names);
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

    private void validateNull(final List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("null 값이 입력되었습니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
