package blackjack.model;

public class DrawOrder {
    private int drawOrder = 0;

    public void next() {
        drawOrder++;
    }

    public Player nowPlayer(Players players) {
        return players.get(drawOrder);
    }

    public boolean isEnd(int playersSize) {
        return drawOrder == playersSize;
    }
}
