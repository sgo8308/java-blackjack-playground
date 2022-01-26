package blackjack.model;

public enum CardNumber {
    A(11), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), JACK(10), QUEEN(10), KING(10);

    public static int DIFFERENCE_BETWEEN_BIG_A_AND_SMALL_A = 10;

    private final int value;

    CardNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
