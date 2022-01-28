package blackjack.model;

import java.util.List;

public class Cards {

    List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public int getSum() {
        int sumBeforeHandleA = cards.stream()
                .map(card -> card.getNumber())
                .mapToInt(CardNumber::getValue)
                .sum();

        return getSumAfterHandleA(sumBeforeHandleA);
    }

    private int getSumAfterHandleA(int sum) {
        long cardACount = countCardA();
        while (cardACount-- > 0 && sum > 21) {
            sum -= CardNumber.DIFFERENCE_BETWEEN_BIG_A_AND_SMALL_A;
        }
        return sum;
    }

    private long countCardA() {
        return cards.stream()
                .map(card -> card.getNumber())
                .filter(cardNumber -> cardNumber.equals(CardNumber.A))
                .count();
    }

    public void add(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        String string = cards.stream().map(card -> card.toString() + ", ").reduce("", String::concat);
        return string.substring(0, string.length() - 2);
    }
}
