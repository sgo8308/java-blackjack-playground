package blackjack.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void draw_덱에서_카드가_한_장_줄어든다() {
        //when
        Card card = Deck.drawAndRemove();
        boolean isSizeDown = Deck.isSize(51);
        //then
        Assertions.assertThat(isSizeDown).isTrue();
    }
}