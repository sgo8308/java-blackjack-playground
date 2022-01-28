package blackjack.model;

public class Card {

    private final CardType cardType;
    private final CardNumber cardNumber;

    public Card(CardType cardType, CardNumber cardNumber) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
    }

    public CardNumber getNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return cardNumber.getName() + cardType.getKoreanName();
    }
}
