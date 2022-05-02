package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    private static final int MAX_NAME_SIZE = 5;

    @Test
    @DisplayName("getValue() 호출 시, 이름을 반환한다.")
    void getValue() {
        //given
        String inputtedName = "apple";
        String expectedName = "apple";
        Name name = new Name(inputtedName);

        //when
        String actual = name.getValue();

        //then
        assertThat(actual).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @DisplayName("객체 생성 시, 이름의 글자의 갯수가 5를 초과거나 공백이면 예외처리를 반환한다.")
    @ValueSource(strings = {"banana", "", " "})
    void validateSizeOfName(final String inputtedName) {
        //then
        assertThatThrownBy(() -> new Name(inputtedName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("이름의 길이는 %d를 초과할 수 없고 공백이 아니어야 합니다.", MAX_NAME_SIZE));
    }
}