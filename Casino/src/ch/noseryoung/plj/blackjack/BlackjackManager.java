package ch.noseryoung.plj.blackjack;

import ch.noseryoung.plj.DatabaseConnection;
import ch.noseryoung.plj.User;

import java.util.Random;
import java.util.Scanner;

public class BlackjackManager {

    Scanner sc = new Scanner(System.in);

    IO_Blackjack io = new IO_Blackjack();
    User user;

    private int valueDealer;
    private int valueCustomer;
    private double betAmount;

    /**
     * Method: starter
     * <p>
     * Function: Calls method depending on return from io.playGame method
     */
    public void starter() {

        int answer = 0;

        io.setUser(user);

        while (answer != 2) {
            if ((answer = io.playGame()) == 1) {
                betAmount = io.betMoney();
                if (customerDrawCard() > 21){
                    break;
                }
                dealerDrawCard();
                compareDealerCustomer();
            }
        }
    }

    /**
     * Method: compareDealerCustomer
     * <p>
     * Function: Compares the card value from the user and dealer
     * and determines who wins
     */
    public void compareDealerCustomer() {
        if (valueCustomer > valueDealer && valueCustomer <= 21) {
            System.out.println("You won this game");
            betAmount *= 2;
            System.out.println("You won: " + betAmount);
            user.setMoney(user.getMoney() + betAmount);
        } else if (valueCustomer < valueDealer && valueDealer <= 21) {
            System.out.println("You lost this game");
            System.out.println("You lost: " + betAmount);
            user.setMoney(user.getMoney() - betAmount);
        } else if (valueCustomer > 21) {
            System.out.println("You lost this game");
            System.out.println("You lost: " + betAmount);
            user.setMoney(user.getMoney() - betAmount);
        } else if (valueDealer > 21) {
            System.out.println("You won this game");
            betAmount *= 2;
            System.out.println("You won: " + betAmount);
            user.setMoney(user.getMoney() + betAmount);
        } else {
            System.out.println("It's a draw");
        }
    }

    /**
     * Method: drawCard
     * <p>
     * Function: Generates a random number in the bound of 13 and adds
     * the value to the dealer or to the user
     *
     * @return value -> Contains value of the card that got drawn
     */
    public int drawCard() {

        Random rand = new Random();
//
        int randomNum = rand.nextInt(14 - 1) + 1;

        int value = randomNum;

        if (value > 10) {
            value = value - (value - 10);
        }

        return value;
    }

    /**
     * Method: startCards
     * <p>
     * Function: Sets the starting values from the user or dealer
     * it also checks if the two cards make a blackjack
     *
     * @return value -> Contains card value that got drawn
     */
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

    /**
     * Method: customerDrawCard
     * <p>
     * Function: Draws card for the user and adds it to his current card value
     *
     * @return valueCustomer -> Contains card value from the customer
     */
    public int customerDrawCard() {

        valueCustomer = startCards();
        String drawCard = "d";

        System.out.println("Your Card Value is: " + valueCustomer);

        while (drawCard.toLowerCase().equals("d")) {
            if (valueCustomer < 21) {
                System.out.println("Do you want do draw another card or leave? (D / L)");
                drawCard = sc.nextLine();
                if (drawCard.toLowerCase().equals("d")) {
                    valueCustomer += drawCard();
                    System.out.println("You got " + valueCustomer);
                    if (valueCustomer == 21)
                        break;
                } else if (drawCard.toLowerCase().equals("l")) {
                    break;
                }
            } else if (valueCustomer > 21) {
                drawCard = "l";
                System.out.println("You lost");
                user.setMoney(user.getMoney() - betAmount);
                break;
            }
        }
        return valueCustomer;
    }

    /**
     * Method: dealerDrawCard
     * <p>
     * Function: Draws card for the dealer and adds it to his current card value
     * it also sets his limit when he is supposed to draw and when not
     *
     * @return valueDealer -> Contains card value from the dealer
     */
    public int dealerDrawCard() {

        valueDealer = startCards();

        System.out.println("Dealer has: " + valueDealer);

        while (valueDealer < 17) {
            if (valueDealer < 17) {
                valueDealer += drawCard();
                System.out.println("The Dealer drew and got: " + valueDealer);
                break;
            } else if (valueDealer == 21) {
                System.out.println("The Dealer got 21, you lost");
                System.out.println("You lost: " + betAmount);
                user.setMoney(user.getMoney() - betAmount);
                break;
            } else if (valueDealer > 21) {
                System.out.println("The Dealer got more than 21, you won");
                betAmount *= 2;
                System.out.println("You won: " + betAmount);
                user.setMoney(user.getMoney() + betAmount);
                break;
            }
        }

        return valueDealer;
    }

    /**
     * Method: blackJack
     *
     * Function: Checks if the card combination is a blackjack
     *
     * @param card1 -> Holds value of Card
     * @param card2 -> Holds value of Card
     */
    public void blackJack(int card1, int card2) {
        if (card1 == 1 && card2 == 10 || card1 == 10 && card2 == 1) {
            betAmount *= 3;
            System.out.println("That's 21 so the game is over");
            user.setMoney(user.getMoney() + betAmount);
        }
    }

    public int getValueDealer() {
        return valueDealer;
    }

    public void setValueDealer(int valueDealer) {
        this.valueDealer = valueDealer;
    }

    public int getValueCustomer() {
        return valueCustomer;
    }

    public void setValueCustomer(int valueCustomer) {
        this.valueCustomer = valueCustomer;
    }

    public void setUser(User user){
        this.user = user;
    }
}