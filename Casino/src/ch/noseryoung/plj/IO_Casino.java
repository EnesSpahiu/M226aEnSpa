package ch.noseryoung.plj;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class: IO_Casino
 *
 * Function: Handles the Output from the casino and Input from the user
 */
public class IO_Casino {

    Scanner sc = new Scanner(System.in);

    /**
     * Method: startCasino
     *
     * Function: Prints out the options of the user and gets his input while
     * trying to catch an InputMismatchException so the user can not type in
     * false inputs.
     *
     * @return answer -> Contains the answer which game the user wants to play
     */
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
                sc.nextLine();
                errorOccurred = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }
        return answer;
    }

    /**
     * Method: userOptions
     *
     * Function: Prints out options of user and gets his input while
     * trying to catch an InputMismatchException so the user can not type in
     * false inputs.
     *
     * @return answer -> Contains the answer which option the user chooses
     */
    public int userOptions() {
        int answer = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Sign Up");
                drawBox(40, "2. Login");
                drawBox(40, "3. Delete Account ");
                drawBox(40, "4. End Game ");
                answer = sc.nextInt();
                sc.nextLine();
                errorOccurred = false;
            }catch (InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }
        return answer;
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
}