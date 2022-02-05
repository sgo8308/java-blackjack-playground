package blackjack.controller;

import blackjack.model.BetMoneys;
import blackjack.model.BlackjackService;
import blackjack.model.Player;
import blackjack.model.Players;
import blackjack.model.ProfitLosses;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {

    public static void main(String[] args) {
        Players players = createPlayers();
        BetMoneys betMoneys = new BetMoneys();
        betMoneys(players, betMoneys);
        BlackjackService blackjackService = new BlackjackService(players);

        gameProgressStep(players, blackjackService);

        gameResultsStep(players, blackjackService, betMoneys);
    }

    private static Players createPlayers() {
        OutputView.printNameInput();
        Players players = InputView.inputNames();
        return players;
    }

    private static void betMoneys(Players players, BetMoneys betMoneys) {
        for (int i = 0; i < players.size() - 1; i++) {
            Player player = players.get(i);
            OutputView.printBetMoneyQuestion(player);
            betMoneys.put(player, InputView.inputBetMoney());
        }
    }
    private static void gameProgressStep(Players players, BlackjackService blackjackService) {
        blackjackService.start();
        if (blackjackService.isWinnerExist()) {
            return;
        }

        OutputView.printCardStates(players.getCardStates());
        drawMoreCards(blackjackService);
    }

    private static void drawMoreCards(BlackjackService blackjackService) {
        while (!blackjackService.isNoMoreCards()) {
            Player nowPlayer = blackjackService.nowPlayer();
            PlayerDrawController playerController = PlayerDrawControllerFactory.create(nowPlayer);
            playerController.drawCards(blackjackService);
        }
    }

    private static void gameResultsStep(Players players, BlackjackService blackjackService, BetMoneys betMoneys) {
        OutputView.printResults(blackjackService.getResultsString());
        ProfitLosses profitLosses = new ProfitLosses();
        profitLosses.update(betMoneys, players);
        OutputView.printProfitAndLoss(profitLosses.toString());
    }
}
