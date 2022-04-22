package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberOfAttemptTest {
    @ParameterizedTest
    @DisplayName("객체 생성 시, 시도 횟수가 양수가 아닐 경우 예외처리를 반환한다.")
    @ValueSource(ints = {-1, 0})
    void validateForPositiveValue(final int inputtedValue) {
        //then
        assertThatThrownBy(() -> new NumberOfAttempt(inputtedValue)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 양수여야 합니다.");
    }

    @Test
    @DisplayName("decrease() 호출 시, 시도 횟수를 하나 줄인다.")
    void decrease() {
        //given
        int inputtedValue = 2;
        int expectedValue = 1;
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(inputtedValue);

        //when
        numberOfAttempt.decrease();

        //then
        assertThat(numberOfAttempt).isEqualTo(new NumberOfAttempt(expectedValue));
    }

    @ParameterizedTest
    @DisplayName("isEnd() 호출 시, 시도 횟수가 0 이라면 true 를 반환하고, 그렇지 않으면 false 를 반환한다.")
    @MethodSource("createNumberOfAttemptsValueParameterProvider")
    void isEnd(final int inputtedValue, final boolean expect) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(inputtedValue);
        numberOfAttempt.decrease();

        //when
        boolean actual = numberOfAttempt.isEnd();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    static Stream<Arguments> createNumberOfAttemptsValueParameterProvider() {
        return Stream.of(
                Arguments.of(1, true),Arguments.of(2, false)
        );
    }
}
