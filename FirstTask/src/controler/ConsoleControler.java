package controler;

import domain.Deritative;
import logic.filtration.FiltratorImpl;
import logic.filtration.PercentsFilter;
import logic.filtration.PropertyFilter;
import logic.filtration.RiskFilter;
import logic.sorting.DescendingOrderSorter;
import logic.sorting.RiskComparator;
import storage.Storage;
import view.View;

import java.io.InputStream;
import java.util.Scanner;

public class ConsoleControler implements Controler {
    private InputStream iStream;
    private Storage storage;
    private View view;
    private Deritative deritative;

    public ConsoleControler(InputStream iStream, Storage storage, View view) {
        this.iStream = iStream;
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void selectDeritativeFromDB() {
        deritative = storage.getDertitative("testDeritative");
        view.renderMessage("Full deritative:");
        view.renderDeritative(deritative);
    }

    @Override
    public void countCost() {
        view.renderMessage("Deritative cost:" + deritative.CountCost());

    }

    @Override
    public void sortDeritative() {
        view.renderMessage("Sort in descending oreder by risk:");
        DescendingOrderSorter dSorter = new DescendingOrderSorter();
        view.renderObligations(dSorter.sort(deritative.getObligations(), new RiskComparator()));

    }

    @Override
    public void filterDeritative() {
        view.renderMessage("To filter by:\n" + "1-Percents\n" + "2-Property\n" + "3-Risk\n" + "4-Terms");
        Scanner scaner = new Scanner(iStream);
        FiltratorImpl fImpl = new FiltratorImpl(deritative.getObligations());
        int chosenNumber = scaner.nextInt();
        switch (chosenNumber) {
            case 1: {
                view.renderMessage("Filtering by percents.\n Enter min:");
                double min = scaner.nextDouble();
                view.renderMessage("Enter max:");
                double max = scaner.nextDouble();
                view.renderObligations(fImpl.filter(new PercentsFilter(min, max)));
                break;
            }
            case 2: {
                view.renderMessage("Filtering by property.\n Enter min:");
                int min = scaner.nextInt();
                view.renderMessage("Enter max:");
                int max = scaner.nextInt();
                view.renderObligations(fImpl.filter(new PropertyFilter(min, max)));
                break;
            }
            case 3: {
                view.renderMessage("Filtering by risk.\n Enter min:");
                double min = scaner.nextDouble();
                view.renderMessage("Enter max:");
                double max = scaner.nextDouble();
                view.renderObligations(fImpl.filter(new RiskFilter(min, max)));
                break;
            }
            case 4: {
                view.renderMessage("Filtering by risk.\n Enter min:");
                int min = scaner.nextInt();
                view.renderMessage("Enter max:");
                int max = scaner.nextInt();
                view.renderObligations(fImpl.filter(new RiskFilter(min, max)));
                break;
            }
            default:
                view.renderMessage("eneter valid number");
                break;
        }

    }

}
