package blackjack.model;

import java.util.ArrayList;

public abstract class AbstractPlayer implements Player{

    protected Cards cards = new Cards(new ArrayList<>());
    protected PlayerName name;

    @Override
    public abstract boolean canDrawMore();

    public AbstractPlayer() {
    }

    public AbstractPlayer(Cards cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public String getCardsState() {
        return getName() + " 카드: " + cards.toString();
    }

    @Override
    public int getSumOfCards() {
        return cards.getSum();
    }

    @Override
    public boolean isBlackJack() {
        return cards.getSum() == GameRule.BLACKJACK_NUMBER && cards.isSize(2);
    }

    @Override
    public String getName() {
        return name.getName();
    }

    @Override
    public String getResult() {
        return getName() + " 카드: " + cards.getCardResult();
    }
}
