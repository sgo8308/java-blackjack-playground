package blackjack.model;

public class Dealer extends AbstractPlayer {

    private final int MORE_CARD_STANDARD = 16;

    public Dealer() {
        super();
        name = new PlayerName("Dealer");
    }

    public Dealer(Cards cards) {
        super(cards);
        name = new PlayerName("Dealer");
    }

    @Override
    public boolean canDrawMore() {
        return getSumOfCards() <= MORE_CARD_STANDARD;
    }

    @Override
    public String getType() {
        return "Dealer";
    }
}
