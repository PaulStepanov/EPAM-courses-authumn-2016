package domain;

import java.util.ArrayList;

public class Deritative {
    private ArrayList<Obligation> obligations = new ArrayList<>();

    public void addObligation(Obligation obl) {
        obligations.add(obl);
    }

    public int CountCost() {
        int cost = 0;
        for (Obligation obl : obligations) {
            cost += obl.getCost();
        }
        return cost;
    }

    public ArrayList<Obligation> getObligations() {
        return (ArrayList<Obligation>) obligations.clone();
    }

}
