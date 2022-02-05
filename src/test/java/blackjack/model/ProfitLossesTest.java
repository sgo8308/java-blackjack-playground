package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProfitLossesTest {

    static final double JIWOO_BET_AMOUNT = 10000;
    static final double SOHO_BET_AMOUNT = 20000;
    static BetMoneys betMoneys;

    @BeforeAll
    static void beforeAll() {
        betMoneys = new BetMoneys();

    }

    @Test
    void 플레이어가_첫_2장_블랙잭으로_이기고_딜러는_졌을_때() {
        //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.A, CardNumber.JACK);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE);
        Player dealer = createDealerWithCards(CardNumber.FIVE, CardNumber.EIGHT);

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));

        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney(SOHO_BET_AMOUNT));

        //when

        ProfitLosses profitLosses = new ProfitLosses();
        profitLosses.update(betMoneys, players);
        String actual = profitLosses.toString();
        String expected = "soho: " + (int) (-1 * SOHO_BET_AMOUNT) + "\n" +
                "Dealer: " + (int) (-1.5 * JIWOO_BET_AMOUNT + SOHO_BET_AMOUNT) + "\n" +
                "jiwoo: " + (int) (1.5 * JIWOO_BET_AMOUNT) + "\n";

        //then
        Assertions.assertThat(actual).hasToString(expected);
    }

    private Player createPlayerWithNameAndCards(String name, CardNumber... cardNumbers) {
        List<Card> cardList = createCardList(cardNumbers);
        Player player = new GeneralPlayer(new PlayerName(name), new Cards(cardList));
        return player;
    }

    private Player createDealerWithCards(CardNumber... cardNumbers) {
        List<Card> cardList = createCardList(cardNumbers);
        Player player = new Dealer(new Cards(cardList));
        return player;
    }

    private List<Card> createCardList(CardNumber[] cardNumbers) {
        List<Card> cardList = new ArrayList<>();
        for (CardNumber cardNumber : cardNumbers) {
            cardList.add(new Card(CardType.CLOVER, cardNumber));
        }
        return cardList;
    }
}