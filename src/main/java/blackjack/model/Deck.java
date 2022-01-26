package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private static final List<Card> cards = new ArrayList<>();

    static{
        for (CardType cardType : CardType.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
                cards.add(new Card(cardType, cardNumber));
            }
        }
    }

    public static Card drawAndRemoveCardFromDeck() {
        int randomIndex = getRandomIndex();
        Card card = cards.get(randomIndex);
        cards.remove(randomIndex);
        return card;
    }

    public static boolean isSize(int size) {
        return cards.size() == size;
    }

    private static int getRandomIndex() {
        Random random = new Random();
        return random.nextInt(52);
    }
}
