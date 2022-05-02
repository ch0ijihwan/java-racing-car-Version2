package model.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NamesTest {

    @Test
    @DisplayName("null 에 대한 예외처리를 한다.")
    void validateNull() {
        //then
        assertThatNullPointerException().isThrownBy(() -> new Names(null))
                .withMessage("null 값이 입력되었습니다.");
    }

    @Test
    @DisplayName("입력받은 이름들 중 중복이 있으면 예외를 반환한다.")
    void createCars() {
        //given
        List<String> names = List.of("apple", "apple");

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Names(names))
                .withMessage("입력 받은 이름들 중 중복이 있습니다.");
    }

    @Test
    @DisplayName("이름들을 반환한다.")
    void getNames() {
        //given
        Names names = new Names(List.of("apple", "hello", "hi"));
        List<Name> expect = List.of(new Name("apple"), new Name("hello"), new Name("hi"));

        //when
        List<Name> actual = names.getNames();

        //then
        assertThat(actual).isEqualTo(expect);
    }
}