package ch.noseryoung.plj.slots;

import ch.noseryoung.plj.DatabaseConnection;
import ch.noseryoung.plj.User;

import java.util.HashMap;
import java.util.Random;

/**
 * Class: SlotMachineManager
 *
 * Function: Manages the return Values from IO_Slots
 */
public class SlotMachineManager {

    Random rand = new Random();
    IO_Slots io = new IO_Slots();
    User user;

    private int[] winningNums = new int[3];
    private HashMap<Integer, String> winningVals = new HashMap();
    private double money;

    /**
     * Constructor: SlotMachineManager
     *
     * Function: Fills up HashMap when it gets builded
     */
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

    /**
     * Method: starter
     *
     * Function: Calls method depending on return from ioSlots.spinAnswer method
     */
    public void starter(){

        int answer = 0;

        io.setUser(user);

        answer = io.spinAnswer();

        if (answer == 1){
            money = io.chooseAmount();
            spin();
        }else if (answer == 2){
            money = 0;
        }
    }

    /**
     * Method: spin
     *
     * Function: Generates random numbers in the bound of the HashMap keys and then gets
     * their value and prints it aut. It also lets the thread sleep for 50 seconds and
     * then makes some '\b' so it simulates a spin
     */
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

    /**
     * Method: checkSlots
     *
     * Function: Checks if the user won or not and also tries to catch an
     * IndexOutOfBoundsException
     */
    public void checkSlots(){

        for (int i = 0; i < winningNums.length; i++) {
            try {
                if (winningNums[i] == winningNums[i + 1] && winningNums[i] == winningNums[i + 2]){
                    System.out.println("You Won this round");
                    money *= 50;
                    System.out.println("You won: " + money);
                    user.setMoney(user.getMoney() + money);
                    break;
                } else {
                    System.out.println("You lost this round");
                    System.out.println("You lost: " + money);
                    user.setMoney(user.getMoney() - money);
                    break;
                }
            } catch (IndexOutOfBoundsException e){
            }
        }
    }

    public void setUser(User user){
        this.user = user;
    }
}