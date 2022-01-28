package blackjack.model;

public enum CardType {
    DIAMOND("다이아몬드"), HEART("하트"), SPADE("스페이드"), CLOVER("클로버");

    private String koreanName;

    CardType(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}

