package ch.noseryoung.plj.Roulette;

public class RouletteManager {

    IO io = new IO();
    Roulette roulette = new Roulette();

    private String answer;

    public void chooseBet() {
        do {
            String answer = io.choseBet();
            if (answer.toLowerCase().equals("i")) {
                innerBet();
            } else if (answer.toLowerCase().equals("o")) {
                outerBet();
            } else {
                System.exit(1);
            }
        } while (!answer.toLowerCase().equals("i") || !answer.toLowerCase().equals("o"));

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

        do {
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

            if (!answer.toLowerCase().equals("r") || !answer.toLowerCase().equals("b")) {
                System.out.println("Wrong Input");
            }
        } while (!answer.toLowerCase().equals("r") || !answer.toLowerCase().equals("b"));
    }

    public void checkEvenOrOdd() {

        do {
            answer = io.evenOrOdd();

            if (answer.toLowerCase().equals("e")) {
                if (roulette.getWinningNum().getNum() % 2 == 0) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                }
            } else if (answer.toLowerCase().equals("o")) {
                if (roulette.getWinningNum().getNum() % 2 == 1) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                }
            }

            if (!answer.toLowerCase().equals("e") || !answer.toLowerCase().equals("o")) {
                System.out.println("Wrong Input");
            }
        } while (!answer.toLowerCase().equals("e") || !answer.toLowerCase().equals("o"));
    }

    public void checkHalfHalf() {

        do {
            answer = io.halfHalf();

            if (answer.toLowerCase().equals("h")) {
                if (roulette.getWinningNum().getNum() >= 19 && roulette.getWinningNum().getNum() <= 36) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                    break;
                }
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

            if (!answer.toLowerCase().equals("h") || !answer.toLowerCase().equals("l")) {
                System.out.println("Wrong Input");
            }
        } while (!answer.toLowerCase().equals("h") || !answer.toLowerCase().equals("l"));
    }

    public void checkThird() {

        do {
            answer = io.third();

            if (answer.toLowerCase().equals("h")) {
                if (roulette.getWinningNum().getNum() >= 25 && roulette.getWinningNum().getNum() <= 36) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                }
            } else if (answer.toLowerCase().equals("m")) {
                if (roulette.getWinningNum().getNum() >= 13 && roulette.getWinningNum().getNum() <= 24) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                }
            } else if (answer.toLowerCase().equals("l")) {
                if (roulette.getWinningNum().getNum() >= 1 && roulette.getWinningNum().getNum() <= 12) {
                    System.out.println("Congratulations you won");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                } else {
                    System.out.println("You lost this round.");
                    System.out.println("The Winning number is " + roulette.getWinningNum().getColor() + " " + roulette.getWinningNum().getNum());
                }
            }

            if (!answer.toLowerCase().equals("h") || !answer.toLowerCase().equals("m") || !answer.toLowerCase().equals("l")) {
                System.out.println("Wrong Input");
            }
        } while (!answer.toLowerCase().equals("h") || !answer.toLowerCase().equals("m") || !answer.toLowerCase().equals("l"));
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