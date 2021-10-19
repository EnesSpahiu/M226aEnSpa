package ch.noseryoung.plj.roulette;

import ch.noseryoung.plj.roulette.Color;
import ch.noseryoung.plj.roulette.IO;
import ch.noseryoung.plj.roulette.Roulette;

public class RouletteManager {

    IO io = new IO();
    Roulette roulette = new Roulette();

    public void chooseBet() {

        int answer = 0;

        while (true) {
            answer = io.choseBet();
            if (answer == 1) {
                innerBet();
            } else if (answer == 2) {
                outerBet();
            }else if (answer == 3){
                break;
            }
        }

    }

    public void innerBet() {
        int bet = io.innerBet();

        switch (bet) {
            case 1 -> checkStraightUp();
        }
    }

    public void outerBet() {

        int outerBet = io.outerBet();

        switch (outerBet) {
            case 1 -> checkRedOrBlack();

            case 2 -> checkEvenOrOdd();

            case 3 -> checkHalfHalf();

            case 4 -> checkThird();
        }
    }

    public void checkRedOrBlack() {

        String answer = " ";

        while (true){
            answer = io.redOrBlack();

            if (answer.toLowerCase().equals("r")) {
                if (roulette.getWinningNum().getColor().equals(Color.RED)) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                }
            } else if (answer.toLowerCase().equals("b")) {
                if (roulette.getWinningNum().getColor().equals(Color.BLACK)) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                }
            }

            System.out.println("Wrong Input");
        }
    }

    public void checkEvenOrOdd() {

        String answer = " ";

        while (true){
            answer = io.evenOrOdd();

            if (answer.toLowerCase().equals("e")) {
                if (roulette.getWinningNum().getNum() % 2 == 0) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                }
            } else if (answer.toLowerCase().equals("o")) {
                if (roulette.getWinningNum().getNum() % 2 == 1) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                }
            }

                System.out.println("Wrong Input");
        }
    }

    public void checkHalfHalf() {

        String answer = " ";

        while (true) {
            answer = io.halfHalf();

            if (answer.toLowerCase().equals("h")) {
                if (roulette.getWinningNum().getNum() >= 19 && roulette.getWinningNum().getNum() <= 36) {
                    System.out.println("Congratulations you won");
                } else {
                    System.out.println("You lost this round.");
                }
                System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                break;
            } else if (answer.toLowerCase().equals("l")) {
                if (roulette.getWinningNum().getNum() >= 1 && roulette.getWinningNum().getNum() <= 18) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                }
            }

                System.out.println("Wrong Input");
        }
    }

    public void checkThird() {

        String answer = " ";

        while (true) {
            answer = io.third();

            switch (answer.toLowerCase()) {
                case "h":
                    if (roulette.getWinningNum().getNum() >= 25 && roulette.getWinningNum().getNum() <= 36) {
                        System.out.println("Congratulations you won");
                        System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                        break;
                    } else {
                        System.out.println("You lost this round.");
                        System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                        break;
                    }
                case "m":
                    if (roulette.getWinningNum().getNum() >= 13 && roulette.getWinningNum().getNum() <= 24) {
                        System.out.println("Congratulations you won");
                        System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                        break;
                    } else {
                        System.out.println("You lost this round.");
                        System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                        break;
                    }
                case "l":
                    if (roulette.getWinningNum().getNum() >= 1 && roulette.getWinningNum().getNum() <= 12) {
                        System.out.println("Congratulations you won");
                        System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                        break;
                    } else {
                        System.out.println("You lost this round.");
                        System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                        break;
                    }
            }

                System.out.println("Wrong Input");
        }
    }

    public void checkStraightUp() {

        boolean hasRightNum = false;
        int[] falseNums = new int[6];
        Integer[] nums = io.straightUpBet().toArray(new Integer[0]);

        for (int i = 0; i < nums.length; i++) {
            if (roulette.getWinningNum().getNum() == nums[i]) {
                hasRightNum = true;
            } else if (roulette.getWinningNum().getNum() != nums[i]) {
                System.out.println("The Number: " + nums[i] + " was not correct");
                falseNums[i] = nums[i];
            }

            if (hasRightNum) {
                System.out.println("Congratulations you won");
                System.out.println("The Winning number is " + roulette.getWinningNum().getNum());
            } else {
                System.out.println("You lost this round.");
                System.out.println("The Winning number is " + roulette.getWinningNum().getNum());
            }
        }
    }
}