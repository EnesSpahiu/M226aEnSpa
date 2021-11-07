package ch.noseryoung.plj.slots;

import ch.noseryoung.plj.User;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class: IO_Slots
 *
 * Function: Handles the Output from the slots and Input from the user
 */
public class IO_Slots {

    Scanner sc = new Scanner(System.in);
    User user = new User();

    /**
     * Method: chooseAmount
     *
     * Function: Ask the user how much money he wants to bet and return it
     *
     * @return money -> Returns the amount of money the user is going to bet
     */
    public double chooseAmount() {

        double money = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                System.out.println("Type in the amount you want to bet: ");
                money = sc.nextDouble();
                sc.nextLine();
                if (money >= user.getMoney()){
                    System.out.println("You do not have that amount of money");
                    errorOccurred = true;
                }
                errorOccurred = false;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        return money;
    }

    /**
     * Method: spinAnswer
     *
     * Function: Prints out the options of the user and gets his input while
     * trying to catch an InputMissmatchException so the user can not type in
     * false inputs.
     *
     * @return answer -> Contains the answer what the user wants to do
     */
    public int spinAnswer(){

        int answer = 0;

        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Play ");
                drawBox(40, "2. End Game ");
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