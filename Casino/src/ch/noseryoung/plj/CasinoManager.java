package ch.noseryoung.plj;

import ch.noseryoung.plj.blackjack.BlackjackManager;
import ch.noseryoung.plj.roulette.RouletteManager;
import ch.noseryoung.plj.slots.SlotMachineManager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class: CasinoManager
 * <p>
 * Function: Manages the return values from the IO_Casino class
 */
public class CasinoManager {

    Scanner sc = new Scanner(System.in);
    IO_Casino io = new IO_Casino();
    RouletteManager rm = new RouletteManager();
    BlackjackManager bjm = new BlackjackManager();
    SlotMachineManager sm = new SlotMachineManager();
    DatabaseConnection dbc;

    //Aggregation
    public CasinoManager(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public CasinoManager() {
    }

    /**
     * Method: starter
     * <p>
     * Function: calls chooseBet() Function
     */
    public void starter() {
        userAccount();
        chooseBet();
    }

    public void userAccount() {
        int answer = 0;

        while (answer != 4) {
            answer = io.userOptions();

            switch (answer) {
                case 1:
                    boolean madeAccount = dbc.insertData();
                    if (madeAccount) {
                        answer = 4;
                        break;
                    } else {
                        continue;
                    }

                case 2:
                    boolean isLoggedIn = dbc.loginUser();
                    if (isLoggedIn) {
                        answer = 4;
                        break;
                    } else {
                        continue;
                    }

                case 3:
                    dbc.deleteData();

                case 4:
                    System.exit(0);
            }
        }
    }

    /**
     * Method: chooseBet
     * <p>
     * Function: Calls method depending on return from io.startCasino method
     */
    public void chooseBet() {
        int answer = 0;
        rm.setUser(dbc.user);
        bjm.setUser(dbc.user);
        sm.setUser(dbc.user);


        while (answer != 4) {
            answer = io.startCasino();

            switch (answer) {
                case 1 -> rm.starter();
                case 2 -> bjm.starter();
                case 3 -> sm.starter();
                case 4 -> dbc.updateTable();
            }
        }
    }
}