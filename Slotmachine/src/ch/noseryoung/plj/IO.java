package ch.noseryoung.plj;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    Scanner sc = new Scanner(System.in);

    public int chooseAmpunt() {

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
            }
        }while(errorOccurred);
        return money;
    }

    public String spinAnswer(){

        String answer = " ";

        do {
            System.out.println("Type 'S' to spin or press 'B' to back out: ");
            answer = sc.nextLine();
        }while (!answer.toLowerCase().equals("s") || !answer.toLowerCase().equals("b"));

        return answer;
    }

}