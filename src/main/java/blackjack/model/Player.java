package blackjack.model;

public interface Player {

    void addCard(Card card);

    String getCardsState();

    String getResult();

    int getSumOfCards();

    boolean canDrawMore();

    boolean isBlackJack();

    String getName();

    String getType();
}
