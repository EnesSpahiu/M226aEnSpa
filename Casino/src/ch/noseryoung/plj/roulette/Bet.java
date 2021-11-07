package ch.noseryoung.plj.roulette;

/**
 * Class: Bet
 *
 * Function: Is a POJO for the bet numbers
 */
public class Bet {

    private int num;
    private double bet;

    /**
     * Constructor: Number
     *
     * Function: Makes objects out of the fields
     *
     * @param num -> Attribute of Number
     * @param bet -> Attribute of Number
     */
    public Bet(int num, double bet) {
        this.num = num;
        this.bet = bet;
    }

    public Bet() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getBet() {
        return bet;
    }

    public void setBet(double bet) {
        this.bet = bet;
    }
}
