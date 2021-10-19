package ch.noseryoung.plj;

import ch.noseryoung.plj.blackjack.BlackjackManager;
import ch.noseryoung.plj.roulette.RouletteManager;
import ch.noseryoung.plj.slots.SlotMachineManager;

public class CasinoManager {

    IO io = new IO();
    RouletteManager rm = new RouletteManager();
    BlackjackManager bjm = new BlackjackManager();
    SlotMachineManager sm = new SlotMachineManager();

    public void starter() {
        int answer = 0;

        while (answer != 4) {
            answer = io.startCasino();

            switch (answer) {
                case 1 -> rm.chooseBet();
                case 2 -> bjm.starter();
                case 3 -> sm.starter();
            }
        }

    }

}
