package logic.filtration;

import domain.Obligation;

public class TermsFilter implements Filter {
    private int min;
    private int max;

    public TermsFilter(int min, int max) {
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
        if (obl.getTerms() >= min && obl.getTerms() <= max) {
            return true;
        }
        return false;
    }

}
