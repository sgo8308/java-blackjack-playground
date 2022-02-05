package blackjack.model;

public class GameRule {

    public static int BLACKJACK_NUMBER = 21;

    private GameRule() {
    }

    public static Players findLosers(Players players) {
        return players.findPlayers(player -> player.getSumOfCards() > BLACKJACK_NUMBER);
    }

    public static Players findWinners(Players players) {
        if (isWinnerExist(players)) {
            Players playersAlive = players.findPlayersAlive();
            int cardsSumMax = playersAlive.findCardsSumMax();
            return playersAlive.findPlayers(player -> player.getSumOfCards() == cardsSumMax);
        }

        return players.findDealer();
    }

    private static boolean isWinnerExist(Players players) {
        return players.findPlayers(player -> player.getSumOfCards() <= 21).size() != 0;
    }

    public static boolean isDealerWin(Players winners) {
        return winners.findPlayers(Dealer.class::isInstance).size() != 0;
    }
}
