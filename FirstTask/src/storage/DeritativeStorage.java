package storage;

import domain.Deritative;
import domain.Obligation;
import domain.ObligationType;

import java.util.HashMap;

public class DeritativeStorage implements Storage {
    private HashMap<String, Deritative> deritatives = new HashMap<>();

    @Override
    public void addDeritative(String name, Deritative deritative) {
        deritatives.put(name, deritative);
    }

    @Override
    public Deritative getDertitative(String name) {
        return deritatives.get(name);
    }

    public DeritativeStorage() {
        Deritative deritative = new Deritative();
        Obligation obl = null;

        obl = new Obligation(ObligationType.PERSONAL);
        obl.setProperty(30000);
        obl.setRiskDegree(7.0);
        obl.setTerms(9);
        deritative.addObligation(obl);

        obl = new Obligation(ObligationType.CONTRACT_LABILITY);
        obl.setProperty(100000);
        obl.setRiskDegree(1.0);
        obl.setTerms(8);
        deritative.addObligation(obl);

        obl = new Obligation(ObligationType.HARM_CAUSING);
        obl.setProperty(100000);
        obl.setRiskDegree(9.0);
        obl.setTerms(3);
        deritative.addObligation(obl);

        obl = new Obligation(ObligationType.BUISENESS_RISK);
        obl.setProperty(500000);
        obl.setRiskDegree(15.0);
        obl.setTerms(12);
        deritative.addObligation(obl);

        deritatives.put("testDeritative", deritative);
    }
}
