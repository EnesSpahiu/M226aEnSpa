package ch.noseryoung.plj.Roulette;

import ch.noseryoung.plj.Roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IO {

    Roulette roulette = new Roulette();

    Scanner sc = new Scanner(System.in);

    public String choseBet() {
        System.out.println("Do you want to make an Inner bet, Outer Bet or insert Money (I/O): ");
        return sc.nextLine();
    }

    public int innerBet() {

        int answer = 0;

        System.out.println("Which kind of Inner Bet do you want to make: ");
        System.out.println("1. Straight-Up");
        answer = sc.nextInt();

        return answer;
    }

    public int outerBet() {

        int answer = 0;

        System.out.println("Which kind of Outer Bet do you want to make: ");
        System.out.println("1. Red/Black");
        System.out.println("2. Even/Odd");
        System.out.println("3. 1-18/19-36");
        System.out.println("4. 1-12/13-24/25-36");
        answer = sc.nextInt();
        sc.nextLine();
        return answer;
    }

    public String redOrBlack() {
        System.out.println("Do you want to bet on Red or Black (R/B): ");
        return sc.nextLine();
    }

    public String evenOrOdd() {
        System.out.println("Do you want to bet on Even or Odd (E/O): ");
        return sc.nextLine();
    }

    public String halfHalf() {
        System.out.println("Do you want to bet on the Higher or Lower Half (H/L): ");
        return sc.nextLine();
    }

    public String third() {
        System.out.println("Do you want to bet on the Higher, Middle or Lower third (H/M/L): ");
        return sc.nextLine();
    }

    public ArrayList<Integer> straightUpBet() {

        String answer = "";
        ArrayList<Integer> nums = new ArrayList();
        int num = 0;

        for (int i = 0; i < 6; i++) {

            if (answer.toLowerCase().equals("y"))
                break;

            do {
                System.out.println("Which number do you want to pick (Max 6): ");
                num = sc.nextInt();
                sc.nextLine();

                if (num > 36 || num < 0) {
                    System.out.println("Wrong Input");
                }
            } while (num > 36 || num < 0);

            nums.add(num);

            do {
                System.out.println("Do you want to stop picking numbers? ");
                answer = sc.nextLine();

                if (answer.toLowerCase().equals("y")){
                    break;
                } else {
                    System.out.println("Wrong Input");
                }

            } while (answer.toLowerCase().equals("n"));
        }
        return nums;
    }

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
}