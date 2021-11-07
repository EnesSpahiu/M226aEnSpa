package ch.noseryoung.plj.roulette;

/**
 * Class: Number
 *
 * Function: Is a POJO for the numbers
 */
public class Number {

    private Color color;
    private int num;

    /**
     * Constructor: Number
     *
     * Function: Makes objects out of the fields
     *
     * @param color -> Attribute of Number
     * @param num -> Attribute of Number
     */
    public Number(Color color, int num) {
        this.color = color;
        this.num = num;
    }

    public Number(){

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

}