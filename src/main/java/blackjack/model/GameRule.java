package blackjack.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameRule {

    private static int BLACKJACK_NUMBER = 21;

    public static List<Player> findLosers(List<Player> players) {
        return findPlayers(players, player -> player.getSumOfCards() > BLACKJACK_NUMBER);
    }

    public static List<Player> findWinners(List<Player> players) {
        if (isWinnerExist(players)) {
            List<Player> playersAlive = findPlayersAlive(players);
            int cardsSumMax = findCardsSumMax(playersAlive);
            return findPlayers(playersAlive, player -> player.getSumOfCards() == cardsSumMax);
        }

        return findDealer(players);
    }

    private static List<Player> findDealer(List<Player> players) {
        return players.stream()
                .filter(player -> player instanceof Dealer)
                .collect(Collectors.toList());
    }

    private static boolean isWinnerExist(List<Player> players) {
        return findPlayers(players, player -> player.getSumOfCards() <= 21).size() != 0;
    }

    private static List<Player> findPlayersAlive(List<Player> players) {
        return findPlayers(players, player -> player.getSumOfCards() <= 21);
    }

    private static int findCardsSumMax(List<Player> playersAlive) {
        return playersAlive.stream().mapToInt(player -> player.getSumOfCards()).max().getAsInt();
    }

    private static List<Player> findPlayers(List<Player> players, Predicate<Player> condition) {
        return players.stream().filter(condition).collect(Collectors.toList());
    }
}
