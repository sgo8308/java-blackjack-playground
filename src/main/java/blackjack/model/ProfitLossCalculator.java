package blackjack.model;

public class ProfitLossCalculator {

    private Player player;
    private final double NO_PROFIT_NO_LOSS_VALUE = 0;
    private final double FIRST_TIME_BLACKJACK_BONUS_RATIO = 1.5d;

    public ProfitLossCalculator(Player player) {
        this.player = player;
    }

    public double calculateProfitLoss(BetMoneys betMoneys, Players winners) {
        if (dealerWinAndPlayerWin(winners)) {
            return NO_PROFIT_NO_LOSS_VALUE;
        }
        if (dealerWindAndPlayerLose(winners)) {
            return betMoneys.negativeValue(player);
        }

        if (dealerLoseAndPlayerBlackJack(winners)) {
            return betMoneys.positiveValue(player) * FIRST_TIME_BLACKJACK_BONUS_RATIO;
        }

        if(dealerLoseAndPlayerWin(winners)) {
            return betMoneys.positiveValue(player);
        }

        return betMoneys.negativeValue(player);
    }

    private boolean dealerLoseAndPlayerWin(Players winners) {
        return isPlayerWin(winners) && !GameRule.isDealerWin(winners);
    }

    private boolean dealerLoseAndPlayerBlackJack(Players winners) {
        return isPlayerWin(winners) && player.isBlackJack();
    }

    private boolean dealerWindAndPlayerLose(Players winners) {
        return GameRule.isDealerWin(winners) && !isPlayerWin(winners);
    }

    private boolean dealerWinAndPlayerWin(Players winners) {
        return GameRule.isDealerWin(winners) && isPlayerWin(winners);
    }

    private boolean isPlayerWin(Players winners) {
        return winners.contains(player);
    }
}

