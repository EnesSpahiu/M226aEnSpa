package ch.noseryoung.plj.blackjack;

import java.util.Random;
import java.util.Scanner;

public class BlackjackManager {

    Scanner sc = new Scanner(System.in);

    IO io = new IO();

    private int valueDealer;
    private int valueCustomer;

    public void starter(){

        int answer = 0;

            while (answer != 2) {
                if ((answer = io.playGame()) == 2)
                    continue;
                io.betMoney();
                customerDrawCard();
                dealerDrawCard();
            }
    }

    public void compareDealerCostumer(){
        if (valueCustomer > valueDealer && valueCustomer <= 21){
            System.out.println("You won");
        } else if (valueCustomer < valueDealer && valueDealer <= 21){
            System.out.println("You lost");
        } else if (valueCustomer > 21){
            System.out.println("You lost");
        } else if (valueDealer > 21){
            System.out.println("You won");
        }else {
            System.out.println("It's a draw");
        }
    }

    public int drawCard(){

        Random rand = new Random();

        boolean isZero = true;
        int randomNum = rand.nextInt(14 - 1) + 1;

        int value = randomNum;

        if (value > 10){
            value = value - (value - 10);
        }

        return value;
    }

    public int startCards() {

        int card = 0;
        int card2 = 0;
        int value = 0;

        card = drawCard();
        card2 = drawCard();
        value = card + card2;

        blackJack(card, card2);

        return value;
    }

    public int customerDrawCard() {

        valueCustomer = startCards();
        char drawCard = ' ';
        float purse = 0;

        System.out.println("Your Card Value is: " + valueCustomer);

        for (int i = 0; i < 100; i++) {

            if (valueCustomer < 21) {
                System.out.println("Do you want do draw another card or leave? (D / L)");
                drawCard = sc.next().charAt(0);
                if (drawCard == 'D' || drawCard == 'd') {
                    valueCustomer += drawCard();
                    System.out.println(valueCustomer);
                } else if (drawCard == 'L' || drawCard == 'l') {
                    break;
                }
            } else if (valueCustomer > 21){
                System.out.println("You lost");
            }
        }
        return valueCustomer;
    }

    public int dealerDrawCard() {

        valueDealer = startCards();

        System.out.println("Dealer has: " + valueDealer);

        while (true) {
            if (valueDealer >= 17) {
                compareDealerCostumer();
                break;
            } else if (valueDealer < 17) {
                valueDealer += drawCard();
                System.out.println("The Dealer drew and got: " + valueDealer);
            } else if (valueDealer == 21) {
                System.out.println("The Dealer got 21, you lost");
                break;
            } else if (valueDealer > 21) {
                System.out.println("The Dealer got more than 21, you won");
            }
        }

        return valueDealer;
    }

    public void blackJack(int card1, int card2){
        if (card1 == 1 && card2 == 10 || card1 == 10 && card2 == 1){
            System.out.println("That's 21 so the game is over");
        }
    }

}