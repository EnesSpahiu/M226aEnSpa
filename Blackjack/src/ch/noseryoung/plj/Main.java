package ch.noseryoung.plj;

public class Main {

    public static void main(String[] args) {

        Blackjack bj = new Blackjack();

        bj.costumerDrawCard();
        bj.dealerDrawCard();
        bj.compareDealerCostumer();

    }
}
