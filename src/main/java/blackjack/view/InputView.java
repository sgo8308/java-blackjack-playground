package blackjack.view;

import blackjack.model.BetMoney;
import blackjack.model.Dealer;
import blackjack.model.GeneralPlayer;
import blackjack.model.Player;
import blackjack.model.PlayerName;
import blackjack.model.Players;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static Players inputNames() {
        String nameStrings = scanner.nextLine();
        String[] names = nameStrings.split(",");
        List<Player> players = new ArrayList<>();
        for (String name : names) {
            players.add(new GeneralPlayer(new PlayerName(name)));
        }
        players.add(new Dealer());
        return new Players(players);
    }

    public static BetMoney inputBetMoney() {
        return new BetMoney(Double.parseDouble(scanner.nextLine()));
    }

    public static String inputAnswer() {
        return scanner.nextLine();
    }
}
