package blackjack.controller;

import blackjack.model.BlackjackService;
import blackjack.model.Card;
import blackjack.model.Deck;
import blackjack.model.Player;
import blackjack.view.OutputView;

public class DealerDrawController implements PlayerDrawController {

    Player dealer;

    public DealerDrawController(Player dealer) {
        this.dealer = dealer;
    }

    @Override
    public void drawCards(BlackjackService blackjackService) {
        if (dealer.canDrawMore()) {
            OutputView.printDealerDraw();
            Card card = Deck.drawAndRemove();
            dealer.addCard(card);
            return;
        }

        blackjackService.moveToNextPlayer();
    }
}
