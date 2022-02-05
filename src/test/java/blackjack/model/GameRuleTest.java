package blackjack.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import nextstep.fp.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameRuleTest {
    @Test
    void findLosers_카드의_합이_21이_넘는_플레이어들을_반환() {
        //given
        Player loser1 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.NINE, CardNumber.JACK, CardNumber.QUEEN));
        Player loser2 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.FIVE, CardNumber.JACK, CardNumber.QUEEN));
        Player noLoser1 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.TWO, CardNumber.THREE, CardNumber.FOUR));
        Player noLoser2 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.A, CardNumber.JACK, CardNumber.QUEEN));

        //when
        Players losers = GameRule.findLosers(new Players(Arrays.asList(loser1, loser2, noLoser1, noLoser2)));
        Players expectedPlayers = new Players(Arrays.asList(loser1, loser2));
        //then
        assertThat(losers).isEqualTo(expectedPlayers);
    }

    @Test
    void findWinners_21을_넘지_않으면서_21에_가장_가까운_플레이어가_1명일_때() {
        //given
        Player winner = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.A, CardNumber.JACK, CardNumber.QUEEN));
        Player loser1 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.FIVE, CardNumber.JACK, CardNumber.QUEEN));
        Player loser2 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.TWO, CardNumber.THREE, CardNumber.FOUR));

        //when
        Players winners = GameRule.findWinners(new Players(Arrays.asList(winner, loser1, loser2)));
        Players expectedPlayers = new Players(Arrays.asList(winner));
        //then
        assertThat(winners).isEqualTo(expectedPlayers);
    }

    @Test
    void findWinners_21을_넘지_않으면서_21에_가장_가까운_플레이어가_여러명일_때() {
        //given
        Player winner1 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.A, CardNumber.JACK, CardNumber.QUEEN));
        Player winner2 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.SIX, CardNumber.SEVEN, CardNumber.EIGHT));
        Player loser1 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.FIVE, CardNumber.JACK, CardNumber.QUEEN));
        Player loser2 = new GeneralPlayer(getCardsOnlyCLOVER(CardNumber.TWO, CardNumber.THREE, CardNumber.FOUR));

        //when
        Players winners = GameRule.findWinners(new Players(Arrays.asList(winner1,winner2, loser1, loser2)));
        Players expectedPlayers = new Players(Arrays.asList(winner1, winner2));
        //then
        assertThat(winners).isEqualTo(expectedPlayers);
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