package blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class ProfitLosses {

    private Map<Player, ProfitLoss> profitLosses = new HashMap<>();

    public void update(BetMoneys betMoneys, Players players) {
        Map<Player, Double> profitLossThisTurn = players.calculateProfitLoss(betMoneys);
        for (Player player : profitLossThisTurn.keySet()) {
            ProfitLoss profitLoss = profitLosses.getOrDefault(player, new ProfitLoss());
            profitLoss.add(profitLossThisTurn.get(player));
            profitLosses.put(player, profitLoss);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Player player : profitLosses.keySet()) {
            sb.append(player.getName()).append(": ").append((int)profitLosses.get(player).getValue()).append("\n");
        }
        return sb.toString();
    }
}
