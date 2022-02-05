package blackjack.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Players findDealer() {
        return new Players(players.stream()
                .filter(player -> player instanceof Dealer)
                .collect(Collectors.toList()));
    }

    public Players findPlayersAlive() {
        return findPlayers(player -> player.getSumOfCards() <= 21);
    }

    public Players findPlayers(Predicate<Player> condition) {
        return new Players(players.stream().filter(condition).collect(Collectors.toList()));
    }

    public int findCardsSumMax() {
        return players.stream().mapToInt(player -> player.getSumOfCards()).max().getAsInt();
    }

    public int size() {
        return players.size();
    }

    public void drawCards() {
        for (Player player : players) {
            Card card = Deck.drawAndRemove();
            player.addCard(card);
        }
    }

    public Map<Player, Double> calculateProfitLoss(BetMoneys betMoneys) {
        Map<Player, Double> profitLosses = getGeneralPlayersProfitLosses(betMoneys);
        profitLosses.put(players.get(players.size() - 1), getDealerProfitLoss(profitLosses));
        return profitLosses;
    }

    private Map<Player, Double> getGeneralPlayersProfitLosses(BetMoneys betMoneys) {
        Map<Player, Double> profitLosses = new HashMap<>();
        for (int i = 0; i < players.size() - 1; i++) {
            ProfitLossCalculator profitLossCalculator = new ProfitLossCalculator(players.get(i));
            double profitLoss = profitLossCalculator.calculateProfitLoss(betMoneys,
                    GameRule.findWinners(this));
            profitLosses.put(players.get(i), profitLoss);
        }
        return profitLosses;
    }

    private double getDealerProfitLoss(Map<Player, Double> profitLosses) {
        return -1 * profitLosses.values().stream().mapToDouble(x -> x).sum();
    }

    public Player get(int index) {
        return players.get(index);
    }

    public String getCardStates() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(player.getCardsState() + "\n");
        }
        return stringBuilder.toString();
    }

    public String getResultsString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder.append(player.getResult() + "\n");
        }
        return stringBuilder.toString();
    }



    public boolean contains(Player player) {
        return players.contains(player);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
