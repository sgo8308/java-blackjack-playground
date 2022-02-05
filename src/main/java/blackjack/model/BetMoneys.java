package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class BetMoneys {

    private Map<Player, BetMoney> betMoneys = new HashMap<>();

    public void put(Player player, BetMoney betMoney) {
        betMoneys.put(player, betMoney);
    }

    public double negativeValue(Player player) {
        return betMoneys.get(player).negativeValue();
    }

    public double positiveValue(Player player) {
        return betMoneys.get(player).positiveValue();
    }
}
