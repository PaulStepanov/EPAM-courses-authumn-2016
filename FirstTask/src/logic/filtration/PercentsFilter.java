package logic.filtration;

import model.domain.Obligation;

public class PercentsFilter implements Filter {
    private double min;
    private double max;

    public PercentsFilter(double min, double max) {
        if (min > max) {
            this.min = max;
            this.max = min;
        } else {
            this.min = min;
            this.max = max;
        }

    }

    @Override
    public boolean isSatisfy(Obligation obl) {
        if (obl.getPercents() >= min && obl.getPercents() <= max) {
            return true;
        }
        return false;
    }

}
