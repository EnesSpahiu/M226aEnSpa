package ch.noseryoung.plj.Roulette;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Roulette {

    Scanner sc = new Scanner(System.in);

    java.lang.Number number = new java.lang.Number();

    private ArrayList<java.lang.Number> nums = new ArrayList();
    private java.lang.Number winningNum;

    public Roulette() {

        nums.add(new java.lang.Number(Color.GREEN, 0));
        nums.add(new java.lang.Number(Color.RED, 1));
        nums.add(new java.lang.Number(Color.BLACK, 2));
        nums.add(new java.lang.Number(Color.RED, 3));
        nums.add(new java.lang.Number(Color.BLACK, 4));
        nums.add(new java.lang.Number(Color.RED, 5));
        nums.add(new java.lang.Number(Color.BLACK, 6));
        nums.add(new java.lang.Number(Color.RED, 7));
        nums.add(new java.lang.Number(Color.BLACK, 8));
        nums.add(new java.lang.Number(Color.RED, 9));
        nums.add(new java.lang.Number(Color.BLACK, 10));
        nums.add(new java.lang.Number(Color.BLACK, 11));
        nums.add(new java.lang.Number(Color.RED, 12));
        nums.add(new java.lang.Number(Color.BLACK, 13));
        nums.add(new java.lang.Number(Color.RED, 14));
        nums.add(new java.lang.Number(Color.BLACK, 15));
        nums.add(new java.lang.Number(Color.RED, 16));
        nums.add(new java.lang.Number(Color.BLACK, 17));
        nums.add(new java.lang.Number(Color.RED, 18));
        nums.add(new java.lang.Number(Color.RED, 19));
        nums.add(new java.lang.Number(Color.BLACK, 20));
        nums.add(new java.lang.Number(Color.RED, 21));
        nums.add(new java.lang.Number(Color.BLACK, 22));
        nums.add(new java.lang.Number(Color.RED, 23));
        nums.add(new java.lang.Number(Color.BLACK, 24));
        nums.add(new java.lang.Number(Color.RED, 25));
        nums.add(new java.lang.Number(Color.BLACK, 26));
        nums.add(new java.lang.Number(Color.RED, 27));
        nums.add(new java.lang.Number(Color.BLACK, 28));
        nums.add(new java.lang.Number(Color.BLACK, 29));
        nums.add(new java.lang.Number(Color.RED, 30));
        nums.add(new java.lang.Number(Color.BLACK, 31));
        nums.add(new java.lang.Number(Color.RED, 32));
        nums.add(new java.lang.Number(Color.BLACK, 33));
        nums.add(new java.lang.Number(Color.RED, 34));
        nums.add(new java.lang.Number(Color.BLACK, 35));
        nums.add(new java.lang.Number(Color.RED, 36));

        setWinningNum(nums.get(ThreadLocalRandom.current().nextInt(0, 36 + 1)));
    }

    public ArrayList<java.lang.Number> getNums() {
        return nums;
    }

    public void setNums(ArrayList<java.lang.Number> nums) {
        this.nums = nums;
    }

    public java.lang.Number getWinningNum() {
        return winningNum;
    }

    public void setWinningNum(java.lang.Number winningNum) {
        this.winningNum = winningNum;
    }
}