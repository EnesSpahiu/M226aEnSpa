package ch.noseryoung.plj.roulette;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class: Roulette
 *
 * Function: Holds the winning number and sets it,
 * aswell the ArrayList of Numbers on the table
 */
public class Roulette {

    private ArrayList<Number> nums = new ArrayList();
    private Number winningNum;

    /**
     * Constructor: Roulette
     *
     * Function: Fills up ArrayList nums and sets winning number
     */
    public Roulette() {
        nums.add(new Number(Color.GREEN, 0));
        nums.add(new Number(Color.RED, 1));
        nums.add(new Number(Color.BLACK, 2));
        nums.add(new Number(Color.RED, 3));
        nums.add(new Number(Color.BLACK, 4));
        nums.add(new Number(Color.RED, 5));
        nums.add(new Number(Color.BLACK, 6));
        nums.add(new Number(Color.RED, 7));
        nums.add(new Number(Color.BLACK, 8));
        nums.add(new Number(Color.RED, 9));
        nums.add(new Number(Color.BLACK, 10));
        nums.add(new Number(Color.BLACK, 11));
        nums.add(new Number(Color.RED, 12));
        nums.add(new Number(Color.BLACK, 13));
        nums.add(new Number(Color.RED, 14));
        nums.add(new Number(Color.BLACK, 15));
        nums.add(new Number(Color.RED, 16));
        nums.add(new Number(Color.BLACK, 17));
        nums.add(new Number(Color.RED, 18));
        nums.add(new Number(Color.RED, 19));
        nums.add(new Number(Color.BLACK, 20));
        nums.add(new Number(Color.RED, 21));
        nums.add(new Number(Color.BLACK, 22));
        nums.add(new Number(Color.RED, 23));
        nums.add(new Number(Color.BLACK, 24));
        nums.add(new Number(Color.RED, 25));
        nums.add(new Number(Color.BLACK, 26));
        nums.add(new Number(Color.RED, 27));
        nums.add(new Number(Color.BLACK, 28));
        nums.add(new Number(Color.BLACK, 29));
        nums.add(new Number(Color.RED, 30));
        nums.add(new Number(Color.BLACK, 31));
        nums.add(new Number(Color.RED, 32));
        nums.add(new Number(Color.BLACK, 33));
        nums.add(new Number(Color.RED, 34));
        nums.add(new Number(Color.BLACK, 35));
        nums.add(new Number(Color.RED, 36));
    }

    public ArrayList<Number> getNums() {
        return nums;
    }

    public void setNums(ArrayList<Number> nums) {
        this.nums = nums;
    }

    public Number getWinningNum() {
        return winningNum;
    }

    public void setWinningNum(Number winningNum) {
        this.winningNum = winningNum;
    }
}