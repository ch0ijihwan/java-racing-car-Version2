package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("이름 객체 생성시, 입력받은 문자열을 이름으로 저장한다.")
    void createName() {
        //given
        String inputName = "jihwan";
        String expectedName = "jihwan";

        //when
        Name actual = new Name(inputName);

        //then
        assertThat(actual).isEqualTo(new Name(expectedName));
    }

    @DisplayName("이름 객체의 이름의 길이는  5자를 초과할 수 없다.")
    void validateNameSize() {
        //given
        String inputName = "JiHwan2";

        //then
        assertThatThrownBy(() -> new Name(inputName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Name 값의 길이는 5를 초과할 수 없습니다.");
    }
}
