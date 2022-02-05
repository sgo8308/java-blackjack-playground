package blackjack.model;

public class BlackjackService {

    Players players;
    DrawOrder drawOrder;

    public BlackjackService(Players players) {
        this.players = players;
        this.drawOrder = new DrawOrder();
    }

    public void start() {
        players.drawCards();
        players.drawCards();
    }

    public boolean isWinnerExist() {
        return players.findPlayers(player -> player.getSumOfCards() == GameRule.BLACKJACK_NUMBER)
                .size() > 0;
    }

    public boolean isNoMoreCards() {
        return drawOrder.isEnd(players.size());
    }

    public Player nowPlayer() {
        return drawOrder.nowPlayer(players);
    }

    public void moveToNextPlayer() {
        drawOrder.next();
    }

    public String getResultsString() {
        return players.getResultsString();
    }
}
