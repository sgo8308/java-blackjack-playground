package blackjack.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BetMoneyTest {

    @Test
    void 돈이_최소_배팅금액보다_작으면_예외를_던진다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new BetMoney(1000);
                }).withMessage("배팅 금액은 10000원 이상이어야 합니다.");
    }

    @Test
    void 돈이_최대_배팅금액보다_크면_예외를_던진다() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new BetMoney(100001);
                }).withMessage("배팅 금액은 100000원 이하여야 합니다.");
    }
}