package ch.noseryoung.plj.roulette;

import ch.noseryoung.plj.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class IO_Roulette {

    Scanner sc = new Scanner(System.in);
    User user;

    public int starter() {

        int answer = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Inner Bet");
                drawBox(40, "2. Outer Bet");
                drawBox(40, "3. End Game ");
                answer = sc.nextInt();
                sc.nextLine();
                if (answer >= 1 && answer <= 3)
                    errorOccurred = true;
                errorOccurred = false;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        return answer;
    }

    public int innerBet() {

        int answer = 0;

        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                System.out.println("Which kind of Inner Bet do you want to make: ");
                drawBox(40, "1. Straight Up");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccurred = false;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        return answer;
    }

    public int outerBet() {

        int answer = 0;

        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                System.out.println("Which kind of Outer Bet do you want to make: ");
                drawBox(40, "1. Red/Black");
                drawBox(40, "2. Even/Odd ");
                drawBox(40, "3. 1-18/19-36 ");
                drawBox(40, "4. 1-12/13-24/25-36 ");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccurred = false;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }
        return answer;
    }

    public double getBetAmount() {
        double bet = 0;

        boolean errorOccurred = true;

        while (errorOccurred) {
            try {
                System.out.println("Type in the amount you want to bet");
                bet = sc.nextDouble();
                sc.nextLine();
                if (bet > user.getMoney()){
                    System.out.println("You do not have that amount of money");
                    errorOccurred = true;
                    System.out.println("You have " + user.getMoney());
                }else {
                    errorOccurred = false;
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        return bet;
    }

    public String redOrBlack() {
        drawBox(40, "Red Numbers (Type R)");
        drawBox(40, "Black Numbers (Type B)");
        return sc.nextLine();
    }

    public String evenOrOdd() {
        drawBox(40, "Even Numbers (Type E) ");
        drawBox(40, "Odd Numbers (Type O)");
        return sc.nextLine();
    }

    public String halfHalf() {
        drawBox(40, "Higher Half (Type H)");
        drawBox(40, "Lower Half (Type L) ");
        return sc.nextLine();
    }

    public String third() {
        drawBox(40, "Higher Third (Type H) ");
        drawBox(40, "Middle Third (Type M) ");
        drawBox(40, "Lower Third (Type L)");
        return sc.nextLine();
    }

    public ArrayList<Bet> straightUpBet() {

        String answer = "";
        ArrayList<Bet> betOnNum = new ArrayList<>();
        int num = 0;
        double bet = 0;

        for (int i = 0; i < 6; i++) {

            if (answer.toLowerCase().equals("y"))
                break;

                boolean errorOccurred = true;

                while (errorOccurred){

                    try{
                        System.out.println("How much do you want to bet: ");
                        bet = sc.nextDouble();
                        sc.nextLine();
                        errorOccurred = false;
                    }catch (InputMismatchException e){
                        System.out.println("Wrong Input");
                        sc.nextLine();
                        errorOccurred = true;
                    }

                    try {
                        System.out.println("Which number do you want to pick (Max 6 -> between 0 and 36): ");
                        num = sc.nextInt();
                        sc.nextLine();
                        errorOccurred = false;
                    }catch (InputMismatchException e){
                        System.out.println("Wrong Input");
                        sc.nextLine();
                        errorOccurred = true;
                    }

                if (num > 36 || num < 0) {
                    System.out.println("Wrong Input");
                    errorOccurred = true;
                }
            }

            betOnNum.add(new Bet(num, bet));

                answer = "y";

            while (!answer.toLowerCase().equals("n") && answer.toLowerCase().equals("y")) {
                System.out.println("Do you want to stop picking numbers? (Y/N) ");
                answer = sc.nextLine();

                if (answer.toLowerCase().equals("y")){
                    break;
                } else if (answer.toLowerCase().equals("n")){
                    continue;
                } else {
                    System.out.println("Wrong Input");
                }

            }
        }
        return betOnNum;
    }

    /**
     * Method: drawBox
     *
     * Function: Prints out a box around the output so it looks a little better
     *
     * @param length -> Determines how big the box is gonna be
     * @param singleWord -> The Word that is going to get printed out
     */
    public static void drawBox(int length, String singleWord){

        if (singleWord.length() > length){
            length = singleWord.length();
        }

        if (length % 2 != 0){
            length--;
        }

        System.out.print("\u2554");

        for (int i = 0; i < length; i++) {
            System.out.print("\u2550");
        }

        System.out.print("\u2557\n");
        System.out.print("\u2551");

        for (int j = 0; j < (length - singleWord.length()) / 2; j++) {
            System.out.print(" ");
        }

        System.out.print("" + singleWord);

        for (int j = 0; j < (length - singleWord.length()) / 2; j++) {
            System.out.print(" ");
        }

        System.out.print("\u2551\n");
        System.out.print("\u255A");

        for (int i = 0; i < length; i++) {
            System.out.print("\u2550");
        }
        System.out.print("\u255D\n");
    }

    public void setUser(User user){
        this.user = user;
    }
}