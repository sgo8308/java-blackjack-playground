package blackjack.model;

import java.util.Optional;

public class BetMoney {

    private final double amount;
    private final int LOWER_LIMIT = 10000;
    private final int UPPER_LIMIT = 100000;

    public BetMoney(double amount) {
        checkIsInRange(amount);
        this.amount = amount;
    }

    public void checkIsInRange(double amount) {
        Optional<Double> moneyOpt = Optional.ofNullable(amount);
        moneyOpt.filter(x -> x >= LOWER_LIMIT)
                .orElseThrow(() -> new IllegalArgumentException("배팅 금액은 10000원 이상이어야 합니다."));

        moneyOpt.filter(x -> x <= UPPER_LIMIT)
                .orElseThrow(() -> new IllegalArgumentException("배팅 금액은 100000원 이하여야 합니다."));
    }

    public double positiveValue() {
        return amount;
    }

    public double negativeValue() {
        return -amount;
    }
}
