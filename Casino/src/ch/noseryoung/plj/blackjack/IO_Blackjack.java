package ch.noseryoung.plj.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    Scanner sc = new Scanner(System.in);

    public int playGame(){

        int answer = 0;
        boolean errorOccurred = true;

        while (errorOccurred){
            try {
                drawBox(40, "1. Play ");
                drawBox(40, "2. End game ");
                answer = Integer.parseInt(sc.nextLine());
                errorOccurred = false;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }
        return answer;
    }

    public int betMoney(){
        int money = 0;
        boolean errorOccurred = false;

        do {
            try {
                System.out.println("Type in the amount you want to bet: ");
                money = Integer.parseInt(sc.nextLine());
                errorOccurred = false;
            }catch (NumberFormatException | InputMismatchException e){
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }while(errorOccurred);
        return money;
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