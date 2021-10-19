package ch.noseryoung.plj.slots;

import java.util.HashMap;
import java.util.Random;

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

        int answer = 0;

        answer = io.spinAnswer();

        if (answer == 1){
            money = io.chooseAmount();
            spin();
        }else if (answer == 2){
            money = 0;
        }
    }

    public void spin(){
        for (int i = 0; i < 100; i++) {

            System.out.print(winningVals.get(rand.nextInt(8)) + " " +
                    winningVals.get(rand.nextInt(8)) + " " + winningVals.get(rand.nextInt(8)));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
            System.out.print("\b".repeat(50));
        }

        for (int i = 0; i < winningNums.length; i++) {
            winningNums[i] = rand.nextInt(7 + 1);
            System.out.print(winningVals.get(winningNums[i]) + " ");
        }
        System.out.println();
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
                } else {
                    System.out.println("You lost");
                }
            } catch (IndexOutOfBoundsException e){
            }
        }
    }
}