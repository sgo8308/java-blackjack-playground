package blackjack.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CardsTest {
    @Test
    void getSum_모든_카드의_값을_더한다() {
        //given
        Cards cards = getCardsOnlyCLOVER(CardNumber.TWO, CardNumber.THREE, CardNumber.FOUR);

        //when
        int actualSum = cards.getSum();

        //then
        assertThat(actualSum).isEqualTo(9);
    }

    @Test
    void getSum_A가_들어있을_때는_더했을_때_21이_넘는다면_1로_치환해서_계산() {
        //given
        Cards cardsWith1A = getCardsOnlyCLOVER(CardNumber.A, CardNumber.NINE, CardNumber.JACK);
        Cards cardsWith2A = getCardsOnlyCLOVER(CardNumber.A, CardNumber.A, CardNumber.JACK);

        //when
        int actualSum1A = cardsWith1A.getSum();
        int actualSum2A = cardsWith2A.getSum();

        //then
        assertThat(actualSum1A).isEqualTo(20);
        assertThat(actualSum2A).isEqualTo(12);
    }

    @Test
    void toString_마지막_카드_빼고_쉼표_붙힌_후_반환() {
        //given
        Cards cards = getCardsOnlyCLOVER(CardNumber.A, CardNumber.NINE, CardNumber.JACK);

        //when
        String cardsString = cards.toString();

        //then
        assertThat(cardsString).hasToString("A클로버, 9클로버, J클로버");
    }

    private Cards getCardsOnlyCLOVER(CardNumber num1, CardNumber num2, CardNumber num3) {
        Cards cards = new Cards(Arrays.asList(
                new Card(CardType.CLOVER, num1),
                new Card(CardType.CLOVER, num2),
                new Card(CardType.CLOVER, num3)
        ));
        return cards;
    }

}