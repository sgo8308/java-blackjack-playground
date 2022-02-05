package blackjack.controller;

import blackjack.model.BlackjackService;
import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.model.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class GeneralPlayerDrawController implements PlayerDrawController {

    Player player;

    public GeneralPlayerDrawController(Player player) {
        this.player = player;
    }

    @Override
    public void drawCards(BlackjackService blackjackService) {
        if (!player.canDrawMore()) {
            blackjackService.moveToNextPlayer();
            return;
        }

        OutputView.printMoreCard(player);
        String answer = InputView.inputAnswer();
        if (answer.equals("y")) {
            Card card = Deck.drawAndRemove();
            player.addCard(card);
            OutputView.printCardsState(player.getCardsState());
            return;
        }

        blackjackService.moveToNextPlayer();
    }
}
