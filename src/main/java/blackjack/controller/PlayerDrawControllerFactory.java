package blackjack.controller;

import blackjack.model.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PlayerDrawControllerFactory {

    public static Map<String, Function<Player, PlayerDrawController>> controllers = new HashMap<>();

    static{
        controllers.put("GeneralPlayer", player -> new GeneralPlayerDrawController(player));
        controllers.put("Dealer", player -> new DealerDrawController(player));
    }

    public static PlayerDrawController create(Player player) {
        return controllers.get(player.getType()).apply(player);
    }
}
