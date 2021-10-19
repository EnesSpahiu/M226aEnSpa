package ch.noseryoung.plj.Roulette;

public class Number {

    private Color color;
    private int num;

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