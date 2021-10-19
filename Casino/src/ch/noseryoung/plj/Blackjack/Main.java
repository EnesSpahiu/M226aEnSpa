package ch.noseryoung.plj.Blackjack;

public class Main {

    public static void main(String[] args) {

        Blackjack bj = new Blackjack();

        bj.costumerDrawCard();
        bj.dealerDrawCard();
        bj.compareDealerCostumer();

    }
}
