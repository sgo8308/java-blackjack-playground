package blackjack.model;

public interface Player {

    void addCard(Card card);

    String getCardsState();

    int getSumOfCards();
}
