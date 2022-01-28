package blackjack.model;

import java.util.List;
import java.util.stream.Collectors;

public class GameRule {
    private static int BLACKJACK_NUMBER = 21;

    public static List<Player> findLosers(List<Player> players) {
        return players.stream()
                .filter(player -> player.getSumOfCards() > BLACKJACK_NUMBER)
                .collect(Collectors.toList());
    }
}
