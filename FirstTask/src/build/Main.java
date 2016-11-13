package build;

import controler.ConsoleControler;
import controler.Controler;
import storage.DeritativeStorage;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        Controler controler = new ConsoleControler(System.in, new DeritativeStorage(), new ConsoleView());

        controler.selectDeritativeFromDB();
        controler.countCost();
        controler.sortDeritative();
        while (true)
            controler.filterDeritative();
    }

}
