package blackjack.model;

import java.util.ArrayList;

public class GeneralPlayer implements Player {

    private Cards cards = new Cards(new ArrayList<>());

    public GeneralPlayer() {
    }

    public GeneralPlayer(Cards cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getCardsState() {
        return cards.toString();
    }

    @Override
    public int getSumOfCards() {
        return cards.getSum();
    }
}
