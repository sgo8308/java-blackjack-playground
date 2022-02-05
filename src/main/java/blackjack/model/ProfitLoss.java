package blackjack.model;

public class ProfitLoss {

    private double profitLoss;

    public void add(double amount) {
        profitLoss += amount;
    }

    public double getValue() {
        return profitLoss;
    }
}
