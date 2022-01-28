package blackjack.model;

public enum CardNumber {
    A(11, "A"), ONE(1, "1"), TWO(2, "2"),
    THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"),
    SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"),
    NINE(9, "9"), JACK(10, "J"), QUEEN(10, "Q"),
    KING(10, "K");

    public static int DIFFERENCE_BETWEEN_BIG_A_AND_SMALL_A = 10;

    private final int value;
    private final String name;

    CardNumber(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
