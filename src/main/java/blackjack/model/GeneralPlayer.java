package blackjack.model;

import java.util.ArrayList;

public class GeneralPlayer implements Player {

    private Cards cards = new Cards(new ArrayList<>());

    void addCard(Card card) {
        cards.add(card);
    }

    String getCardsState() {
        return cards.toString();
    }
}
