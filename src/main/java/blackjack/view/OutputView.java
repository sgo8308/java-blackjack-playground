package blackjack.view;

import blackjack.model.Player;
import java.util.Stack;

public class OutputView {

    public static void printNameInput() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public static void printBetMoneyQuestion(Player player) {
        System.out.println(player.getName() + "의 배팅 금액은?");
    }

    public static void printCardStates(String cardStates) {
        System.out.println(cardStates);
    }

    public static void printMoreCard(Player nowPlayer) {
        System.out.println(nowPlayer.getName() +  "는 카드를 더 받으시겠습니까?");

    }

    public static void printCardsState(String cardsState) {
        System.out.println(cardsState   );
    }

    public static void printDealerDraw() {
        System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public static void printResults(String resultsString) {
        System.out.println(resultsString);
    }

    public static void printProfitAndLoss(String profitAndLossString) {
        System.out.println("##최종 수익");
        System.out.println(profitAndLossString);
    }
}
