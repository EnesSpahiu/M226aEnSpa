package ch.noseryoung.plj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    Scanner sc = new Scanner(System.in);

    public int startCasino() {

        int answer = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Roulette ");
                drawBox(40, "2. Blackjack");
                drawBox(40, "3. Slots");
                drawBox(40, "4. End Game ");
                answer = sc.nextInt();
                errorOccurred = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        return answer;
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