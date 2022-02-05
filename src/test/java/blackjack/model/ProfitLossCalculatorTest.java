package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProfitLossCalculatorTest {

    static BetMoneys betMoneys;
    static final double JIWOO_BET_AMOUNT = 10000;
    static final double SOHO_BET_AMOUNT = 20000;
    @BeforeAll
    static void beforeAll() {
        betMoneys = new BetMoneys();

    }

    @Test
    void 플레이어_혼자_처음_2장으로_블랙잭_얻었을_때() {
        //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.A, CardNumber.JACK);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE);
        Player dealer = createDealerWithCards(CardNumber.FIVE, CardNumber.EIGHT);

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));
        Players winners = GameRule.findWinners(players);

        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney(SOHO_BET_AMOUNT));

        //when
        ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(jiwoo);
        double jiwooProfitLoss = profitLossCalculator.calculateProfitLoss(betMoneys, winners);

        ProfitLossCalculator profitLossCalculator2 = new ProfitLossCalculator(soho);
        double sohoProfitLoss = profitLossCalculator2.calculateProfitLoss(betMoneys, winners);

        //then
        Assertions.assertThat(jiwooProfitLoss).isEqualTo(1.5 * JIWOO_BET_AMOUNT);
        Assertions.assertThat(sohoProfitLoss).isEqualTo(-1 * SOHO_BET_AMOUNT);
   }

    @Test
    void 딜러_혼자_처음_2장으로_블랙잭_얻었을_때() {
         //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.ONE, CardNumber.JACK);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE);
        Player dealer = createDealerWithCards(CardNumber.A, CardNumber.JACK);
        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney( SOHO_BET_AMOUNT));

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));
        Players winners = GameRule.findWinners(players);

        //when
        ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(jiwoo);
        double jiwooProfitLoss = profitLossCalculator.calculateProfitLoss(betMoneys, winners);

        ProfitLossCalculator profitLossCalculator2 = new ProfitLossCalculator(soho);
        double sohoProfitLoss = profitLossCalculator2.calculateProfitLoss(betMoneys, winners);

        //then
        Assertions.assertThat(jiwooProfitLoss).isEqualTo(-1 * JIWOO_BET_AMOUNT);
        Assertions.assertThat(sohoProfitLoss).isEqualTo(-1 * SOHO_BET_AMOUNT);
    }
    @Test
    void 플레이어와_딜러가_같이_처음_2장으로_블랙잭_얻었을_떄() {
         //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.A, CardNumber.JACK);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE);
        Player dealer = createDealerWithCards(CardNumber.A, CardNumber.QUEEN);
        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney(SOHO_BET_AMOUNT));

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));
        Players winners = GameRule.findWinners(players);

        //when
        ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(jiwoo);
        double jiwooProfitLoss = profitLossCalculator.calculateProfitLoss(betMoneys, winners);

        ProfitLossCalculator profitLossCalculator2 = new ProfitLossCalculator(soho);
        double sohoProfitLoss = profitLossCalculator2.calculateProfitLoss(betMoneys, winners);

        //then
        Assertions.assertThat(jiwooProfitLoss).isEqualTo(0);
        Assertions.assertThat(sohoProfitLoss).isEqualTo(-1 * SOHO_BET_AMOUNT);
    }


    @Test
    void 일반적으로_딜러가_이겼을_때() {
         //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.ONE, CardNumber.JACK, CardNumber.EIGHT);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE, CardNumber.FIVE);
        Player dealer = createDealerWithCards(CardNumber.A, CardNumber.JACK);
        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney(SOHO_BET_AMOUNT));

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));
        Players winners = GameRule.findWinners(players);

        //when
        ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(jiwoo);
        double jiwooProfitLoss = profitLossCalculator.calculateProfitLoss(betMoneys, winners);

        ProfitLossCalculator profitLossCalculator2 = new ProfitLossCalculator(soho);
        double sohoProfitLoss = profitLossCalculator2.calculateProfitLoss(betMoneys, winners);

        //then
        Assertions.assertThat(jiwooProfitLoss).isEqualTo(-1 * JIWOO_BET_AMOUNT);
        Assertions.assertThat(sohoProfitLoss).isEqualTo(-1 * SOHO_BET_AMOUNT);
    }

    @Test
    void 일반적으로_플레이어가_이겼을_때() {
        //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.A, CardNumber.EIGHT, CardNumber.TWO);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE);
        Player dealer = createDealerWithCards(CardNumber.FIVE, CardNumber.EIGHT);
        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney(SOHO_BET_AMOUNT));

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));
        Players winners = GameRule.findWinners(players);

        //when
        ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(jiwoo);
        double jiwooProfitLoss = profitLossCalculator.calculateProfitLoss(betMoneys, winners);

        ProfitLossCalculator profitLossCalculator2 = new ProfitLossCalculator(soho);
        double sohoProfitLoss = profitLossCalculator2.calculateProfitLoss(betMoneys, winners);

        //then
        Assertions.assertThat(jiwooProfitLoss).isEqualTo(JIWOO_BET_AMOUNT);
        Assertions.assertThat(sohoProfitLoss).isEqualTo(-1 * SOHO_BET_AMOUNT);
    }

    @Test
    void 아무도_못_이겼을_때() {
         //given
        Player jiwoo = createPlayerWithNameAndCards("jiwoo", CardNumber.QUEEN, CardNumber.JACK, CardNumber.FIVE);
        Player soho = createPlayerWithNameAndCards("soho", CardNumber.EIGHT, CardNumber.FIVE, CardNumber.JACK);
        Player dealer = createDealerWithCards(CardNumber.FIVE, CardNumber.EIGHT, CardNumber.KING);
        betMoneys.put(jiwoo, new BetMoney(JIWOO_BET_AMOUNT));
        betMoneys.put(soho, new BetMoney(SOHO_BET_AMOUNT));

        Players players = new Players(Arrays.asList(jiwoo, soho, dealer));
        Players winners = GameRule.findWinners(players);

        //when
        ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(jiwoo);;
        double jiwooProfitLoss = profitLossCalculator.calculateProfitLoss(betMoneys, winners);

        ProfitLossCalculator profitLossCalculator2 = new ProfitLossCalculator(soho);
        double sohoProfitLoss = profitLossCalculator2.calculateProfitLoss(betMoneys, winners);

        //then
        Assertions.assertThat(jiwooProfitLoss).isEqualTo(-1 * JIWOO_BET_AMOUNT);
        Assertions.assertThat(sohoProfitLoss).isEqualTo(-1 * SOHO_BET_AMOUNT);
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