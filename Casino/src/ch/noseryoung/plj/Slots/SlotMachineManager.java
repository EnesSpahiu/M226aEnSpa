package ch.noseryoung.plj.Slots;

import ch.noseryoung.plj.Slots.IO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SlotMachineManager {

    Random rand = new Random();
    IO io = new IO();

    private int[] winningNums = new int[3];
    private HashMap<Integer, String> winningVals = new HashMap();
    private int money;

    public SlotMachineManager() {

        winningVals.put(0, "🍉");
        winningVals.put(1, "🍒");
        winningVals.put(2, "🔔");
        winningVals.put(3, "💎");
        winningVals.put(4, "🍊");
        winningVals.put(5, "🍋");
        winningVals.put(6, "🥝");
        winningVals.put(7, "7️⃣");

    }

    public void starter(){

        String answer = " ";

        money = io.chooseAmount();
        answer = io.spinAnswer();

        if (answer.toLowerCase().equals("s")){
            spin();
        }else if (answer.toLowerCase().equals("b")){
            money = 0;
        }
    }

    public void spin(){
        for (int i = 0; i < 100; i++) {

            System.out.print(winningVals.get(rand.nextInt(8)) + " " +
                    winningVals.get(rand.nextInt(8)) + " " + winningVals.get(rand.nextInt(8)));
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
            }
            System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        }

        for (int i = 0; i < winningNums.length; i++) {
            winningNums[i] = rand.nextInt(7 + 1);
            System.out.print(winningVals.get(winningNums[i]) + " ");
        }

        checkSlots();

    }

    public void checkSlots(){

        int tmp = 0;

        for (int i = 0; i < winningNums.length; i++) {
            try {
                if (winningNums[i] == winningNums[i + 1] && winningNums[i] == winningNums[i + 2]){
                    System.out.println("You Won");
                    money *= 2;
                    System.out.println("You won " + money);
                }
            } catch (IndexOutOfBoundsException e){
            }
        }
    }
}