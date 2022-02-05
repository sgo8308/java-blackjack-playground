package blackjack.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerNameTest {
    @Test
    void 플레이어_이름이_5자가_넘으면_예외_던지기() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new PlayerName("fellojavasdfs");
        }).withMessage("이름은 10자를 초과하면 안됩니다.");
    }
}

