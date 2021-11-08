package ch.noseryoung.plj;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DatabaseConnection {

    private Connection connection = null;
    private final String userName = "stduser";
    private final String password = "pwd";
    private final String URL = "jdbc:mariadb://localhost:3306/casino";
    private final String driver = "org.mariadb.jdbc.Driver";
    User user;
    Scanner sc = new Scanner(System.in);

    public DatabaseConnection() {
    }

    public void testConnection() {
        try {
            connection = DriverManager.getConnection(URL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getData() {
        String output = "";
        ArrayList<User> users = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL, userName, password);
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM accounts");
            while (rs.next()) {
                users.add(new User((String) rs.getObject(2), ((String) rs.getObject(3)),
                        (Double) rs.getObject(4), (String) rs.getObject(5)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return users;
    }

    public boolean insertData() {

        boolean madeAccount = false;
        boolean errorOccurred = true;
        double money = 0;
        int generatedKey = 0;
        ArrayList<User> users = new ArrayList<>();

        System.out.println("Enter your first name: ");
        String firstName = sc.nextLine();

        System.out.println("Enter your last name: ");
        String lastName = sc.nextLine();

        while (errorOccurred) {
            try {
                System.out.println("Enter your Balance: ");
                money = sc.nextDouble();
                sc.nextLine();
                errorOccurred = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Wrong Input");
                errorOccurred = true;
                sc.nextLine();
            }
        }

        System.out.println("Enter your password: ");
        String pwd = sc.nextLine();

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO accounts " + "VALUES ("+ generatedKey +", '" + firstName + "' , '" + lastName + "', '" + money + "', '" + pwd + "')",
                    Statement.RETURN_GENERATED_KEYS);

            ps.execute();

            madeAccount = true;

            System.out.println("Successfully Signed in");
            System.out.println("Welcome to our Casino");

            user = new User(firstName, lastName, money, pwd);

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMoney(money);
            user.setPassword(pwd);

        } catch (SQLException e){
            System.out.println("Something went wrong");
        }

        return madeAccount;
    }

    public void deleteData() {
        try {

            System.out.println("Type in first name of Account: (Look out for Capital letters)");
            String firstName = sc.nextLine();

            System.out.println("Type in last name of Account: (Look out for Capital letters)");
            String lastName = sc.nextLine();

            System.out.println("Type in password of Account: (Look out for Capital letters)");
            String pwd = sc.nextLine();

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(URL, userName, password);

            String query = "DELETE FROM accounts WHERE firstName='" + firstName + "' AND lastName='" + lastName + "' AND password='" + pwd + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute();

            System.out.println("User deleted");

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    public boolean loginUser() {
        boolean isLoggedIn = false;
        boolean wantsToStop = false;
        String firstName = " ";
        String lastName = " ";
        String pwd = " ";
        ArrayList<User> users;

        users = getData();

        try{
            while (!isLoggedIn) {
                System.out.println("Type in first name of Account or (s) to stop: (Look out for Capital letters)");
                firstName = sc.nextLine();

                if (firstName.toLowerCase().equals("s")){
                    break;
                }

                System.out.println("Type in last name of Account or (s) to stop: (Look out for Capital letters)");
                lastName = sc.nextLine();

                if (lastName.toLowerCase().equals("s")){
                    break;
                }

                System.out.println("Type in password of Account or (s) to stop: (Look out for Capital letters)");
                pwd = sc.nextLine();

                if (pwd.toLowerCase().equals("s")){
                    break;
                }

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getFirstName().equals(firstName) && users.get(i).getLastName().equals(lastName) && users.get(i).getPassword().equals(pwd)) {
                        isLoggedIn = true;
                        user = new User(users.get(i).getFirstName(), users.get(i).getLastName(), users.get(i).getMoney(), users.get(i).getPassword());

                        user.setFirstName(users.get(i).getFirstName());
                        user.setLastName(users.get(i).getLastName());
                        user.setMoney(users.get(i).getMoney());
                        user.setPassword(users.get(i).getPassword());

                        System.out.println(users.get(i).getMoney());
                        break;
                    } else {
                        isLoggedIn = false;
                    }
                }
                if (isLoggedIn){
                    System.out.println("Successfully logged in");
                }else {
                    System.out.println("There is no such user, try again");
                }
            }
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
        return isLoggedIn;
    }

    public void updateTable(){
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(URL, userName, password);

            String query = "UPDATE accounts SET money=" + user.getMoney() + " WHERE firstName='" + user.getFirstName() + "' AND lastName='" + user.getLastName() + "' AND password='" + user.getPassword() + "'";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.execute();

            System.out.println("Goodbye");

        }
        catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

}