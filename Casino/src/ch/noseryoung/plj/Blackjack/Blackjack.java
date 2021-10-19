package ch.noseryoung.plj.Blackjack;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    Scanner sc = new Scanner(System.in);

    private int valueCustomer;
    private int valueDealer;

    public void compareDealerCostumer(){

        if (valueCustomer > valueDealer && valueCustomer <= 21){
            System.out.println("You won");
            System.exit(1);
        } else if (valueCustomer < valueDealer && valueDealer <= 21){
            System.out.println("You lost");
            System.exit(1);
        } else if (valueCustomer > 21){

            System.out.println("You lost");

        } else if (valueDealer > 21){

            System.out.println("You win");

        }else {
            System.out.println("It's a draw");
            System.exit(1);
        }

        System.exit(1);

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

    public int startGame() {

        int card = 0;
        int card2 = 0;
        int value = 0;

        card = drawCard();
        card2 = drawCard();
        value = card + card2;

        blackJack(card, card2);

        return value;
    }

    public int costumerDrawCard() {

        valueCustomer = startGame();
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
                System.exit(1);
            }
        }
        return valueCustomer;
    }

    public int dealerDrawCard() {

        valueDealer = startGame();

        System.out.println("Dealer has: " + valueDealer);

        for (int i = 0; i < 100; i++) {
            if (valueDealer >= 17) {
                System.out.println("The Dealer got: " + valueDealer);
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
                System.exit(1);
            }
        }

        return valueDealer;
    }

    public void blackJack(int card1, int card2){


        if (card1 == 1 && card2 == 10 || card1 == 10 && card2 == 1){

            System.out.println("That's 21 so the game is over");
            System.exit(1);

        }

    }

}