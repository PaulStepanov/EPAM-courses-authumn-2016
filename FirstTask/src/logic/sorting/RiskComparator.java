package logic.sorting;

import domain.Obligation;

import java.util.Comparator;

public class RiskComparator implements Comparator<Obligation> {

    @Override
    public int compare(Obligation o1, Obligation o2) {
        if (o1.getRiskDegree() > o2.getRiskDegree()) {
            return 1;
        } else if (o1.getRiskDegree() < o2.getRiskDegree()) {
            return -1;
        } else {
            return 0;
        }
    }

}
