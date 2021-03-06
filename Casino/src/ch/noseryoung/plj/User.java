package ch.noseryoung.plj;

public class User {

    private String firstName;
    private String lastName;
    private double money;
    private String password;

    public User(String firstName, String lastName, double money, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
        this.password = password;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
