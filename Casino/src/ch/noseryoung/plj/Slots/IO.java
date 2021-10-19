package ch.noseryoung.plj.Slots;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    Scanner sc = new Scanner(System.in);

    public int chooseAmount() {

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

            if (answer.toLowerCase().equals("s"))
                break;
            else if (answer.toLowerCase().equals("b"))
                System.exit(1);

        }while (true);

        return answer;
    }

}