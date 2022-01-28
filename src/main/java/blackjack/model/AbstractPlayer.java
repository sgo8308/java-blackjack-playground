package blackjack.model;

import java.util.ArrayList;

public class AbstractPlayer implements Player{

    protected Cards cards = new Cards(new ArrayList<>());

    public AbstractPlayer() {
    }

    public AbstractPlayer(Cards cards) {
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
