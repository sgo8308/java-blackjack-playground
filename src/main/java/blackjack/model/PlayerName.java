package blackjack.model;

import java.util.Optional;

public class PlayerName {

    private static final int LENGTH_LIMIT = 10;
    private final String name;

    public PlayerName(String name) {
        validUnderLengthLimit(name);
        this.name = name;
    }

    private void validUnderLengthLimit(String name) {
        Optional<String> nameOpt = Optional.ofNullable(name);
        nameOpt.filter(s -> s.length() <= LENGTH_LIMIT)
                .orElseThrow(() -> new IllegalArgumentException("이름은 10자를 초과하면 안됩니다."));
    }

    public String getName() {
        return name;
    }
}
