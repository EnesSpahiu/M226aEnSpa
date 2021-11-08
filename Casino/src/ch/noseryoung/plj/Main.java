package ch.noseryoung.plj;

public class Main {

    public static void main(String[] args) {
        DatabaseConnection dbc = new DatabaseConnection();
        CasinoManager cm = new CasinoManager(dbc);

        dbc.testConnection();


        cm.starter();
    }
}