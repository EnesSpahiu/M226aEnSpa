package ch.noseryoung.plj.roulette;

import ch.noseryoung.plj.DatabaseConnection;
import ch.noseryoung.plj.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class: RouletteManager
 * <p>
 * Function: Manages the return values from the IO_Roulette class
 */
public class RouletteManager {

    IO_Roulette io = new IO_Roulette();
    Roulette roulette = new Roulette();
    User user;

    /**
     * Method starter
     * <p>
     * Function: Calls method depending on return from io.startCasino method
     */
    public void starter() {

        int answer = 1;

        io.setUser(user);

        while (answer >= 1 && answer <= 3) {
            roulette.setWinningNum(roulette.getNums().get(ThreadLocalRandom.current().nextInt(0, 36 + 1)));
            answer = io.starter();
            if (answer == 1) {
                innerBet();
            } else if (answer == 2) {
                outerBet();
            } else if (answer == 3) {
                break;
            }
        }

    }

    /**
     * Method: innerBet
     * <p>
     * Function: Calls a method depending on return from io.innerBet
     */
    public void innerBet() {
        int bet = io.innerBet();

        switch (bet) {
            case 1 -> checkStraightUp();
        }
    }

    /**
     * Method: outerBet
     * <p>
     * Function: Calls a method depending on return from io.outerBet
     */
    public void outerBet() {

        int outerBet = io.outerBet();

        switch (outerBet) {
            case 1 -> checkRedOrBlack();

            case 2 -> checkEvenOrOdd();

            case 3 -> checkHalfHalf();

            case 4 -> checkThird();
        }
    }

    /**
     * Method: checkRedOrBlack
     * <p>
     * Function: If the user chose this bet it is going to be checked here
     * if the user guesses the color right he wins otherwise he loses
     */
    public void checkRedOrBlack() {

        String answer = "r";
        double betAmount = io.getBetAmount();
        double wonAmount = 0;

        while (answer.toLowerCase().equals("r") || answer.toLowerCase().equals("b")) {
            answer = io.redOrBlack();

            if (answer.toLowerCase().equals("r")) {
                if (roulette.getWinningNum().getColor().equals(Color.RED)) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 2;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            } else if (answer.toLowerCase().equals("b")) {
                if (roulette.getWinningNum().getColor().equals(Color.BLACK)) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 2;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            }

            System.out.println("Wrong Input");
        }
    }

    /**
     * Method: checkEvenOrOdd
     * <p>
     * Function: If the user chose this bet it is going to be checked here
     * if the user chose right if it is even or odd he wins otherwise he loses
     */
    public void checkEvenOrOdd() {

        String answer = "e";
        double betAmount = io.getBetAmount();
        double wonAmount = 0;

        while (answer.toLowerCase().equals("e") || answer.toLowerCase().equals("o")) {
            answer = io.evenOrOdd();

            if (answer.toLowerCase().equals("e")) {
                if (roulette.getWinningNum().getNum() % 2 == 0) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 2;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            } else if (answer.toLowerCase().equals("o")) {
                if (roulette.getWinningNum().getNum() % 2 == 1) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 2;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            }

            System.out.println("Wrong Input");
        }
    }

    /**
     * Method: checkHalfHalf
     * <p>
     * Function: If the user chose this bet it is going to be checked here
     * if the winning number is in the half the user chose he wins otherwise he loses
     */
    public void checkHalfHalf() {

        String answer = "h";
        double betAmount = io.getBetAmount();
        double wonAmount = 0;

        while (answer.toLowerCase().equals("h") || answer.toLowerCase().equals("l")) {
            answer = io.halfHalf();

            if (answer.toLowerCase().equals("h")) {
                if (roulette.getWinningNum().getNum() >= 19 && roulette.getWinningNum().getNum() <= 36) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 2;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            } else if (answer.toLowerCase().equals("l")) {
                if (roulette.getWinningNum().getNum() >= 1 && roulette.getWinningNum().getNum() <= 18) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 2;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            }

            System.out.println("Wrong Input");
        }
    }

    /**
     * Method: checkThird
     * <p>
     * Function: If the user chose this bet it is going to be checked here
     * if the winning number is in the third he chose the user wins otherwise he loses
     */
    public void checkThird() {

        String answer = "h";
        double betAmount = io.getBetAmount();
        double wonAmount = 0;

        while (answer.toLowerCase().equals("h") || answer.toLowerCase().equals("m") || answer.toLowerCase().equals("l")) {
            answer = io.third();

            if (answer.toLowerCase().equals("h")) {
                if (roulette.getWinningNum().getNum() >= 25 && roulette.getWinningNum().getNum() <= 36) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 3;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }

                break;
            }
            if (answer.toLowerCase().equals("m")) {
                if (roulette.getWinningNum().getNum() >= 13 && roulette.getWinningNum().getNum() <= 24) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 3;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            }
            if (answer.toLowerCase().equals("l")) {
                if (roulette.getWinningNum().getNum() >= 1 && roulette.getWinningNum().getNum() <= 12) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    wonAmount = betAmount * 3;
                    System.out.println("You won: " + wonAmount);
                    user.setMoney(user.getMoney() + wonAmount);
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    System.out.println("You lost: " + betAmount);
                    user.setMoney(user.getMoney() - betAmount);
                }
                break;
            }
            System.out.println("Wrong Input");
            break;
        }
    }

    /**
     * Method: checkStraightUp
     * <p>
     * Function: If the user chose this bet it is going to be checked here
     * if the number he chose is the winning number he wins otherwise he loses
     */
    public void checkStraightUp() {

        boolean hasRightNum = false;
        int[] falseNums = new int[6];
        ArrayList<Bet> bettedNums = io.straightUpBet();
        double allAmount = 0;
        double lostAmount = 0;
        double wonAmount = 0;

        for (int i = 0; i < bettedNums.size(); i++) {
            allAmount += bettedNums.get(i).getBet();
        }

        for (int i = 0; i < bettedNums.size(); i++) {
            if (roulette.getWinningNum().getNum() == bettedNums.get(i).getNum()) {
                hasRightNum = true;
                wonAmount = bettedNums.get(i).getBet() * 37;
            } else if (roulette.getWinningNum().getNum() != bettedNums.get(i).getNum()) {
                System.out.println("The Number: " + bettedNums.get(i).getNum() + " was not correct");
                falseNums[i] = bettedNums.get(i).getNum();
                lostAmount += bettedNums.get(i).getBet();
            }
        }

        if (hasRightNum) {
            System.out.println("Congratulations you won");
            System.out.println("The Winning number is " + roulette.getWinningNum().getNum());
            System.out.println("You won: " + wonAmount);
            System.out.println("You betted: " + allAmount);
            user.setMoney(user.getMoney() + wonAmount);
            if (lostAmount > 0) {
                System.out.println("For all bets you lost: " + lostAmount);
                user.setMoney(user.getMoney() - lostAmount);
            }
        } else {
            System.out.println("You lost this round.");
            System.out.println("The Winning number is " + roulette.getWinningNum().getNum());
            System.out.println("You lost: " + lostAmount);
            System.out.println("You betted: " + allAmount);
            user.setMoney(user.getMoney() - lostAmount);
        }


    }

    public void setUser(User user){
        this.user = user;
    }
}