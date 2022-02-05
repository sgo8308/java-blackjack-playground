package blackjack.model;

public class GeneralPlayer extends AbstractPlayer {

    public GeneralPlayer(PlayerName name) {
        this.name = name;
    }

    public GeneralPlayer(Cards cards) {
        super(cards);
    }

    public GeneralPlayer(PlayerName name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    @Override
    public boolean canDrawMore() {
        return getSumOfCards() < GameRule.BLACKJACK_NUMBER;
    }

    @Override
    public String getType() {
        return "GeneralPlayer";
    }
}
