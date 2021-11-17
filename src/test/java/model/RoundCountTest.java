package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoundCountTest {
    @Test
    @DisplayName("RoundCount 객체 생성 시, 파라미터로 부터 입력받은 값을 count 로 저장한다.")
    void createRoundCount() {
        //given
        int input = 1;
        int expectedRoundCount = 1;

        //when
        RoundCount actualRoundCount = new RoundCount(input);

        //then
        assertThat(actualRoundCount).isEqualTo(new RoundCount(expectedRoundCount));
    }

    @Test
    @DisplayName("decreaseRoundCount 실행 시, RoundCount 의 값이 1 감소한다.")
    void decreaseRoundCount()
    {
        //given
        int input = 3;
        int expectedRoundCount = 2;
        RoundCount roundCount = new RoundCount(input);

        //when
        roundCount.decreaseRoundCount();

        //then
        assertThat(roundCount).isEqualTo(new RoundCount(expectedRoundCount));
    }

    @Test
    @DisplayName("getRountCount 실행 시, roundCount 를 int 형으로 반환한다.")
    void getRoundCount(){
        //given
        int input = 3;
        int expectedRoundCount = 3;
        RoundCount roundCount = new RoundCount(input);

        //when
        int actual = roundCount.getRoundCount();

        //then
        assertThat(actual).isEqualTo(expectedRoundCount);
    }
}